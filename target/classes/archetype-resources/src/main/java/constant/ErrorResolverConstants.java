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
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Clase de constantes correspondientes al ErrorResolver.
 *
 * @author Nova Solution Systems.
 */
@Getter
@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResolverConstants {

  /**
   * Constante para representar un codigo de error causado por "DataNotFoundException".
   */
  @Value("${constants.errorResolver.errorCodes.noDataFoundException}")
  private String noDataFoundException;

  /**
   * Constante para representar un codigo de error causado por "BadRequestException".
   */
  @Value("${constants.errorResolver.errorCodes.badRequestException}")
  private String badRequestException;

  /**
   * Constante para representar un codigo de error causado por "UnauthorizedException".
   */
  @Value("${constants.errorResolver.errorCodes.unauthorizedException}")
  private String unauthorizedException;

  /**
   * Constante para representar un codigo de error causado por "ForbiddenException".
   */
  @Value("${constants.errorResolver.errorCodes.forbiddenException}")
  private String forbiddenException;

  /**
   * Constante para representar un codigo de error causado por "NoHandlerFoundException".
   */
  @Value("${constants.errorResolver.errorCodes.noHandlerFoundException}")
  private String noHandlerFoundException;

  /**
   * Constante para representar un codigo de error causado por
   * "HttpRequestMethodNotSupportedException".
   */
  @Value("${constants.errorResolver.errorCodes.httpRequestMethodNotSupportedException}")
  private String httpRequestMethodNotSupportedException;

  /**
   * Constante para representar un codigo de error causado por
   * "HttpMediaTypeNotAcceptableException".
   */
  @Value("${constants.errorResolver.errorCodes.httpMediaTypeNotAcceptableException}")
  private String httpMediaTypeNotAcceptableException;

  /**
   * Constante para representar un codigo de error causado por "HttpMediaTypeNotSupportedException".
   */
  @Value("${constants.errorResolver.errorCodes.httpMediaTypeNotSupportedException}")
  private String httpMediaTypeNotSupportedException;

  /**
   * Constante para representar un codigo de error causado por "ServletRequestBindingException".
   */
  @Value("${constants.errorResolver.errorCodes.servletRequestBindingException}")
  private String servletRequestBindingException;

  /**
   * Constante para representar un codigo de error causado por "HttpMessageNotReadableException".
   */
  @Value("${constants.errorResolver.errorCodes.httpMessageNotReadableException}")
  private String httpMessageNotReadableException;

  /**
   * Constante para representar un codigo de error causado por "MethodArgumentNotValidException".
   */
  @Value("${constants.errorResolver.errorCodes.methodArgumentNotValidException}")
  private String methodArgumentNotValidException;

  /**
   * Constante para representar un codigo de error causado por "ConstraintViolationException".
   */
  @Value("${constants.errorResolver.errorCodes.constraintViolationException}")
  private String constraintViolationException;

  /**
   * Constante para representar un codigo de error causado por "CallNotPermittedException".
   */
  @Value("${constants.errorResolver.errorCodes.callNotPermittedException}")
  private String callNotPermittedException;

  /**
   * Constante para representar un codigo de error causado por "MicroserviceClientException".
   */
  @Value("${constants.errorResolver.errorCodes.microserviceClientException}")
  private String microserviceClientException;

  /**
   * Constante para representar un codigo de error causado por "ExternalResourceException".
   */
  @Value("${constants.errorResolver.errorCodes.externalResourceException}")
  private String externalResourceException;

  /**
   * Constante para representar un codigo de error causado por "RequestTimeoutException".
   */
  @Value("${constants.errorResolver.errorCodes.requestTimeoutException}")
  private String requestTimeoutException;

  /**
   * Constante para representar un codigo de error causado por "Exception".
   */
  @Value("${constants.errorResolver.errorCodes.exception}")
  private String exception;

  /**
   * Constante para mostrar un mensaje cuando no se encuentran los datos solicitados.
   */
  @Value("${constants.errorResolver.messages.noDataFoundException}")
  private String noDataFoundExceptionMessage;

  /**
   * Constante para mostrar un mensaje cuando un cliente no esta autorizado.
   */
  @Value("${constants.errorResolver.messages.unauthorizedException}")
  private String unauthorizedExceptionMessage;

  /**
   * Constante para mostrar un mensaje cuando un cliente no tiene permisos de consumir un recurso.
   */
  @Value("${constants.errorResolver.messages.forbiddenException}")
  private String forbiddenExceptionMessage;

  /**
   * Constante para representar un mensaje de error causado por una peticion incorrecta.
   */
  @Value("${constants.errorResolver.messages.badRequestException}")
  private String badRequestExceptionMessage;

  /**
   * Constante para representar un mensaje de error causado porque no se encontro un recurso
   * solicitado.
   */
  @Value("${constants.errorResolver.messages.noHandlerFoundException}")
  private String noHandlerFoundExceptionMessage;

  /**
   * Constante para representar un mensaje de error causado porque un recurso externo no respondio
   * en el tiempo esperado.
   */
  @Value("${constants.errorResolver.messages.requestTimeoutException}")
  private String requestTimeoutExceptionMessage;

  /**
   * Constante para representar un mensaje de error causado por un error desconocido.
   */
  @Value("${constants.errorResolver.messages.exception}")
  private String exceptionMessage;

  /**
   * Constante para representar un mensaje de error causado por un timeout al consultar la bd.
   */
  @Value("${constants.errorResolver.errorCodes.databaseTimeoutException}")
  private String databaseTimeoutException;

  /**
   * Constante para mostrar un mensaje cuando ocurre un timeout al consultar la bd.
   */
  @Value("${constants.errorResolver.messages.databaseTimeoutException}")
  private String databaseTimeoutExceptionDetail;
}
