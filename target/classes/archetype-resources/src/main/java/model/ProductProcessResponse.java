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

package ${package}.model;

import ${package}.dto.ProductsRecord;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

/**
 * Clase de modelo que define el response de los productos.
 *
 * @author Nova Solution Systems.
 */
@Schema
@NoArgsConstructor
public class ProductProcessResponse {

  /**
   * Listado con el catalogo de productos.
   */
  private List<ProductsRecord> products;

  /**
   * Obtiene el listado con el catalogo de productos.
   *
   * @return Devuelve una coleccion con los productos.
   */
  public List<ProductsRecord> getProducts() {
    if (ObjectUtils.isEmpty(products)) {
      return Collections.emptyList();
    }

    return new ArrayList<>(products);
  }

  /**
   * Setea el listado con el catalogo de productos.
   *
   * @param products Listado de productos.
   */
  public void setProducts(List<ProductsRecord> products) {
    if (!ObjectUtils.isEmpty(products)) {
      this.products = new ArrayList<>(products);
    }
  }
}
