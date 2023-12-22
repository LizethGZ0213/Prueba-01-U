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

package ${package}.exception.custom;

import ${package}.constant.Constants;
import ${package}.constant.SpecialCharacterConstants;
import ${package}.exception.ErrorResponse;
import java.time.ZonedDateTime;
import java.util.Map;
import lombok.Getter;

/**
 * Clase de la excepcion que es usada para para determinar cuando se produce un error en el consumo
 * de una api externa mediante el cliente feign.
 *
 * @author Nova Solution systems.
 */
@Getter
public class DownstreamException extends RuntimeException {

  /**
   * UID autogenerado para el versionado de la clase.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Http Status que se asignara.
   */
  private final int status;

  /**
   * Tipo de error.
   */
  private final String type;

  /**
   * Codigo que se definio para el error especifico.
   */
  private final String code;

  /**
   * Detalles del error.
   */
  private final String details;

  /**
   * URI que se invoco y que esta regresando el error.
   */
  private final String location;

  /**
   * Informacion adicional para casos especificos.
   */
  private final String moreInfo;

  /**
   * Identificador unico de la peticion.
   */
  private final String uuid;

  /**
   * Fecha y hora en que ocurrio el error.
   */
  private final ZonedDateTime timestamp;

  /**
   * Constructor que inicializa los valores por defecto.
   */
  public DownstreamException() {
    super();

    this.status = Constants.DEFAULT_STATUS_HTTP;
    this.type = SpecialCharacterConstants.EMPTY_STRING;
    this.code = SpecialCharacterConstants.EMPTY_STRING;
    this.details = SpecialCharacterConstants.EMPTY_STRING;
    this.location = SpecialCharacterConstants.EMPTY_STRING;
    this.moreInfo = SpecialCharacterConstants.EMPTY_STRING;
    this.uuid = SpecialCharacterConstants.EMPTY_STRING;
    this.timestamp = ZonedDateTime.now();
  }

  /**
   * Constructor que recibe el estatus Http de la respuesta y los valores de la misma.
   *
   * @param status Estatus de la respuesta.
   * @param errorResponse Respuesta de error enviada desde el cliente feign.
   */
  public DownstreamException(int status, Map<String, String> errorResponse) {
    super(Constants.DOWNSTREAMEXCEPTION + SpecialCharacterConstants.SPACE_STRING + status
        + SpecialCharacterConstants.COLON + SpecialCharacterConstants.SPACE_STRING
        + errorResponse.get(Constants.ERROR_RESPONSE_DETAILS));

    this.status = status;
    this.type = errorResponse.get(Constants.ERROR_RESPONSE_TYPE);
    this.code = errorResponse.get(Constants.ERROR_RESPONSE_CODE);
    this.details = errorResponse.get(Constants.ERROR_RESPONSE_DETAILS);
    this.location = errorResponse.get(Constants.ERROR_RESPONSE_LOCATION);
    this.moreInfo = errorResponse.get(Constants.ERROR_RESPONSE_MORE_INFORMATION);
    this.uuid = errorResponse.get(Constants.UUID);

    var timeStamp = errorResponse.get(Constants.ERROR_RESPONSE_TIMESTAMP);

    timeStamp = timeStamp.substring(SpecialCharacterConstants.INT_ZERO_VALUE,
        timeStamp.length() - SpecialCharacterConstants.INT_TWO_VALUE)
        + SpecialCharacterConstants.COLON
        + timeStamp.substring(timeStamp.length() - SpecialCharacterConstants.INT_TWO_VALUE);

    var zonedDateTime = ZonedDateTime.parse(timeStamp);

    this.timestamp = zonedDateTime;
  }

  /**
   * Constructor que recibe el estatus Http de la respuesta y los valores de la misma.
   *
   * @param status Estatus de la respuesta.
   * @param errorResponse Respuesta de error enviada desde el cliente feign.
   */
  public DownstreamException(int status, ErrorResponse errorResponse) {
    super(Constants.DOWNSTREAMEXCEPTION + SpecialCharacterConstants.SPACE_STRING + status
        + SpecialCharacterConstants.COLON + SpecialCharacterConstants.SPACE_STRING
        + errorResponse.getMessage());

    this.status = status;
    this.type = SpecialCharacterConstants.EMPTY_STRING;
    this.code = errorResponse.getStatusCode();
    this.details = errorResponse.getMessage();
    this.location = SpecialCharacterConstants.EMPTY_STRING;
    this.moreInfo = SpecialCharacterConstants.EMPTY_STRING;
    this.uuid = SpecialCharacterConstants.EMPTY_STRING;
    this.timestamp = null;

  }
}
