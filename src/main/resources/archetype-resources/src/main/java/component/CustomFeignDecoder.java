#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 *
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

package ${package}.component;

import ${package}.constant.Constants;
import ${package}.constant.LogConstants;
import ${package}.exception.custom.DownstreamException;
import ${package}.util.Util;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * Clase que implementa el ErrorDecoder para feign.
 *
 * <p>Se modifica el tratamiento de las excepciones producidas al consumir un API externa.
 *
 * @author Nova Solution Systems.
 */
@Slf4j
@Component
@AllArgsConstructor
public class CustomFeignDecoder implements ErrorDecoder {

  /**
   * Instancia del codec errorDecoder para procesar las respuestas erroneas.
   */
  private final ErrorDecoder errorDecoder;

  /**
   * Instancia para mapear objetos json.
   */
  private final ObjectMapper objectMapper;

  /**
   * Instancia para efectuar operaciones con json e impresion de headers.
   */
  private final Util utilTool;

  /**
   * Metodo que trata la excepcion recibida y la transforma en un objeto del tipo
   * {@link DownstreamException}.
   *
   * @param methodKey Contiene el nombre del metodo.
   * @param response Contiene el Http estatus, el body del request y response.
   * @return Devuelve un objeto del tipo {@link DownstreamException} con la nueva excepcion.
   */
  @Override
  public Exception decode(String methodKey, Response response) {
    if (Objects.isNull(response.body())) {
      log.error(LogConstants.MSG_CURLY_BRACKETS, LogConstants.MSG_ERROR_RESPONSE_HAS_NO_BODY);

      return errorDecoder.decode(methodKey, response);
    }

    Map<String, String> errorResponse;

    try {
      final var body = feign.Util.toString(response.body().asReader(StandardCharsets.UTF_8));

      errorResponse = objectMapper.readValue(body, new TypeReference<Map<String, String>>() {});
    } catch (IOException ex) {
      log.error(LogConstants.MSG_ERROR_FORMAT, ex);

      return errorDecoder.decode(methodKey, response);
    }

    var status = HttpStatus.valueOf(response.status());

    var map = new HashMap<String, Object>();

    map.put(Constants.MSG_STATUS, status.value());
    map.put(Constants.MSG_REQUEST, utilTool.getJson(response.request()));
    map.put(Constants.MSG_RESPONSE, utilTool.getJson(errorResponse));

    var mapString = utilTool.getJson(map);

    log.debug(LogConstants.ERROR_FEIGN_DETAILS, mapString);

    return new DownstreamException(status.value(), errorResponse);
  }
}
