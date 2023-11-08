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

import ${package}.constant.LogConstants;
import ${package}.constant.SpecialCharacterConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * Clase de utilerias en la que se requieran agregar funcionalidades especificas.
 *
 * @author Nova Solution Systems.
 */
@Slf4j
@Component
@AllArgsConstructor
public class Util {

  /**
   * Bean para mapear objetos json.
   */
  private ObjectMapper objectMapper;

  /**
   * Valida el contenido de un string y lo inicializa en vacio en caso de ser nulo.
   *
   * @param stringToValidate Cadena que se va a validar.
   * @return Devuelve la cadena formateada, elimina los espacios en blanco, o en su defecto devuelve
   *         una cadena vacia.
   */
  public String emptyStringValidation(String stringToValidate) {
    if (ObjectUtils.isEmpty(stringToValidate)) {
      stringToValidate = SpecialCharacterConstants.EMPTY_STRING;
    } else {
      stringToValidate = stringToValidate.trim();
    }

    return stringToValidate;
  }

  /**
   * Convierte un objeto a un string con formato json.
   *
   * @param object Objeto a ser convertido.
   * @return Cadena que representa el objeto serializado en formato json.
   */
  public String getJson(Object object) {
    String jsonString = null;

    try {
      jsonString = objectMapper.writeValueAsString(object);
    } catch (JsonProcessingException ex) {
      log.error(ex.getMessage(), ex);
    }

    return jsonString;
  }

  /**
   * Convierte una cadena de formato json a un Map.
   *
   * @param jsonString Cadena en formato json que sera convertida.
   * @return Map que contiene los datos del json en formato clave-valor.
   */
  public Map<String, String> convertStringToMap(String jsonString) {
    Map<String, String> dataMap = new HashMap<>();

    try {
      dataMap = objectMapper.readValue(jsonString, new TypeReference<Map<String, String>>() {});
    } catch (IOException ex) {
      log.error(ex.getMessage(), ex);
    }

    return dataMap;
  }

  /**
   * Metodo para imprimir los headers de la peticion http.
   *
   * @param request Objeto de la peticion http.
   */
  public void printHeaders(HttpServletRequest request) {
    var headerNames = request.getHeaderNames();

    if (Objects.nonNull(headerNames)) {
      while (headerNames.hasMoreElements()) {
        var key = headerNames.nextElement();

        log.info(LogConstants.MSG_TO_LOG_HEADER, key, request.getHeader(key));
      }
    }
  }
}
