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

package ${package}.business;

import ${package}.client.FeignExample;
import ${package}.entity.informix.ProductDetail;
import ${package}.model.ProductProcessResponse;
import ${package}.repository.informix.ProductRepository;
import ${package}.repository.redis.ProducCacheRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa las pruebas unitarias para la clase {@link ArchetypeBusiness}.
 *
 * @author Nova Solution Systems.
 */
@ExtendWith(MockitoExtension.class)
class ArchetypeBusinessTest {

  /**
   * Mock de la clase de servicio que contiene los metodos a probar.
   */
  @InjectMocks
  private ArchetypeBusiness archetypeBusiness;

  /**
   * Mock de la clase de repositorio que realiza la comunicacion con la base de datos y entrega como
   * respuesta el catalogo de productos.
   */
  @Mock
  private ProductRepository repository;
  
  /**
   * Mock de la clase de repositorio que realiza la comunicacion con la base de datos y entrega como
   * respuesta el catalogo de productos.
   */
  @Mock
  private FeignExample feignExample;
  
  /**
   * Mock de la clase de repositorio de redis que realiza la comunicacion con redis y entrega como
   * respuesta el catalogo de productos.
   */
  @Mock
  private ProducCacheRepository producCacheRepository;

  /**
   * Ejecuta la prueba unitaria para el metodo "archetypeService".
   *
   * @given Un "interest" en el query param de la solicitud.
   * @when Se obtienen los datos del request.
   * @then Se procesan los productos de la base de datos para entregarlos en la respuesta.
   */
  @Test
  void archetypeServiceSuccessTest() {
    ProductProcessResponse response = Mockito.mock(ProductProcessResponse.class);

    String interest = "N";

    List<ProductDetail> products = new ArrayList<>();
    ProductDetail detail = new ProductDetail();
    detail.setProduct("9901");
    detail.setName("CUENTA PRESTADORA DE SERVICIOS");
    products.add(detail);
    Mockito.when(repository.productsRecover(Mockito.anyString())).thenReturn(products);

    response = archetypeBusiness.archetypeService(interest);

    Assertions.assertNotNull(response);
    Assertions.assertEquals(products.size(), response.getProducts().size());
  }

  /**
   * Ejecuta la prueba unitaria para el metodo "archetypeService" cuando no se manda un "interest".
   *
   * @given Un "interest" en el query param de la solicitud vacio o nulo.
   * @when Se obtienen los datos del request.
   * @then Se devuelve una respuesta vacia.
   */
  @Test
  void archetypeServiceSuccessWhenInterestIsNullTest() {
    ProductProcessResponse response = Mockito.mock(ProductProcessResponse.class);

    String interest = "";

    response = archetypeBusiness.archetypeService(interest);

    Assertions.assertNotNull(response);
    Assertions.assertEquals(0, response.getProducts().size());
  }
}
