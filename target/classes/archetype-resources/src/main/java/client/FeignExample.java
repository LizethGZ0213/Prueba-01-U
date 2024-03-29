#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 *
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

package ${package}.client;

import ${package}.component.CustomFeignDecoder;
import ${package}.config.ApplicationConfig;
import ${package}.constant.FeignConstants;
import ${package}.model.client.ExampleClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Cliente feign de ejemplo.
 *
 * @author Nova Solution Systems.
 */
@FeignClient(name = FeignConstants.FEIGN_NAME, url = FeignConstants.FEIGN_URL,
    configuration = {CustomFeignDecoder.class, ApplicationConfig.class})
public interface FeignExample {

  /**
   * Declaración de la función para consumir el api Ejemplo.
   *
   * @return Retorna ExampleClient.
   */
  @GetMapping(value = FeignConstants.FEIGN_PATH, consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  ExampleClient getExampleData();

}
