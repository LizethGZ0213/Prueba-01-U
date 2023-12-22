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

package ${package}.interceptor;

import ${package}.constant.Constants;
import ${package}.constant.LogConstants;
import ${package}.util.Util;
import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.time.Instant;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Clase que se ejecuta cuando inicia la peticion del controlador para obtener el tiempo que le toma
 * la ejecucion al API que atiende dicha peticion.
 *
 * @author Nova Solution Systems.
 */
@Component
@Slf4j
public class ApiInterceptor implements HandlerInterceptor {

  /**
   * Variable externalizada que indica si se imprimiran los headers para modo debug, el imprimir los
   * headers puede reducir el performance del servicio.
   */
  @Value(Constants.PRINT_HEADERS)
  private boolean printHeaders;

  /**
   * Bean para efectuar operaciones con json e impresion de headers.
   */
  @Autowired
  private Util utilTool;

  /**
   * Metodo para configurar el MDC y guardar el tiempo inicial de la peticion.
   *
   * @param request Http servlet de la peticion.
   * @param response Http servlet de la respuesta.
   * @param handler Objeto del hanblder de la peticion.
   * @return regresa true, cuando el flujo es exitoso.
   * @throws ServletRequestBindingException Excepcion lanzada cuando el algoritmo no fue encontrado.
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
      @Nullable Object handler) throws ServletRequestBindingException {
    var t0 = Instant.now();

    request.setAttribute(Constants.T0_REQ_ATTRIBUTE, t0);

    MDC.put(Constants.UUID_MDC_LABEL, request.getHeader(Constants.UUID));

    log.info(LogConstants.START_REQUEST, request.getRequestURI());

    if (Boolean.TRUE.equals(printHeaders)) {
      utilTool.printHeaders(request);
    }

    return true;
  }

  /**
   * Calcula el total del tiempo de la peticion y limpia el MDC.
   *
   * @param request Http servlet de la peticion.
   * @param response Http servlet de la respuesta.
   * @param handler Objeto handler.
   * @param ex Excepcion en caso de producirse.
   */
  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      @Nullable Object handler, Exception ex) {
    var t0 = (Instant) request.getAttribute(Constants.T0_REQ_ATTRIBUTE);

    log.info(LogConstants.TIME_ELAPSED_MESSAGE, request.getRequestURI(),
        Duration.between(t0, Instant.now()).toMillis());

    request.removeAttribute(Constants.T0_REQ_ATTRIBUTE);

    MDC.clear();
  }
}
