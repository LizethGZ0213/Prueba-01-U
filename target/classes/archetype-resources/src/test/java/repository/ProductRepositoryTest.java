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

package ${package}.repository;

import ${package}.entity.informix.ProductDetail;
import ${package}.repository.informix.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

/**
 * Clase que implementa las pruebas unitarias para la clase {@link ProductRepository}.
 *
 * @author Nova Solution Systems.
 * @since ${date}.
 */
@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {

  /**
   * Mock de la clase de repositorio que contiene los metodos a probar.
   */
  @Spy
  private ProductRepository repository;

  /**
   * Ejecuta la prueba unitaria para el metodo "productsFallbackMethod" producido cuando no responde
   * el metodo principal "productsRecover".
   *
   * @given Una "exepcion" producida en el metodo primario "productsRecover".
   * @when Se obtiene la excepcion producida.
   * @then Se devuelve una respuesta generica contingente.
   */
  @Test
  void productsFallbackMethodTest() {
    List<ProductDetail> response = repository.productsFallbackMethod(new Exception());

    Assertions.assertNotNull(response);
    Assertions.assertTrue(response.isEmpty());
  }
}
