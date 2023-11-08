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

import com.bancoppel.commons.annotation.HandledProcedure;
import ${package}.client.FeignExample;
import ${package}.constant.Constants;
import ${package}.constant.LogConstants;
import ${package}.dto.ProductsRecord;
import ${package}.entity.redis.ProductCache;
import ${package}.model.ProductProcessResponse;
import ${package}.repository.informix.ProductRepository;
import ${package}.repository.redis.ProducCacheRepository;
import ${package}.service.ArchetypeService;
import java.util.ArrayList;
import java.util.Locale;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * Servicio que implementa la interface de ejemplo.
 *
 * <p>Esta clase es solo para ejemplificar la estructura del arquetipo, de favor evitar dejar dentro
 * del codigo magic Strings o magic Numbers.
 *
 * <p>Ajustar el javadoc de las clases, metodos y propiedades de acuerdo al contexto del servicio o
 * componente en cuestion.
 *
 * <p>Recuerda que entre mas legible es tu codigo mas facil es darle mantenimiento.
 *
 * <p>Recuerda ordenar los imports de tus clases e interfaces.
 *
 * @author Nova Solution Systems.
 */
@Slf4j
@Service
@AllArgsConstructor
public class ArchetypeBusiness implements ArchetypeService {

  /**
   * Repositorio de ejemplo para realizar consultas en la base de datos.
   *
   * <p>Obtencion del catalogo de productos.
   */
  private ProductRepository repository;

  /**
   * Cliente feign de ejemplo para realizar a APIs.
   *
   * <p>Obtiene la respuesta del API.
   */
  private FeignExample feignExample;
  
  /**
   * Repositorio para persistir en Redis.
   *
   * <p>Tiene las opciones de un CRUD.
   */
  private ProducCacheRepository producCacheRepository;

  /**
   * Implementacion del metodo de ejemplo, en el que se procesa la solicitud de obtencion del
   * catalogo de productos.
   *
   * @param interest Parametro que recibe el API para obtener los productos filtrados por su
   *        atributo de "interest".
   * @return Devuelve un listado de productos que cumplen con la condicion.
   */
  @HandledProcedure(value = Constants.BUSINESS_MAIN,
      name = Constants.BUSINESS_MAIN)
  @Override
  public ProductProcessResponse archetypeService(String interest) {

    var response = new ProductProcessResponse();

    if (ObjectUtils.isEmpty(interest)) {
      return response;
    }

    var dataResponse = feignExample.getExampleData();

    var productCache = new ProductCache("test", "redis");

    producCacheRepository.save(productCache);
    log.debug(LogConstants.RECORDS_FOUND, producCacheRepository.findAll());
    log.debug(LogConstants.RECORDS_FOUND, dataResponse);

    var detailProducts = new ArrayList<ProductsRecord>();
    
    var products = repository.productsRecover(interest.trim().toUpperCase(Locale.getDefault()));
    
    products.forEach(product -> detailProducts
        .add(new ProductsRecord(product.getProduct().trim(), product.getName().trim())));
    response.setProducts(detailProducts);
    log.debug(LogConstants.RECORDS_FOUND, products.size());
    return response;
  }
}
