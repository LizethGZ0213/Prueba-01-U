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

import ${package}.constant.Constants;
import ${package}.constant.ErrorResolverConstants;
import ${package}.constant.SpecialCharacterConstants;
import ${package}.exception.custom.BadRequestException;
import ${package}.exception.custom.DatabaseTimeoutException;
import ${package}.exception.custom.ForbiddenException;
import ${package}.exception.custom.InvalidOptionException;
import ${package}.exception.custom.NoDataFoundException;
import ${package}.exception.custom.StoreProcedureException;
import ${package}.exception.custom.UnauthorizedException;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.NoHandlerFoundException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

/**
 * Clase que implementa las pruebas unitarias para la clase {@link ErrorResolver}.
 *
 * @author Nova Solution Systems.
 */
@ExtendWith(MockitoExtension.class)
class ErrorResolverTest {

  /**
   * Inyecta el bean ErrorResolver para hacer pruebas sobre dicha clase.
   */
  @InjectMocks
  private ErrorResolver errorResolver;

  /**
   * Mock constantes de la api.
   */
  @Mock
  private ErrorResolverConstants errorResolverConstants;

  /**
   * Metodo inicializador de variables.
   */
  @BeforeEach
  void setUp() {
    ReflectionTestUtils.setField(errorResolverConstants, "noDataFoundException",
        "noDataFoundException");
    ReflectionTestUtils.setField(errorResolverConstants, "badRequestException",
        "badRequestException");
    ReflectionTestUtils.setField(errorResolverConstants, "unauthorizedException",
        "unauthorizedException");
    ReflectionTestUtils.setField(errorResolverConstants, "forbiddenException",
        "forbiddenException");
    ReflectionTestUtils.setField(errorResolverConstants, "noHandlerFoundException",
        "noHandlerFoundException");
    ReflectionTestUtils.setField(errorResolverConstants, "httpRequestMethodNotSupportedException",
        "httpRequestMethodNotSupportedException");
    ReflectionTestUtils.setField(errorResolverConstants, "httpMediaTypeNotAcceptableException",
        "httpMediaTypeNotAcceptableException");
    ReflectionTestUtils.setField(errorResolverConstants, "httpMediaTypeNotSupportedException",
        "httpMediaTypeNotSupportedException");
    ReflectionTestUtils.setField(errorResolverConstants, "servletRequestBindingException",
        "servletRequestBindingException");
    ReflectionTestUtils.setField(errorResolverConstants, "httpMessageNotReadableException",
        "httpMessageNotReadableException");
    ReflectionTestUtils.setField(errorResolverConstants, "methodArgumentNotValidException",
        "methodArgumentNotValidException");
    ReflectionTestUtils.setField(errorResolverConstants, "constraintViolationException",
        "constraintViolationException");
    ReflectionTestUtils.setField(errorResolverConstants, "callNotPermittedException",
        "callNotPermittedException");
    ReflectionTestUtils.setField(errorResolverConstants, "microserviceClientException",
        "microserviceClientException");
    ReflectionTestUtils.setField(errorResolverConstants, "externalResourceException",
        "externalResourceException");
    ReflectionTestUtils.setField(errorResolverConstants, "requestTimeoutException",
        "requestTimeoutException");
    ReflectionTestUtils.setField(errorResolverConstants, "exception", "exception");
    ReflectionTestUtils.setField(errorResolverConstants, "noDataFoundExceptionMessage",
        "noDataFoundExceptionMessage");
    ReflectionTestUtils.setField(errorResolverConstants, "unauthorizedExceptionMessage",
        "unauthorizedExceptionMessage");
    ReflectionTestUtils.setField(errorResolverConstants, "forbiddenExceptionMessage",
        "forbiddenExceptionMessage");
    ReflectionTestUtils.setField(errorResolverConstants, "badRequestExceptionMessage",
        "badRequestExceptionMessage");
    ReflectionTestUtils.setField(errorResolverConstants, "noHandlerFoundExceptionMessage",
        "noHandlerFoundExceptionMessage");
    ReflectionTestUtils.setField(errorResolverConstants, "requestTimeoutExceptionMessage",
        "requestTimeoutExceptionMessage");
    ReflectionTestUtils.setField(errorResolverConstants, "exceptionMessage", "exceptionMessage");
  }

  /**
   * Test para resolver la excepcion {@link BadRequestException}.
   *
   * @given Una peticion {@link HttpServletRequest} y una excepcion {@link BadRequestException}.
   * @when Se recibe la excepcion {@link BadRequestException}.
   * @then Se dispara dicha excepcion {@link BadRequestException}.
   */
  @Test
  void resolveBadRequestExceptionTest() {
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    BadRequestException ex = Mockito.mock(BadRequestException.class);
    List<String> list = new ArrayList<>();

    list.add(SpecialCharacterConstants.EMPTY_STRING);

    errorResolver.resolveBadRequestException(req, ex);

    Assertions.assertNotNull(errorResolver.resolveBadRequestException(req, ex));
  }

  /**
   * Test para resolver la excepcion {@link BadRequestException} con campos especificos de error.
   *
   * @given Una peticion {@link HttpServletRequest}, la excepcion {@link BadRequestException} y una
   *        lista de campos erroneos.
   * @when Se recibe la excepcion {@link BadRequestException}.
   * @then Se dispara dicha excepcion {@link BadRequestException}.
   */
  @Test
  void resolveBadRequestExceptionWithBadFieldsNullTest() {
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    BadRequestException ex = Mockito.mock(BadRequestException.class);

    Mockito.when(ex.getBadFields()).thenReturn(null);

    errorResolver.resolveBadRequestException(req, ex);

    Assertions.assertNull(ex.getBadFields());
  }

  /**
   * Test para resolver la excepcion {@link ConstraintViolationException}.
   *
   * @given Una peticion {@link HttpServletRequest} y la excepcion
   *        {@link ConstraintViolationException}.
   * @when Se recibe la excepcion {@link ConstraintViolationException}.
   * @then Se dispara dicha excepcion {@link ConstraintViolationException}.
   */
  @Test
  void resolveConstraintViolationExceptionTest() {
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    ConstraintViolationException exception = Mockito.mock(ConstraintViolationException.class);

    errorResolver.resolveConstraintViolation(req, exception);

    Assertions.assertNotNull(errorResolver.resolveConstraintViolation(req, exception));
  }

  /**
   * Test para resolver la excepcion {@link ConstraintViolationException}.
   *
   * @given Una peticion {@link HttpServletRequest} y la excepcion
   *        {@link ConstraintViolationException}.
   * @when Se recibe la excepcion {@link ConstraintViolationException}.
   * @then Se dispara dicha excepcion {@link ConstraintViolationException}.
   */
  @Test
  void resolveConstraintViolationExceptionViolationMessagesTest() {
    ConstraintViolationException exception = Mockito.mock(ConstraintViolationException.class);
    Set<ConstraintViolation<?>> list = new HashSet<>();
    ConstraintViolation<?> volation = null;

    volation = ConstraintViolationImpl.forBeanValidation(null, null, null, null, null, null, null,
        null, null, null, volation);

    list.add(volation);

    Mockito.when(exception.getConstraintViolations()).thenReturn(list);

    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);

    errorResolver.resolveConstraintViolation(req, exception);

    Assertions.assertNotNull(errorResolver.resolveConstraintViolation(req, exception));
  }

  /**
   * Test para resolver la excepcion Exception.
   *
   * @given Una peticion {@link HttpServletRequest} y la excepcion generica {@link Exception}.
   * @when Se recibe una excepcion generica {@link Exception}.
   * @then Se dispara dicha excepcion {@link Exception}.
   */
  @Test
  void resolveExceptionTest() {
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    Exception ex = Mockito.mock(Exception.class);

    errorResolver.resolveException(req, ex);

    Assertions.assertNotNull(errorResolver.resolveException(req, ex));
  }

  /**
   * Test para resolver la excepcion {@link HttpMediaTypeNotAcceptableException}.
   *
   * @given Una peticion {@link HttpServletRequest} y la excepcion
   *        {@link HttpMediaTypeNotAcceptableException}.
   * @when Se recibe una excepcion {@link HttpMediaTypeNotAcceptableException}.
   * @then Se dispara dicha excepcion {@link HttpMediaTypeNotAcceptableException}.
   */
  @Test
  void resolveHttpMediaTypeNotAcceptableExceptionTest() {
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpMediaTypeNotAcceptableException ex =
        Mockito.mock(HttpMediaTypeNotAcceptableException.class);

    errorResolver.resolveHttpMediaTypeNotAcceptableException(req, ex);

    Assertions.assertNotNull(errorResolver.resolveHttpMediaTypeNotAcceptableException(req, ex));
  }

  /**
   * Test para resolver la excepcion {@link HttpMediaTypeNotAcceptableException}.
   *
   * @given Una peticion {@link HttpServletRequest} y la excepcion
   *        {@link HttpMediaTypeNotAcceptableException}.
   * @when Se recibe una excepcion {@link HttpMediaTypeNotAcceptableException}.
   * @then Se dispara dicha excepcion {@link HttpMediaTypeNotAcceptableException}.
   */
  @Test
  void resolveHttpMediaTypeNotSupportedExceptionTest() {
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpMediaTypeNotSupportedException ex = Mockito.mock(HttpMediaTypeNotSupportedException.class);

    errorResolver.resolveHttpMediaTypeNotSupportedException(req, ex);

    Assertions.assertNotNull(errorResolver.resolveHttpMediaTypeNotSupportedException(req, ex));
  }

  /**
   * Test para resolver la excepcion {@link HttpMessageNotReadableException}.
   *
   * @given Una peticion {@link HttpServletRequest} y la excepcion
   *        {@link HttpMessageNotReadableException}.
   * @when Se recibe una excepcion {@link HttpMessageNotReadableException}.
   * @then Se dispara dicha excepcion {@link HttpMessageNotReadableException}.
   */
  @Test
  void resolveHttpMessageNotReadableExceptionTest() {
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpMessageNotReadableException exception = Mockito.mock(HttpMessageNotReadableException.class);

    Mockito.when(exception.getMessage())
        .thenReturn(Constants.N + SpecialCharacterConstants.SPACE_STRING + Constants.JSON_STRING
            + SpecialCharacterConstants.COLON + SpecialCharacterConstants.EMPTY_STRING);

    errorResolver.resolveHttpMessageNotReadableException(req, exception);

    Assertions.assertNotNull(errorResolver.resolveHttpMessageNotReadableException(req, exception));
  }

  /**
   * Test para resolver la excepcion {@link HttpMessageNotReadableException}.
   *
   * @given Una peticion {@link HttpServletRequest} y la excepcion
   *        {@link HttpMessageNotReadableException}.
   * @when Se recibe una excepcion {@link HttpMessageNotReadableException}.
   * @then Se dispara dicha excepcion {@link HttpMessageNotReadableException}.
   */
  @Test
  void resolveHttpMessageNotReadableExceptionNullExceptionTest() {
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);

    Assertions.assertNotNull(errorResolver.resolveHttpMessageNotReadableException(req, null));
  }

  /**
   * Test para resolver la excepcion {@link HttpMessageNotReadableException}.
   *
   * @given Una peticion {@link HttpServletRequest} y la excepcion
   *        {@link HttpMessageNotReadableException}.
   * @when Se recibe una excepcion {@link HttpMessageNotReadableException}.
   * @then Se dispara dicha excepcion {@link HttpMessageNotReadableException}.
   */
  @Test
  void resolveHttpMessageNotReadableException_withMessageNullTest() {
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpMessageNotReadableException exception = Mockito.mock(HttpMessageNotReadableException.class);

    Mockito.when(exception.getMessage()).thenReturn(null);

    errorResolver.resolveHttpMessageNotReadableException(req, exception);

    Assertions.assertNotNull(errorResolver.resolveHttpMessageNotReadableException(req, exception));
  }

  /**
   * Test para resolver la excepcion {@link HttpRequestMethodNotSupportedException}.
   *
   * @given Una peticion {@link HttpServletRequest} y la excepcion
   *        {@link HttpRequestMethodNotSupportedException}.
   * @when Se recibe una excepcion {@link HttpRequestMethodNotSupportedException}.
   * @then Se dispara dicha excepcion {@link HttpRequestMethodNotSupportedException}.
   */
  @Test
  void resolveHttpRequestMethodNotSupportedExceptionTest() {
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpRequestMethodNotSupportedException exception =
        Mockito.mock(HttpRequestMethodNotSupportedException.class);

    errorResolver.resolveHttpRequestMethodNotSupportedException(req, exception);

    Assertions
        .assertNotNull(errorResolver.resolveHttpRequestMethodNotSupportedException(req, exception));
  }

  /**
   * Test para resolver la excepcion {@link MethodArgumentNotValidException}.
   *
   * @throws SecurityException Error se presento un problema de seguridad.
   * @throws NoSuchMethodException Hubo un problema en un metodo.
   *
   * @given Una peticion {@link HttpServletRequest} y la excepcion
   *        {@link MethodArgumentNotValidException}.
   * @when Se recibe una excepcion {@link MethodArgumentNotValidException}.
   * @then Se dispara dicha excepcion {@link MethodArgumentNotValidException}.
   */
  @Test
  void resolveMethodArgumentNotValidExceptionTest()
      throws NoSuchMethodException, SecurityException {
    FieldError fieldError = Mockito.mock(FieldError.class);
    List<FieldError> fieldErrors = new ArrayList<>();
    fieldErrors.add(fieldError);
    BindingResult bindingResult = Mockito.mock(BindingResult.class);
    final Method method = new Exception() {}.getClass().getEnclosingMethod();
    final MethodParameter parameter = Mockito.mock(MethodParameter.class);

    Mockito.when(parameter.getExecutable()).thenReturn(method);
    MethodArgumentNotValidException exception =
        new MethodArgumentNotValidException(parameter, bindingResult);

    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);

    errorResolver.resolveMethodArgumentNotValidException(req, exception);

    Assertions.assertNotNull(errorResolver.resolveMethodArgumentNotValidException(req, exception));
  }

  /**
   * Test para resolver la excepcion {@link MethodArgumentNotValidException}.
   *
   * @throws SecurityException Error se presento un problema de seguridad.
   * @throws NoSuchMethodException Hubo un problema en un metodo.
   *
   * @given Una peticion {@link HttpServletRequest} y la excepcion
   *        {@link MethodArgumentNotValidException}.
   * @when Se recibe una excepcion {@link MethodArgumentNotValidException}.
   * @then Se dispara dicha excepcion {@link MethodArgumentNotValidException}.
   */
  @Test
  void resolveMethodArgumentNotValidExceptionIsEmptyfieldErrorsTest()
      throws NoSuchMethodException, SecurityException {
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    BindingResult bindingResult = Mockito.mock(BindingResult.class);
    final Method method = new Exception() {}.getClass().getEnclosingMethod();
    final MethodParameter parameter = Mockito.mock(MethodParameter.class);

    Mockito.when(parameter.getExecutable()).thenReturn(method);
    MethodArgumentNotValidException exception =
        new MethodArgumentNotValidException(parameter, bindingResult);
    errorResolver.resolveMethodArgumentNotValidException(req, exception);

    Assertions.assertNotNull(errorResolver.resolveMethodArgumentNotValidException(req, exception));
  }

  /**
   * Test para resolver la excepcion {@link NoHandlerFoundException}.
   *
   * @given Una peticion {@link HttpServletRequest} y la excepcion {@link NoHandlerFoundException}.
   * @when Se recibe una excepcion {@link NoHandlerFoundException}.
   * @then Se dispara dicha excepcion {@link NoHandlerFoundException}.
   */
  @Test
  void resolveNoHandlerFoundExceptionTest() {
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    NoHandlerFoundException exception = Mockito.mock(NoHandlerFoundException.class);

    errorResolver.resolveNoHandlerFoundException(req, exception);

    Assertions.assertNotNull(errorResolver.resolveNoHandlerFoundException(req, exception));
  }

  /**
   * Test para resolver la excepcion {@link ServletRequestBindingException}.
   *
   * @given Una peticion {@link HttpServletRequest} y la excepcion
   *        {@link ServletRequestBindingException}.
   * @when Se recibe una excepcion {@link ServletRequestBindingException}.
   * @then Se dispara dicha excepcion {@link ServletRequestBindingException}.
   */
  @Test
  void resolveServletRequestBindingExceptionTest() {
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    ServletRequestBindingException exception = Mockito.mock(ServletRequestBindingException.class);

    Mockito.when(exception.getMessage()).thenReturn(Constants.OK);

    errorResolver.resolveServletRequestBindingException(req, exception);

    Assertions.assertNotNull(errorResolver.resolveServletRequestBindingException(req, exception));
  }

  /**
   * Test para resolver la excepcion {@link UnauthorizedException}.
   *
   * @given Una peticion {@link HttpServletRequest} y la excepcion {@link UnauthorizedException}.
   * @when Se recibe una excepcion {@link UnauthorizedException}.
   * @then Se dispara dicha excepcion {@link UnauthorizedException}.
   */
  @Test
  void resolveUnAuthorizedExceptionTest() {
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    UnauthorizedException exception = Mockito.mock(UnauthorizedException.class);

    errorResolver.resolveUnAuthorizedException(req, exception);

    Assertions.assertNotNull(errorResolver.resolveUnAuthorizedException(req, exception));
  }

  /**
   * Test para resolver la excepcion {@link CallNotPermittedException}.
   *
   * @given Una peticion {@link HttpServletRequest} y la excepcion
   *        {@link CallNotPermittedException}.
   * @when Se recibe una excepcion {@link CallNotPermittedException}.
   * @then Se dispara dicha excepcion {@link CallNotPermittedException}.
   */
  @Test
  void resolveCallNotPermittedExceptionTest() {
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    CallNotPermittedException ex = Mockito.mock(CallNotPermittedException.class);

    Assertions.assertNotNull(errorResolver.resolveCallNotPermittedException(req, ex));
  }

  /**
   * Test para resolver la excepcion {@link ForbiddenException}.
   *
   * @given Una peticion {@link HttpServletRequest} y la excepcion {@link ForbiddenException}.
   * @when Se recibe una excepcion {@link ForbiddenException}.
   * @then Se dispara dicha excepcion {@link ForbiddenException}.
   */
  @Test
  void resolveForbiddenExceptionTest() {
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    ForbiddenException ex = Mockito.mock(ForbiddenException.class);

    Assertions.assertNotNull(errorResolver.resolveForbiddenException(req, ex));
  }

  /**
   * Test para resolver la excepcion {@link InvalidOptionException}.
   *
   * @given Una peticion {@link HttpServletRequest} y la excepcion {@link InvalidOptionException}.
   * @when Se recibe una excepcion {@link InvalidOptionException}.
   * @then Se dispara dicha excepcion {@link InvalidOptionException}.
   */
  @Test
  void resolveInvalidOptionExceptionTest() {
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    InvalidOptionException ex = Mockito.mock(InvalidOptionException.class);

    Assertions.assertNotNull(errorResolver.resolveInvalidOptionException(req, ex));
  }

  /**
   * Test para resolver la excepcion {@link NoDataFoundException}.
   *
   * @given Una peticion {@link HttpServletRequest} y la excepcion {@link NoDataFoundException}.
   * @when Se recibe una excepcion {@link NoDataFoundException}.
   * @then Se dispara dicha excepcion {@link NoDataFoundException}.
   */
  @Test
  void resolveNoDataFoundExceptionTest() {
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    NoDataFoundException ex = Mockito.mock(NoDataFoundException.class);

    Assertions.assertNotNull(errorResolver.resolveNoDataFoundException(req, ex));
  }

  /**
   * Test para resolver la excepcion {@link StoreProcedureException}.
   * 
   * @given Una peticion {@link HttpServletRequest} y la excepcion {@link StoreProcedureException}.
   * @when Se recibe una excepcion {@link StoreProcedureException},
   * @then Se dispara dicha excepcion {@link StoreProcedureException}.
   */
  @Test
  void resolveStoreProcedureExceptionTest() {
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);

    StoreProcedureException ex = Mockito.mock(StoreProcedureException.class);

    Assertions.assertNotNull(errorResolver.resolveStoreProcedureException(req, ex));
  }

  /**
   * Test para resolver la excepcion {@link DatabaseTimeoutException}.
   * 
   * @given Una peticion {@link HttpServletRequest} y la excepcion {@link DatabaseTimeoutException}.
   * @when Se recibe una excepcion {@link DatabaseTimeoutException},
   * @then Se dispara dicha excepcion {@link DatabaseTimeoutException}.
   */
  @Test
  void resolveDatabaseTimeoutExceptionTest() {
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    DatabaseTimeoutException exception = Mockito.mock(DatabaseTimeoutException.class);

    errorResolver.resolveDatabaseTimeoutException(req, res, exception);
    Assertions.assertNotNull(errorResolver.resolveDatabaseTimeoutException(req, res, exception));
  }
}
