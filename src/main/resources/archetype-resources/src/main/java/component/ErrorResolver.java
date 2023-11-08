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

package ${package}.component;

import ${package}.constant.ErrorResolverConstants;
import ${package}.constant.LogConstants;
import ${package}.constant.SpecialCharacterConstants;
import ${package}.exception.ErrorResponse;
import ${package}.exception.ErrorType;
import ${package}.exception.custom.BadRequestException;
import ${package}.exception.custom.DatabaseTimeoutException;
import ${package}.exception.custom.ForbiddenException;
import ${package}.exception.custom.InvalidOptionException;
import ${package}.exception.custom.NoDataFoundException;
import ${package}.exception.custom.StoreProcedureException;
import ${package}.exception.custom.UnauthorizedException;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.ObjectUtils;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Clase que intercepta las excepciones, maneja los mensajes y codigos http correspondientes.
 *
 * @author Nova Solution Systems.
 */
@Slf4j
@AllArgsConstructor
@RestControllerAdvice
public class ErrorResolver {

  /**
   * Bean de constantes de errores definidos en el yaml.
   */
  private ErrorResolverConstants errorResolverConstants;

  /**
   * Metodo para logear el detalle de la excepcion.
   *
   * @param errorResponse Objeto con el detalle de la respuesta de error.
   * @param exception Excepcion producida.
   */
  private static void writeToLog(ErrorResponse errorResponse, Exception exception) {
    log.error(LogConstants.ERROR_TYPE, errorResponse.getStatus());
    log.error(LogConstants.ERROR_CODE, errorResponse.getStatusCode());
    log.error(LogConstants.ERROR_DETAILS, errorResponse.getMessage());

    String message;

    if (ObjectUtils.isEmpty(exception)) {
      message = SpecialCharacterConstants.EMPTY_STRING;
    } else {
      message = exception.getMessage();
    }

    log.error(message, exception);
  }

  /**
   * Metodo para manejar una excepcion de tipo {@link BadRequestException}.
   *
   * @param req Objeto Http Servlet de peticion.
   * @param ex Excepcion recibida {@link BadRequestException}.
   * @return Objeto de respuesta especifica para {@link BadRequestException}.
   */
  @ExceptionHandler(BadRequestException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveBadRequestException(HttpServletRequest req, BadRequestException ex) {
    var errorResponse = new ErrorResponse();

    errorResponse.setStatus(ErrorType.INVALID.name());
    errorResponse.setStatusCode(errorResolverConstants.getBadRequestException());
    errorResponse.setMessage(ex.getMessage());

    writeToLog(errorResponse, ex);

    return errorResponse;
  }

  /**
   * Metodo para manejar una excepcion de tipo {@link UnauthorizedException}.
   *
   * @param req Objeto Http Servlet de peticion.
   * @param ex Excepcion recibida {@link UnauthorizedException}.
   * @return Objeto de respuesta especifica para {@link UnauthorizedException}.
   */
  @ExceptionHandler(UnauthorizedException.class)
  @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
  public ErrorResponse resolveUnAuthorizedException(HttpServletRequest req,
      UnauthorizedException ex) {
    var errorResponse = new ErrorResponse();

    errorResponse.setStatus(ErrorType.ERROR.name());
    errorResponse.setStatusCode(errorResolverConstants.getUnauthorizedException());
    errorResponse.setMessage(errorResolverConstants.getUnauthorizedExceptionMessage());

    writeToLog(errorResponse, ex);

    return errorResponse;
  }

  /**
   * Metodo para manejar una excepcion de tipo {@link NoHandlerFoundException}.
   *
   * @param req Objeto Http Servlet de peticion.
   * @param ex Excepcion recibida {@link NoHandlerFoundException}.
   * @return Objeto de respuesta especifica para {@link NoHandlerFoundException}.
   */
  @ExceptionHandler(NoHandlerFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorResponse resolveNoHandlerFoundException(HttpServletRequest req,
      NoHandlerFoundException ex) {
    var errorResponse = new ErrorResponse();

    errorResponse.setStatus(ErrorType.ERROR.name());
    errorResponse.setStatusCode(errorResolverConstants.getNoHandlerFoundException());
    errorResponse.setMessage(ex.getMessage());

    writeToLog(errorResponse, ex);

    return errorResponse;
  }

  /**
   * Metodo para manejar una excepcion de tipo {@link HttpRequestMethodNotSupportedException}.
   *
   * @param req Objeto Http Servlet de peticion.
   * @param ex Excepcion recibida {@link HttpRequestMethodNotSupportedException}.
   * @return Objeto de respuesta especifica para {@link HttpRequestMethodNotSupportedException}.
   */
  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveHttpRequestMethodNotSupportedException(HttpServletRequest req,
      HttpRequestMethodNotSupportedException ex) {
    var errorResponse = new ErrorResponse();

    errorResponse.setStatus(ErrorType.INVALID.name());
    errorResponse.setStatusCode(errorResolverConstants.getHttpRequestMethodNotSupportedException());
    errorResponse.setMessage(ex.getMessage());

    writeToLog(errorResponse, ex);

    return errorResponse;
  }

  /**
   * Metodo para manejar una excepcion de tipo {@link HttpMediaTypeNotAcceptableException}.
   *
   * @param req Objeto Http Servlet de peticion.
   * @param ex Excepcion recibida {@link HttpMediaTypeNotAcceptableException}.
   * @return Objeto de respuesta especifica para {@link HttpMediaTypeNotAcceptableException}.
   */
  @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveHttpMediaTypeNotAcceptableException(HttpServletRequest req,
      HttpMediaTypeNotAcceptableException ex) {
    var errorResponse = new ErrorResponse();

    errorResponse.setStatus(ErrorType.INVALID.name());
    errorResponse.setStatusCode(errorResolverConstants.getHttpMediaTypeNotAcceptableException());
    errorResponse.setMessage(ex.getMessage());

    writeToLog(errorResponse, ex);

    return errorResponse;
  }

  /**
   * Metodo para manejar una excepcion de tipo {@link HttpMediaTypeNotSupportedException}.
   *
   * @param req Objeto Http Servlet de peticion.
   * @param ex Excepcion recibida {@link HttpMediaTypeNotSupportedException}.
   * @return Objeto de respuesta especifica para {@link HttpMediaTypeNotSupportedException}.
   */
  @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveHttpMediaTypeNotSupportedException(HttpServletRequest req,
      HttpMediaTypeNotSupportedException ex) {
    var errorResponse = new ErrorResponse();

    errorResponse.setStatus(ErrorType.INVALID.name());
    errorResponse.setStatusCode(errorResolverConstants.getHttpMediaTypeNotSupportedException());
    errorResponse.setMessage(ex.getMessage());

    writeToLog(errorResponse, ex);

    return errorResponse;
  }

  /**
   * Metodo para manejar una excepcion de tipo {@link ServletRequestBindingException}.
   *
   * @param req Objeto Http Servlet de peticion.
   * @param ex Excepcion recibida {@link ServletRequestBindingException}.
   * @return Objeto de respuesta especifica para {@link ServletRequestBindingException}.
   */
  @ExceptionHandler(ServletRequestBindingException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveServletRequestBindingException(HttpServletRequest req,
      ServletRequestBindingException ex) {
    var errorResponse = new ErrorResponse();

    errorResponse.setStatus(ErrorType.ERROR.name());
    errorResponse.setStatusCode(errorResolverConstants.getServletRequestBindingException());
    errorResponse.setMessage(ex.getMessage());
    
    writeToLog(errorResponse, ex);

    return errorResponse;
  }

  /**
   * Metodo para manejar una excepcion de tipo {@link HttpMessageNotReadableException}.
   *
   * @param req Objeto Http Servlet de peticion.
   * @param ex Excepcion recibida {@link HttpMessageNotReadableException}.
   * @return Objeto de respuesta especifica para {@link HttpMessageNotReadableException}.
   */
  @ExceptionHandler(HttpMessageNotReadableException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveHttpMessageNotReadableException(HttpServletRequest req,
      HttpMessageNotReadableException ex) {
    String message = null;

    if (!ObjectUtils.isEmpty(ex) && !ObjectUtils.isEmpty(ex.getMessage())) {
      message = ex.getMessage();
    }

    message = Optional.ofNullable(message).orElseGet(() -> SpecialCharacterConstants.EMPTY_STRING);

    int index = message.indexOf(SpecialCharacterConstants.COLON);

    if (index != SpecialCharacterConstants.INT_NEGATIVE_ONE) {
      message = message.substring(SpecialCharacterConstants.INT_ZERO_VALUE, index);
    } else {
      message = errorResolverConstants.getBadRequestException();
    }

    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setStatus(ErrorType.INVALID.name());
    errorResponse.setStatusCode(errorResolverConstants.getHttpMessageNotReadableException());
    errorResponse.setMessage(message);

    writeToLog(errorResponse, ex);

    return errorResponse;
  }

  /**
   * Metodo para manejar una excepcion de tipo {@link MethodArgumentNotValidException}.
   *
   * @param req Objeto Http Servlet de peticion.
   * @param ex Excepcion recibida {@link MethodArgumentNotValidException}.
   * @return Objeto de respuesta especifica para {@link MethodArgumentNotValidException}.
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveMethodArgumentNotValidException(HttpServletRequest req,
      MethodArgumentNotValidException ex) {
    var errorResponse = new ErrorResponse();

    errorResponse.setStatus(ErrorType.INVALID.name());
    errorResponse.setStatusCode(errorResolverConstants.getMethodArgumentNotValidException());

    var groupedErrors = new HashMap<String, List<String>>();

    if (!groupedErrors.isEmpty()) {
      errorResponse.setMessage(groupedErrors.toString());
    }

    writeToLog(errorResponse, ex);

    return errorResponse;
  }

  /**
   * Metodo para manejar una excepcion de tipo {@link ConstraintViolationException}.
   *
   * @param req Objeto Http Servlet de peticion.
   * @param ex Excepcion recibida {@link ConstraintViolationException}.
   * @return Objeto de respuesta especifica para {@link ConstraintViolationException}.
   */
  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveConstraintViolation(HttpServletRequest req,
      ConstraintViolationException ex) {
    var errorResponse = new ErrorResponse();

    errorResponse.setStatus(ErrorType.INVALID.name());
    errorResponse.setStatusCode(errorResolverConstants.getConstraintViolationException());

    var violationMessages = new ArrayList<String>();

    ex.getConstraintViolations()
        .forEach(violation -> violationMessages.add(violation.getMessage()));

    errorResponse
        .setMessage(String.join(SpecialCharacterConstants.COMMA_SEPARATOR, violationMessages));

    writeToLog(errorResponse, ex);

    return errorResponse;
  }

  /**
   * Metodo para manejar una excepcion generica de tipo {@link Exception}.
   *
   * @param req Objeto Http Servlet de peticion.
   * @param ex Excepcion recibida {@link Exception}.
   * @return Objeto de respuesta especifica para {@link Exception}.
   */
  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorResponse resolveException(HttpServletRequest req, Exception ex) {
    var errorResponse = new ErrorResponse();

    errorResponse.setStatus(ErrorType.FATAL.name());
    errorResponse.setStatusCode(errorResolverConstants.getException());
    errorResponse.setMessage(errorResolverConstants.getExceptionMessage());

    writeToLog(errorResponse, ex);

    return errorResponse;
  }

  /**
   * Metodo para manejar una excepcion de tipo {@link CallNotPermittedException}.
   *
   * @param req Objeto Http Servlet de peticion.
   * @param ex Excepcion recibida {@link CallNotPermittedException}.
   * @return Objeto de respuesta especifica para {@link CallNotPermittedException}.
   */
  @ExceptionHandler(CallNotPermittedException.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorResponse resolveCallNotPermittedException(HttpServletRequest req,
      CallNotPermittedException ex) {

    var errorResponse = new ErrorResponse();

    errorResponse.setStatus(ErrorType.ERROR.name());
    errorResponse.setStatusCode(errorResolverConstants.getCallNotPermittedException());
    errorResponse.setMessage(ex.getMessage());

    ErrorResolver.writeToLog(errorResponse, ex);

    return errorResponse;

  }


  /**
   * Metodo para manejar una excepcion de tipo {@link ForbiddenException}.
   *
   * @param req Objeto Http Servlet de peticion.
   * @param ex Excepcion recibida {@link ForbiddenException}.
   * @return Objeto de respuesta especifica para {@link ForbiddenException}.
   */
  @ExceptionHandler(ForbiddenException.class)
  @ResponseStatus(value = HttpStatus.FORBIDDEN)
  public ErrorResponse resolveForbiddenException(HttpServletRequest req, Exception ex) {
    var errorResponse = new ErrorResponse();

    errorResponse.setStatus(ErrorType.ERROR.name());
    errorResponse.setStatusCode(errorResolverConstants.getForbiddenException());
    errorResponse.setMessage(errorResolverConstants.getForbiddenExceptionMessage());

    writeToLog(errorResponse, ex);

    return errorResponse;
  }

  /**
   * Handler para manejar la excepcion {@link InvalidOptionException}.
   *
   * @param req Objeto Http Servlet de peticion.
   * @param ex Excepcion recibida {@link InvalidOptionException}.
   * @return Objeto de respuesta especifica para {@link InvalidOptionException}.
   */
  @ExceptionHandler(InvalidOptionException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveInvalidOptionException(HttpServletRequest req,
      InvalidOptionException ex) {
    var errorResponse = new ErrorResponse();

    errorResponse.setStatus(ErrorType.INVALID.name());
    errorResponse.setStatusCode(errorResolverConstants.getBadRequestException());
    errorResponse.setMessage(ex.getMessage());

    writeToLog(errorResponse, ex);

    return errorResponse;
  }

  /**
   * Handler para manejar la excepcion {@link NoDataFoundException}.
   *
   * @param req Objeto Http Servlet de peticion.
   * @param ex Excepcion recibida {@link NoDataFoundException}.
   * @return Objeto de respuesta especifica para {@link NoDataFoundException}.
   */
  @ExceptionHandler(NoDataFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorResponse resolveNoDataFoundException(HttpServletRequest req,
      NoDataFoundException ex) {
    var errorResponse = new ErrorResponse();

    errorResponse.setStatus(ErrorType.ERROR.name());
    errorResponse.setStatusCode(errorResolverConstants.getNoDataFoundException());
    errorResponse.setMessage(ex.getMessage());

    writeToLog(errorResponse, ex);

    return errorResponse;
  }

  /**
   * Handler para manejar la excepcion {@link StoreProcedureException}.
   *
   * @param req Objeto Http Servlet de peticion.
   * @param ex Excepcion recibida {@link StoreProcedureException}.
   * @return Objeto de respuesta especifica para {@link StoreProcedureException}.
   */
  @ExceptionHandler(StoreProcedureException.class)
  @ResponseStatus(value = HttpStatus.FORBIDDEN)
  public ErrorResponse resolveStoreProcedureException(HttpServletRequest req,
      StoreProcedureException ex) {
    var errorResponse = new ErrorResponse();

    errorResponse.setStatus(ErrorType.ERROR.name());
    errorResponse.setStatusCode(errorResolverConstants.getException());
    errorResponse.setMessage(errorResolverConstants.getExceptionMessage());

    ErrorResolver.writeToLog(errorResponse, ex);

    return errorResponse;
  }

  /**
   * Handler para manejar la excepcion {@link DatabaseTimeoutException}.
   *
   * @param req Objeto Http Servlet de peticion.
   * @param res Objeto Http Servlet de la respuesta.
   * @param ex Excepcion recibida {@link DatabaseTimeoutException}.
   * @return Objeto de respuesta especifica para {@link DatabaseTimeoutException}.
   */
  @ExceptionHandler(DatabaseTimeoutException.class)
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
  public ErrorResponse resolveDatabaseTimeoutException(HttpServletRequest req,
      HttpServletResponse res, DatabaseTimeoutException ex) {
    var errorResponse = new ErrorResponse();

    errorResponse.setStatus(ErrorType.ERROR.name());
    errorResponse.setStatusCode(errorResolverConstants.getDatabaseTimeoutException());
    errorResponse.setMessage(errorResolverConstants.getDatabaseTimeoutExceptionDetail());
    res.setStatus(HttpServletResponse.SC_REQUEST_TIMEOUT);

    ErrorResolver.writeToLog(errorResponse, ex);

    return errorResponse;
  }
}
