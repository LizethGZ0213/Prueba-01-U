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

package ${package}.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Clase de constantes para loguear trazas en el aplicativo.
 *
 * @author Nova Solution Systems.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LogConstants {

  /**
   * constante para representar el request.
   */
  public static final String REQUEST = "Request:{}";

  /**
   * Constante que representa el tipo de error.
   */
  public static final String ERROR_TYPE = "type: {}";

  /**
   * Constante que representa el codigo de error.
   */
  public static final String ERROR_CODE = "code: {}";

  /**
   * Constante que representa el detalle del error.
   */
  public static final String ERROR_DETAILS = "details: {}";

  /**
   * Constante que representa la URI invocada.
   */
  public static final String ERROR_LOCATION = "location: {}";

  /**
   * Constante que representa informacion adicional del error.
   */
  public static final String ERROR_MORE_INFORMATION = "moreInfo: {}";

  /**
   * Constante para imprimir los headers de la peticion.
   */
  public static final String MSG_TO_LOG_HEADER = "[{} : {}]";

  /**
   * Constante para mostrar el inicio de la peticion.
   */
  public static final String START_REQUEST = "Inicia Llamado [{}]";

  /**
   * Constante para mostrar el tiempo de peticion y respuesta.
   */
  public static final String TIME_ELAPSED_MESSAGE =
      "Time elapsed for request/response roundtrip [{}], {} ms";

  /**
   * Constante que repsenta la cadena "{}".
   */
  public static final String MSG_CURLY_BRACKETS = "{}";

  /**
   * Constante que representa un mensaje de error cuando no trae cuerpo.
   */
  public static final String MSG_ERROR_RESPONSE_HAS_NO_BODY =
      "Failed to parse the playload: Response has no body.";

  /**
   * Constante que representa un mensaje de error cuando el body de error no corresponde con el pre
   * definido.
   */
  public static final String MSG_ERROR_FORMAT =
      "Failed to parse the playload. The format of the message does not "
          + "correspond with the predefined {}";

  /**
   * Constante de los detalles de error del cliente feign.
   */
  public static final String ERROR_FEIGN_DETAILS = "Error feign details {}";

  /**
   * Constante de la cantidad de resultados de un arreglo.
   */
  public static final String RECORDS_FOUND = "Records found {}";

  /**
   * Constante log business call product recover.
   */
  public static final String CALL_PRODUCT_PROCCESS_RECOVER =
      "REPOSITORY CALL - [Product Process recover]";
}
