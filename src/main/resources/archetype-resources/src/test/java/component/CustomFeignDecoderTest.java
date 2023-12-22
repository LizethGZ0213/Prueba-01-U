#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * Copyright (c) 2022, Bancoppel
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modifications are not permitted.
 *
 * Bancoppel claims copyright in this computer program as an unpublished work.
 *
 * This program is a confidential trade secret and the property of Bancoppel.
 *
 * Use, examination, reproduction, disassembly, decompiling, transfer and/or
 * disclosure to others of all or any part of this software program are
 * strictly prohibited except by express written agreement with Bancoppel.
 *
 * This software is provided by the copyright holders and contributors "as is"
 * and any express or implied warranties, including, but not limited to, the
 * implied warranties of merchantability and fitness for a particular purpose
 * are disclaimed. In no event shall the copyright owner or contributors be
 * liable for any direct, indirect, incidental, special, exemplary, or
 * consequential damages (including, but not limited to, procurement of
 * substitute goods or services; Loss of use, data, or profits; Or business
 * interruption) however caused and on any theory of liability, whether in
 * contract, strict liability, or tort (including negligence or otherwise)
 * arising in any way out of the use of this software, even if advised of the
 * possibility of such damage.
 *
 * Developed by Bancoppel.
 */

package ${package}.component;

import ${package}.mapper.ExceptionMapper;
import ${package}.mapper.HeadersMapper;
import ${package}.util.Util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.InputCoercionException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Request;
import feign.Request.Body;
import feign.Request.HttpMethod;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Map;

/**
 * Clase que implementa las pruebas unitarias para la clase {@link CustomFeignDecoder}.
 *
 * @author Nova Solution Systems.
 * @since ${package.getClass().forName("java.time.LocalDateTime").getMethod("now").invoke(null).format($package.Class.forName("java.time.format.DateTimeFormatter").getMethod("ofPattern", $package.Class).invoke(null, "dd.MM.yyyy"))}.
 */
@ExtendWith(MockitoExtension.class)
@SuppressWarnings("unchecked")
class CustomFeignDecoderTest {

  /**
   * Instancia y crea un bean CustomFeignErrorDecoder para poder ejecutar las pruebas sobre el
   * mismo.
   **/
  @InjectMocks
  private CustomFeignDecoder customFeignErrorDecoder;

  /**
   * Crea un ObjectMapper para el manejo de objetos en formato json.
   **/
  @Mock
  private ObjectMapper mockedMapper;

  /**
   * Crea un objeto del tipo ErrorDecoder para poder decodificar la excepcion producida.
   **/
  @Mock
  private ErrorDecoder errorDecoder;

  /**
   * Crea un objeto util para manejar las estructuras json.
   **/
  @Mock
  private Util utilTool;

  /**
   * Variable que contiene los headers de la peticion.
   */
  private Map<String, Collection<String>> headers;

  /**
   * Variable que contiene el request de la peticion.
   */
  private Request request;

  /**
   * Variable que contiene el body de respuesta con error del cliente feign.
   */
  private String body;

  /**
   * Variable que contiene la razon del error de la invocacion.
   */
  private String reason;

  /**
   * Variable que contiene el nombre del metodo que invoca la peticion.
   */
  private String methodKey;

  /**
   * Variable que contiene la url que se invoca desde el cliente feign.
   */
  private String url;

  /**
   * Metodo inicializador de variables.
   */
  @BeforeEach
  public void setUp() {
    body = "{\"type\":\"ERROR\",\"code\":\"API-401\",\"details\":\"Not Authorized\","
        + "\"location\":\"\\/api\\/private\\/v1\\/channels\\/test\\/accounts\\/balance\","
        + "\"moreInfo\":\"\",\"uuid\":\"uuid1\",\"timestamp\":\"2018-09-17T19:34:03-0500\"}";

    reason = "HTTP/1.1 401 \ncontent-type: application/json;charset=UTF-8\n"
        + "date: Wed, 05 Sep 2018 16:40:33 GMT\ntransfer-encoding: chunked\n"
        + "x-application-context: microservice:1000\n\n" + "feign.okhttp.OkHttpClient$1@3b9d3aa8";

    methodKey = "testMethod";

    url = "http://api/v1/channel/test";

    headers = HeadersMapper.empty();

    request = Request.create(HttpMethod.GET, url, headers,
        Body.create(body, Charset.defaultCharset()), null);
  }

  /**
   * Ejecuta el test para el metodo decode del Error Decoder y el body de respuesta es nulo.
   *
   * @given Una respuesta HTTP con error de un llamado feign.
   * @when Se valida si el body de respuesta es nulo.
   * @then Se dispara un excepcion IOException.
   */
  @Test
  void decodeWithResponseBodyIsNullTest() {
    Response response = Response.builder().reason(reason).status(HttpStatus.BAD_REQUEST.value())
        .headers(headers).body(null, Charset.defaultCharset()).request(request).build();

    customFeignErrorDecoder.decode(methodKey, response);

    Assertions.assertNotNull(response);
  }

  /**
   * Ejecuta el test para el metodo decode del Error Decoder y el body de respuesta no es nulo.
   *
   * @throws JsonProcessingException Error al procesar el objeto json.
   * @throws JsonMappingException Error en la transformacion de objeto.
   *
   * @given Una respuesta HTTP con error de un llamado feign.
   * @when Se valida que el body de respuesta no es nulo, se imprime la respuesta de error.
   * @then Se dispara una excepcion {@link DownstreamException}.
   */
  @Test
  void decodeWithResponseBodyIsNotNullTest() throws JsonMappingException, JsonProcessingException {
    Response response = Response.builder().reason(reason).status(HttpStatus.BAD_REQUEST.value())
        .headers(headers).body(body, Charset.defaultCharset()).request(request).build();
    Map<String, String> errorResponse = ExceptionMapper.errorsDownstream();
    Mockito.when(mockedMapper.readValue(Mockito.anyString(), Mockito.any(TypeReference.class)))
        .thenReturn(errorResponse);

    customFeignErrorDecoder.decode(methodKey, response);

    Assertions.assertNotNull(response);
  }

  /**
   * Ejecuta el test para el metodo decode del Error Decoder y el body de respuesta no es nulo pero
   * el object mapper no puede parsear la respuesta.
   *
   * @throws JsonProcessingException Error al procesar el objeto json.
   * @throws JsonMappingException Error en la transformacion de objeto.
   *
   * @given Una respuesta HTTP con error de un llamado feign.
   * @when Se valida que el body de respuesta no es nulo, se imprime la respuesta de error.
   * @then Se dispara una excepcion {@link DownstreamException}.
   */
  @Test
  void decodeWithResponseBodyIsNotNullAndObjectMapperErrorTest()
      throws JsonMappingException, JsonProcessingException {
    Response response = Response.builder().reason(reason).status(HttpStatus.BAD_REQUEST.value())
        .headers(headers).body(body, Charset.defaultCharset()).request(request).build();
    Mockito.when(mockedMapper.readValue(Mockito.anyString(), Mockito.any(TypeReference.class)))
        .thenThrow(new InputCoercionException(null, "Exception", null, null));
    customFeignErrorDecoder.decode(methodKey, response);

    Assertions.assertNotNull(response);
  }
}
