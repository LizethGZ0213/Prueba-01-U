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
import java.util.HashMap;
import java.util.Map;

/**
 * Clase para el mapeo de los datos de las excepciones.
 *
 * @author Nova Solution Systems.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExceptionMapper {

  /**
   * Detalle del error.
   *
   * @return Devuelve el detalle con el error.
   */
  public static Map<String, String> errorsDownstream() {
    Map<String, String> errorResponse = new HashMap<>();

    errorResponse.put(Constants.ERROR_RESPONSE_DETAILS, "details");
    errorResponse.put(Constants.ERROR_RESPONSE_TYPE, "type");
    errorResponse.put(Constants.ERROR_RESPONSE_CODE, "code");
    errorResponse.put(Constants.ERROR_RESPONSE_LOCATION, "location");
    errorResponse.put(Constants.ERROR_RESPONSE_MORE_INFORMATION, "more information");
    errorResponse.put(Constants.UUID, "uuid");
    errorResponse.put(Constants.ERROR_RESPONSE_TIMESTAMP, "2022-08-30T16:35:42.213+0530");

    return errorResponse;
  }
}
