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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springdoc.core.customizers.OpenApiCustomizer;

/**
 * Clase que implementa las pruebas unitarias para la clase SwaggerConfig.
 *
 * @author Nova Solution Systems.
 */
@ExtendWith(MockitoExtension.class)
class SwaggerConfigTest {

  /**
   * Mock del componente de configuracion de swagger que va a ser validado.
   */
  @InjectMocks
  private SwaggerConfig swaggerConfig;

  /**
   * Variable que contiene valores externalizados para el detalle de la documentacion.
   */
  @Mock
  private SwaggerConstants apiValues;

  /**
   * Ejecuta la prueba unitaria para el metodo productApi.
   *
   * @given Un objeto del tipo {@link OpenApi}.
   * @when El productApi es invocado.
   * @then Un nuevo {@link OpenApiCustomizer} es seteado con la informacion de la api.
   */
  @Test
  void productApiTest() {
    Mockito.when(apiValues.getTitle()).thenReturn("");

    swaggerConfig.productApi();

    Mockito.verify(apiValues, Mockito.times(1)).getTitle();
  }
}
