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

package ${package}.repository.informix;

import ${package}.constant.JpaConstants;
import ${package}.entity.informix.ProductDetail;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.util.Collections;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Repositorio que representa el ejemplo para obtener informacion de la tabla "sc_producto" de la
 * base de datos.
 *
 * <p>Esta clase es solo para ejemplificar la estructura del arquetipo, de favor evitar dejar dentro
 * del codigo magic Strings o magic Numbers.
 *
 * <p>Ajustar el javadoc de las clases, metodos y propiedades de acuerdo al contexto del repositorio
 * o componente en cuestion.
 *
 * <p>Recuerda que entre mas legible es tu codigo mas facil es darle mantenimiento.
 *
 * <p>Recuerda ordenar los imports de tus clases e interfaces.
 *
 * @author Nova Solution Systems.
 */
public interface ProductRepository extends JpaRepository<ProductDetail, String> {

  /**
   * Metodo para buscar los productos que cumplen con "interest" en especifico dentro de la tabla
   * "sc_producto".
   *
   * @param interest Campo por el que se desea filtrar los productos.
   * @return Devuelve el listado de productos.
   */
  @Query(value = JpaConstants.QUERY_SELECT, nativeQuery = true)
  @CircuitBreaker(name = "productsService", fallbackMethod = "productsFallbackMethod")
  List<ProductDetail> productsRecover(String interest);

  /**
   * En caso de que la consulta a la base de datos "productsRecover" no responda se ejecuta un
   * mecanismo alterno.
   *
   * @param exception Excepcion producida en la consulta.
   * @return Devuelve el listado con la misma estructura que devolveria la consulta.
   */
  default List<ProductDetail> productsFallbackMethod(Exception exception) {
    return Collections.emptyList();
  }
}
