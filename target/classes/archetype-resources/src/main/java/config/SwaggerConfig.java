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
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import lombok.AllArgsConstructor;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Clase de configuracion para el swagger-ui.
 *
 * @author Nova Solution Systems.
 */
@Configuration
@OpenAPIDefinition
@AllArgsConstructor
public class SwaggerConfig {

  /**
   * Bean para obtener valores del archivo properties.
   */
  private SwaggerConstants apiValues;

  /**
   * Bean para personalizar el api de documentacion swagger.
   *
   * @return Devuelve el objeto con la configuracion para la documentacion swagger.
   */
  @Bean
  OpenApiCustomizer productApi() {
    var api = new Api();
    api.customise(new OpenAPI());
    return api;
  }

  /**
   * Clase interna para la configuracion personalizada de swagger-ui.
   * 
   * <p>Se especifican los datos generales del proyecto.
   *
   * @author Nova Solution Systems.
   */
  class Api implements OpenApiCustomizer {

    /**
     * Personalizacion de los datos del api.
     *
     * @param openApi Objeto de defincion para la documentacion.
     */
    @Override
    public void customise(OpenAPI openApi) {
      openApi.info(apiInfo());
    }

    /**
     * Builder para llenar la informacion general del API.
     *
     * @return Devuelve el objeto que contiene la informacion del API.
     */
    private Info apiInfo() {
      var contact = new Contact();
      contact.setName(apiValues.getNameDeveloper());
      contact.setUrl(apiValues.getContactUrl());
      contact.setEmail(apiValues.getEmailDeveloper());

      var info = new Info();
      info.setTitle(apiValues.getTitle());
      info.setDescription(apiValues.getDescriptionApi());
      info.setVersion(apiValues.getVersion());
      info.setContact(contact);

      return info;
    }
  }
}