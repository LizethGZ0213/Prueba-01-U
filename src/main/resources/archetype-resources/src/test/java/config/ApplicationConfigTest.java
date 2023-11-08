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

package ${package}.config;

import ${package}.util.Util;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.ErrorDecoder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * Clase que implementa las pruebas unitarias para la clase ApplicationConfig.
 *
 * @author Nova Solution Systems.
 * @since ${package.getClass().forName("java.time.LocalDateTime").getMethod("now").invoke(null).format($package.Class.forName("java.time.format.DateTimeFormatter").getMethod("ofPattern", $package.Class).invoke(null, "dd.MM.yyyy"))}.
 */
@ExtendWith(MockitoExtension.class)
class ApplicationConfigTest {

  /**
   * Mock de la clase que contiene los metodos a probar.
   */
  @InjectMocks
  private ApplicationConfig applicationConfig;

  /**
   * Mock de la clase ObjectMapper que contiene los metodos a probar.
   */
  @Mock
  private ObjectMapper objectMapper;

  /**
   * Mock de la clase Util que contiene los metodos a probar.
   */
  @Mock
  private Util util;

  /**
   * Ejecuta la prueba unitaria para el metodo methodValidationPostProcessor.
   *
   * @given Una clase {@link MethodValidationPostProcessor}.
   * @when Se instancia la clase.
   * @then Se crea el bean {@link MethodValidationPostProcessor}.
   */
  @Test
  void methodValidationPostProcessor() {
    Assertions.assertNotNull(applicationConfig.methodValidationPostProcessor());
  }
  
  /**
   * Ejecuta la prueba unitaria para el metodo errorDecoder.
   *
   * @given Una clase {@link ErrorDecoder}.
   * @when Se instancia la clase.
   * @then Se crea el bean {@link ErrorDecoder}.
   */
  @Test
  void errorDecoder() {
    Assertions
        .assertNotNull(applicationConfig.customFeignErrorDecoder(objectMapper, util));
  }
}
