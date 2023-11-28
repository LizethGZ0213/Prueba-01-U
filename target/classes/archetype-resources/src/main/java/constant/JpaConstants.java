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

package ${package}.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Clase que representa las constantes definidas para Jpa.
 *
 * @author Nova Solution Systems.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JpaConstants {

  /**
   * Nombre de la tabla sc_producto.
   */
  public static final String PRODUCT = "sc_producto";

  /**
   * Numero de producto.
   */
  public static final String PRODUCT_NUMBER = "producto";

  /**
   * Nombre del producto.
   */
  public static final String PRODUCT_NAME = "nombre";

  /**
   * Query select para obtener el listado de productos por su "interest".
   */
  public static final String QUERY_SELECT = """
      SELECT producto, nombre FROM bdicheq\\:\"informix\".sc_producto
      WHERE paga_interes = :interest ORDER BY nombre DESC""";
}
