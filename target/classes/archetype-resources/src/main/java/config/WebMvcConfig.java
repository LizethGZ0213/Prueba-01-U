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
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Clase de configuracion para el contexto web mvc.
 *
 * @author Nova Solution Systems.
 */
@Configuration
@AllArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

  /**
   * Bean de constantes obtenidas del archivo properties.
   */
  private SwaggerConstants apiValues;

  /**
   * Metodo de auto-configuracion para ignorar el Media-Type.
   *
   * @param configurer Clase para configurar la estrategia de manejo del "Media-Type".
   */
  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer.ignoreAcceptHeader(Boolean.TRUE);
    configurer.defaultContentType(MediaType.APPLICATION_JSON);
  }

  /**
   * Metodo para agregar recursos estaticos.
   *
   * @param registry Objeto que registra los recursos.
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler(apiValues.getLabel())
        .addResourceLocations(apiValues.getResourceLocation());

    registry.addResourceHandler(apiValues.getWebjars())
        .addResourceLocations(apiValues.getWebjarsLocation());

    WebMvcConfigurer.super.addResourceHandlers(registry);
  }
}
