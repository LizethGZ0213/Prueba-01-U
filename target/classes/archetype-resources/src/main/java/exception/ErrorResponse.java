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

package ${package}.exception;

import ${package}.constant.SpecialCharacterConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

/**
 * Clase de error para la respuesta del controlador.
 *
 * @author Nova Solution Systems.
 */
@Setter
@Schema
public class ErrorResponse {

  /**
   * Tipo de error.
   */
  @Schema
  private String status;
  
  /**
   * Codigo del error.
   */
  @Schema
  private String statusCode;
  
  /**
   * Detalles del error.
   */
  private String message;

  /**
   * Metodo para obtener el tipo de error.
   *
   * @return Devuelve el tipo del error.
   */
  public String getStatus() {
    if (ObjectUtils.isEmpty(status)) {
      return SpecialCharacterConstants.EMPTY_STRING;
    }

    return status;
  }

  /**
   * Metodo para obtener el codigo de error.
   *
   * @return Devuelve el codigo del error.
   */
  public String getStatusCode() {
    if (ObjectUtils.isEmpty(statusCode)) {
      return SpecialCharacterConstants.EMPTY_STRING;
    }

    return statusCode;
  }

  /**
   * Metodo para obtener el detalle del error.
   *
   * @return Devuelve el detalle del error.
   */
  public String getMessage() {
    if (ObjectUtils.isEmpty(message)) {
      return SpecialCharacterConstants.EMPTY_STRING;
    }

    return message;
  }

}
