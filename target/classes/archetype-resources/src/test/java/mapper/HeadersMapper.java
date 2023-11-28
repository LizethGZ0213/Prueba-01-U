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

package ${package}.mapper;

import ${package}.constant.Constants;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase para el mapeo de los headers para las solicitudes.
 *
 * @author Nova Solution Systems.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HeadersMapper {

  /**
   * Mapa de headers vacio.
   *
   * @return Devuelve un mapa con la coleccion de headers vacio.
   */
  public static Map<String, Collection<String>> empty() {
    return new HashMap<String, Collection<String>>();
  }

  /**
   * Datos default para ser enviados en los headers de las peticiones.
   *
   * @return Devuelve los headers.
   */
  public static HttpHeaders defaults() {
    HttpHeaders headers = new HttpHeaders();

    headers.add(Constants.DATE, "112233");
    headers.add(Constants.ACCEPT, "112233");
    headers.add(Constants.ACCEPT_CHARSET, "112233");
    headers.add(Constants.ACCEPT_ENCODING, "112233");
    headers.add(Constants.ACCEPT_LANGUAGE, "112233");
    headers.add(Constants.AUTHORIZATION, "112233");
    headers.add(Constants.HOST, "112233");
    headers.add(Constants.USER_AGENT, "PostmanRuntime/7.28.4");
    headers.add(Constants.CONTENT_ENCODING, "112233");
    headers.add(Constants.CONTENT_LANGUAGE, "112233");
    headers.add(Constants.CONTENT_LENGTH, "112233");
    headers.add(Constants.CONTENT_MD5, "123456");
    headers.add(Constants.CONTENT_TYPE, "BEX");
    headers.add(Constants.UUID, "BEX");

    return headers;
  }
}
