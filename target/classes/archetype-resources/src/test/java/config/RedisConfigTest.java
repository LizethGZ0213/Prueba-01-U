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

import static org.mockito.Mockito.when;
import ${package}.constant.RedisConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Clase que implementa las pruebas unitarias para la clase RedisConfig.
 *
 * @author Nova Solution Systems.
 */
@ExtendWith(MockitoExtension.class)
class RedisConfigTest {

  /**
   * Mock de la clase que contiene los metodos a probar.
   */
  @InjectMocks
  private RedisConfig applicationConfig;

  @Mock
  private RedisConstants redisConstants;
  
  /**
   * Metodo inicializador de variables.
   */
  @BeforeEach
  public void setUp() {
    when(redisConstants.getPort()).thenReturn("1234");
    when(redisConstants.getHostname()).thenReturn("domain");
    when(redisConstants.getPswd()).thenReturn("1234");
  }
  

  /**
   * Ejecuta la prueba unitaria para el metodo jedisConnectionFactory.
   *
   * @given Una clase {@link JedisConnectionFactory}.
   * @when Se instancia la clase.
   * @then Se crea el bean {@link JedisConnectionFactory}.
   */
  @Test
  void jedisConnectionFactoryTest() {
    
    Assertions.assertNotNull(applicationConfig.jedisConnectionFactory());
    
  }

  /**
   * Ejecuta la prueba unitaria para el metodo redisTemplate.
   *
   * @given Una clase {@link RedisTemplate}.
   * @when Se instancia la clase.
   * @then Se crea el bean {@link RedisTemplate}.
   */
  @Test
  void redisTemplateTest() {
    
    Assertions
        .assertNotNull(applicationConfig.redisTemplate());
  
  }
}
