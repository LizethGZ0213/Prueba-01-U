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

import ${package}.constant.SwaggerConstants;
import ${package}.constant.SpecialCharacterConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 * Clase de prueba para WebMvcConfig.
 *
 * @author Nova Solution Systems.
 * @since ${package.getClass().forName("java.time.LocalDateTime").getMethod("now").invoke(null).format($package.Class.forName("java.time.format.DateTimeFormatter").getMethod("ofPattern", $package.Class).invoke(null, "dd.MM.yyyy"))}.
 */
@ExtendWith(MockitoExtension.class)
class WebMvcConfigTest {

  /**
   * Mock de la clase de configuracion del contexto web mvc para probar.
   */
  @InjectMocks
  private WebMvcConfig webMvcConfig;

  /**
   * Variable que contiene valores externalizados para las ubicaciones en las que se encontraran los
   * recursos para configurar.
   */
  @Mock
  private SwaggerConstants apiValues;

  /**
   * Ejecuta el test para el metodo configureContentNegotiation.
   *
   * @given Una clase de configuracion {@link ContentNegotiationConfigurer}.
   * @when El metodo configureContentNegotiation es invocado.
   * @then Se valida que se haya registrado la estrategia de negociacion.
   */
  @Test
  void configureContentNegotiationTest() {
    ContentNegotiationConfigurer configurer = Mockito.mock(ContentNegotiationConfigurer.class);

    Mockito.when(configurer.ignoreAcceptHeader(Boolean.TRUE)).thenReturn(configurer);

    webMvcConfig.configureContentNegotiation(configurer);

    Mockito.verify(configurer, Mockito.times(1)).ignoreAcceptHeader(Boolean.TRUE);
  }

  /**
   * Test para webConfig que ignora accept header.
   *
   * @given Una instancia de {@link ContentNegotiationConfigurer} y {@link WebMvcConfig}.
   * @when El metodo configureContentNegotiation es invocado.
   * @then Añade al {@link ContentNegotiationConfigurer} el filtro para ignorar el header.
   */
  @Test
  void testResourceHandlersTest() {
    Mockito.when(apiValues.getLabel()).thenReturn(SpecialCharacterConstants.EMPTY_STRING);
    Mockito.when(apiValues.getResourceLocation())
        .thenReturn(SpecialCharacterConstants.EMPTY_STRING);
    Mockito.when(apiValues.getWebjars()).thenReturn(SpecialCharacterConstants.EMPTY_STRING);
    Mockito.when(apiValues.getWebjarsLocation()).thenReturn(SpecialCharacterConstants.EMPTY_STRING);

    ResourceHandlerRegistry registry = Mockito.mock(ResourceHandlerRegistry.class);

    ResourceHandlerRegistration resourceHandlerRegistration =
        Mockito.mock(ResourceHandlerRegistration.class);

    Mockito.when(registry.addResourceHandler(ArgumentMatchers.anyString()))
        .thenReturn(resourceHandlerRegistration);

    webMvcConfig.addResourceHandlers(registry);

    Assertions.assertNotNull(registry);
  }
}
