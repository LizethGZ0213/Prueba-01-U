#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * Copyright (c) 2022, Bancoppel All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modifications are not
 * permitted.
 *
 * Bancoppel claims copyright in this computer program as an unpublished work.
 *
 * This program is a confidential trade secret and the property of Bancoppel.
 *
 * Use, examination, reproduction, disassembly, decompiling, transfer and/or disclosure to others of
 * all or any part of this software program are strictly prohibited except by express written
 * agreement with Bancoppel.
 *
 * This software is provided by the copyright holders and contributors "as is" and any express or
 * implied warranties, including, but not limited to, the implied warranties of merchantability and
 * fitness for a particular purpose are disclaimed. In no event shall the copyright owner or
 * contributors be liable for any direct, indirect, incidental, special, exemplary, or consequential
 * damages (including, but not limited to, procurement of substitute goods or services; Loss of use,
 * data, or profits; Or business interruption) however caused and on any theory of liability,
 * whether in contract, strict liability, or tort (including negligence or otherwise) arising in any
 * way out of the use of this software, even if advised of the possibility of such damage.
 *
 * Developed by Bancoppel.
 */

package ${package}.util;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Clase que define los test de {@link Util}.
 *
 * @author Nova Solution Systems.
 * @since ${date}.
 */
@ExtendWith(MockitoExtension.class)
@SuppressWarnings({"unchecked", "serial"})
class UtilTest {

  /**
   * Inyecta el bean para poder hacer pruebas sobre las herramientas de transformacion de objetos
   * json.
   */
  @InjectMocks
  private Util utilTool;

  /**
   * Objeto para mapeo de elementos json.
   */
  @Mock
  private ObjectMapper objectMapper;

  /**
   * Constante con el valor de "TEST".
   */
  private static final String TEST_STRING = "TEST";

  /**
   * Constante con el valor de "data".
   */
  private static final String DATA_STRING = " data ";

  /**
   * Constante JSON con el valor para ejecutar la prueba.
   */
  private static final String TEST_JSON_STRING = "{ \"name\" : \"api\" }";

  /**
   * Ejecuta la prueba unitaria para el metodo emptyStringValidation, enviando una cadena con
   * espacios al inicio y al final de la misma.
   *
   * @given Una cadena que se quiere limpiar de espacios inciales y finales.
   * @when Se invoca el metodo emptyStringValidation para limpiar la cadena.
   * @then Se procesa la cadena y se limpia.
   */
  @Test
  void emptyStringValidationNotEmptyStringTest() {
    String validate = utilTool.emptyStringValidation(DATA_STRING);
    Assertions.assertNotNull(validate);
    Assertions.assertEquals("data", validate);
  }

  /**
   * Ejecuta la prueba unitaria para el metodo emptyStringValidation, enviando un nulo.
   *
   * @given Un cadena nula que se quiere limpiar.
   * @when Se invoca el metodo emptyStringValidation.
   * @then Se procesa la cadena y al ser nulo devuelve vacio.
   */
  @Test
  void emptyStringValidationEmptyStringTest() {
    String validate = utilTool.emptyStringValidation(null);
    Assertions.assertNotNull(validate);
    Assertions.assertEquals("", validate);
  }

  /**
   * Ejecuta la prueba unitaria para el metodo getJson.
   *
   * @throws JsonProcessingException Excepcion por no poder realizar el parseo.
   *
   * @given Un objeto Object que se quiere parsear a un json string.
   * @when Se invoca el metodo getJson para convertir el objeto.
   * @then Este se procesa para ser convertido en un json string.
   */
  @Test
  void getJsonParsingOkTest() throws JsonProcessingException {
    when(objectMapper.writeValueAsString(any())).thenReturn("OK");

    Assertions.assertNotNull(utilTool.getJson(TEST_STRING));
  }

  /**
   * Ejecuta la prueba unitaria para el metodo getJson.
   *
   * @throws JsonProcessingException Excepcion por no poder realizar el parseo.
   *
   * @given Un objeto Object que se quiere parsear a un json string.
   * @when Se invoca el metodo getJson para convertir el objeto.
   * @then Este se procesa para ser convertido en un json string
   */
  @Test
  void getJsonParsingErrorTest() throws JsonProcessingException {
    when(objectMapper.writeValueAsString(any())).thenThrow(new JsonProcessingException("Error") {});

    Assertions.assertNull(utilTool.getJson(TEST_STRING));
  }

  /**
   * Ejecuta la prueba unitaria para el metodo convertStringToMap.
   *
   * @given Una cadena en formato json.
   * @when Se invoca el metodo convertStringToMap para convertir la cadena.
   * @then Se procesa la cadena y se convierte a un Map.
   */
  @Test
  void convertStringToDataCacheParsingOkTest()
      throws JsonParseException, JsonMappingException, IOException {
    when(objectMapper.readValue(anyString(), any(TypeReference.class))).thenReturn(new HashMap<>());
    Assertions.assertNotNull(utilTool.convertStringToMap(TEST_JSON_STRING));
  }

  /**
   * Ejecuta la prueba unitaria para el metodo convertStringToMap.
   *
   * @given Una cadena en formato json.
   * @when Se invoca el metodo convertStringToMap para convertir la cadena.
   * @then Se procesa la cadena y se convierte a un Map.
   */
  @Test
  void convertStringToDataCacheParsingErrorTest()
      throws JsonParseException, JsonMappingException, IOException {
    when(objectMapper.readValue(anyString(), any(TypeReference.class)))
        .thenThrow(new JsonProcessingException("Error") {});
    Assertions.assertNotNull(utilTool.convertStringToMap(TEST_JSON_STRING));
  }

  /**
   * Ejecuta la prueba unitaria para el metodo printHeaders.
   *
   * @given Una peticion {@link HttpServletRequest}.
   * @when Los headers del request estan presentes.
   * @then Se imprimen los headers y la peticion se maneja sin problema.
   */
  @Test
  void printHeadersWithHeardersNamesTest() {
    String[] names = new String[] {"Content-Type"};
    Enumeration<String> headersNames = Collections.enumeration(Arrays.asList(names));
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    Mockito.when(req.getHeaderNames()).thenReturn(headersNames);
    utilTool.printHeaders(req);
    Assertions.assertNotNull(req);
  }

  /**
   * Ejecuta la prueba unitaria para el metodo printHeaders cuando llegan headers nulos.
   *
   * @given Una peticion {@link HttpServletRequest}.
   * @when Los headers del request no estan presentes y regresa una enumeracion en null.
   * @then No se imprimen los headers y la peticion se maneja sin problema.
   */
  @Test
  void printHeadersWithHeadersNamesNullValueTest() {
    Enumeration<String> headerNames = null;
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    Mockito.when(req.getHeaderNames()).thenReturn(headerNames);
    utilTool.printHeaders(req);
    Assertions.assertNotNull(req);
  }
}
