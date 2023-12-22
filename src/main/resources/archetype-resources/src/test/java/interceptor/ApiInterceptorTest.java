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

import ${package}.util.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpMethod;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.bind.ServletRequestBindingException;
import java.time.Instant;

/**
 * Clase que implementa las pruebas unitarias para la clase {@link APIInterceptor}.
 *
 * @author Nova Solution Systems.
 */
@ExtendWith(MockitoExtension.class)
class ApiInterceptorTest {

  /**
   * Variable que indica si se imprimen headers.
   */
  private static final String printHeaders = "printHeaders";

  /**
   * Constante que se utiliza para almacenar las credenciales para la autenticacion de la solicitud.
   */
  private static final String AUTHORIZATION_LABEL = "Authorization";

  /**
   * Constante usada para simular el uuid.
   */
  private static final String UUID = "0643a8dc-6ccb-4734-9e42-62532f2502b5";

  /**
   * Constante usada para mostrar el 'application/json'.
   */
  private static final String APPLICATION_JSON = "application/json";

  /**
   * Constante usada para sumular el header "ACCEPT_LANGUAGE".
   */
  private static final String ACCEPT_LABEL = "accept";

  /**
   * Constante usada para sumular el header "AUTHORIZATION".
   */
  private static final String AUTHORIZATION = "1234567890";

  /**
   * Constante usada para sumular el header "uuid".
   */
  private static final String UUID_LABEL = "uuid";

  /**
   * Indicador de inicio de peticion.
   */
  private static final String T0_REQ_ATTRIBUTE = "req.t0";

  /**
   * Mock del interceptor que sera validado.
   */
  @InjectMocks
  private ApiInterceptor apiInterceptor;

  /**
   * Mock del servlet de la peticion.
   */
  @Mock
  private MockHttpServletRequest mockHttpServletRequest;

  /**
   * Mock del servlet de la respuesta.
   */
  @Mock
  private MockHttpServletResponse mockHttpServletResponse;

  /**
   * Crea un objeto util para poder hacer operaciones de transformacion de objetos json.
   */
  @Mock
  private Util utilTool;

  /**
   * Metodo inicializador de variables.
   */
  @BeforeEach
  public void setUp() {
    ReflectionTestUtils.setField(apiInterceptor, printHeaders, true);

    mockHttpServletRequest = new MockHttpServletRequest();

    mockHttpServletRequest.setMethod(HttpMethod.POST.name());

    mockHttpServletRequest.addHeader(ACCEPT_LABEL, APPLICATION_JSON);
    mockHttpServletRequest.addHeader(UUID_LABEL, UUID);
    mockHttpServletRequest.addHeader(AUTHORIZATION_LABEL, AUTHORIZATION);
    mockHttpServletRequest.setContentType(APPLICATION_JSON);
    mockHttpServletRequest.setAttribute(T0_REQ_ATTRIBUTE, Instant.now());

    mockHttpServletResponse = new MockHttpServletResponse();
  }

  /**
   * Ejecuta el test para el metodo pre handle del interceptor.
   *
   * @throws ServletRequestBindingException Excepcion lanzada cuando el algoritmo no fue encontrado.
   *
   * @given Llega una peticion {@link HttpServletRequest}.
   * @when Se invoca al metodo pre handle del interceptor.
   * @then Se agrega el tiempo de inicio de la peticion al MDC.
   */
  @Test
  void preHandleTestWithPrintHeadersTest() throws ServletRequestBindingException {
    ReflectionTestUtils.setField(apiInterceptor, printHeaders, true);

    boolean result =
        apiInterceptor.preHandle(mockHttpServletRequest, mockHttpServletResponse, null);

    Assertions.assertTrue(result);
  }

  /**
   * Ejecuta la prueba unitaria para el metodo pre handle del interceptor sin imprimir headers.
   *
   * @throws ServletRequestBindingException Excepcion lanzada cuando el algoritmo no fue encontrado.
   *
   * @given Llega una peticion {@link HttpServletRequest}.
   * @when Se invoca al metodo pre handle del interceptor y la variable printHeaders esta en false.
   * @then No se imprimen los headers de la peticion.
   */
  @Test
  void preHandleWithoutPrintHeadersTest() throws ServletRequestBindingException {
    ReflectionTestUtils.setField(apiInterceptor, printHeaders, false);

    boolean result =
        apiInterceptor.preHandle(mockHttpServletRequest, mockHttpServletResponse, null);

    Assertions.assertTrue(result);
  }

  /**
   * Ejecuta la prueba unitaria para el metodo after completion del interceptor.
   *
   * @throws ServletRequestBindingException Excepcion lanzada cuando el algoritmo no fue encontrado.
   *
   * @given Llega una peticion {@link HttpServletRequest}.
   * @when Se invoca al metodo after completion del interceptor.
   * @then Se imprime el tiempo que duro la peticion y borra la variable del MDC.
   */
  @Test
  void afterCompletionTest() throws ServletRequestBindingException {
    Exception ex = new Exception();

    apiInterceptor.afterCompletion(mockHttpServletRequest, mockHttpServletResponse, null, ex);

    Assertions.assertNotNull(ex);
  }
}
