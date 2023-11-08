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
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Clase que contiene los valores externalizados del o las API's.
 *
 * @author Nova Solution Systems.
 */
@Getter
@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SwaggerConstants {

  /**
   * Valor externalizado para indicar el path base para interceptar peticiones.
   */
  @Value("${api.uri.interceptorPath}")
  private String interceptorPath;

  /**
   * Valor externalizado para indicar el titulo del API.
   */
  @Value("${constants.swagger.title}")
  private String title;

  /**
   * Valor externalizado para indicar la descripcion de la API.
   */
  @Value("${constants.swagger.descriptionApi}")
  private String descriptionApi;

  /**
   * Valor externalizado para indicar la version del swagger.
   */
  @Value("${constants.swagger.version}")
  private String version;

  /**
   * Valor externalizado para indicar el nombre del desarrollador.
   */
  @Value("${constants.swagger.nameDeveloper}")
  private String nameDeveloper;

  /**
   * Valor externalizado para indicar la URL de la peticion.
   */
  @Value("${constants.swagger.contactUrl}")
  private String contactUrl;

  /**
   * Valor externalizado para indicar el mail del desarrollador.
   */
  @Value("${constants.swagger.emailDeveloper}")
  private String emailDeveloper;

  /**
   * Valor externalizado para indicar las etiquetas del swagger.
   */
  @Value("${constants.swagger.label}")
  private String label;

  /**
   * Valor externalizado para indicar el recurso a consumir.
   */
  @Value("${constants.swagger.resourceLocation}")
  private String resourceLocation;

  /**
   * Valor externalizado para indicar donde se generan los artefactos de swagger.
   */
  @Value("${constants.swagger.webjars}")
  private String webjars;

  /**
   * Valor externalizado para indicar la ubicacion de los artefactos.
   */
  @Value("${constants.swagger.webjarsLocation}")
  private String webjarsLocation;
}
