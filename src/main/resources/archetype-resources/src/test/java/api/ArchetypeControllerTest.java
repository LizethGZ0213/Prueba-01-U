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

package ${package}.api;

import ${package}.mapper.HeadersMapper;
import ${package}.model.ProductProcessResponse;
import ${package}.service.ArchetypeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

/**
 * Clase que implementa las pruebas unitarias para la clase {@link ArchetypeController}.
 *
 * @author Nova Solution Systems.
 */
@ExtendWith(MockitoExtension.class)
class ArchetypeControllerTest {

  /**
   * Mock de la clase que contiene las apis a probar.
   */
  @InjectMocks
  private ArchetypeController archetypeController;

  /**
   * Mock del servicio que contiene la logica de negocio para las apis a probar.
   */
  @Mock
  private ArchetypeService archetypeService;

  /**
   * Objeto para mockear los headers de las peticiones.
   */
  private HttpHeaders headers;

  /**
   * Metodo inicializador de variables.
   */
  @BeforeEach
  public void setUp() {
    headers = HeadersMapper.defaults();
  }

  /**
   * Ejecuta la prueba unitaria para el happy path del endpoint de prueba.
   *
   * @given Un "interest" como query param.
   * @when Se manda el "interest" para filtrar los productos.
   * @then Se ejecuta el metodo y se obtiene en la respuesta el listado de productos filtrados por
   *       el "interest".
   */
  @Test
  void archetypeControllerSuccessTest() {
    String interest = "N";

    ResponseEntity<ProductProcessResponse> response =
        archetypeController.archetypeController(headers, interest);

    Assertions.assertNotNull(response);
  }
}
