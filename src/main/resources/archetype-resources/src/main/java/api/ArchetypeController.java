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

package ${package}.api;

import ${package}.constant.ApiDocumentationConstants;
import ${package}.constant.Constants;
import ${package}.constant.ConstantsApi;
import ${package}.constant.LogConstants;
import ${package}.exception.ErrorResponse;
import ${package}.model.ProductProcessResponse;
import ${package}.service.ArchetypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador que expone una o mas API's de ejemplo.
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
 * @since ${date}.
 */
@Slf4j
@Validated
@RestController
@AllArgsConstructor
@RequestMapping(Constants.BASE_PATH)
public class ArchetypeController {

  /**
   * Servicio de ejemplo para procesar una respuesta de ejemplo.
   */
  private ArchetypeService archetypeService;

  /**
   * Metodo que expone el API de ejemplo.
   *
   * @param headers Headers en la peticion.
   * @param interest Parametro que recibe el API para obtener los productos filtrados por su
   *        atributo de "interest".
   * @return Devuelve un listado de productos que cumplen con la condicion.
   */
  @Operation(summary = ConstantsApi.GET_TEST_OPERATION,
      description = ConstantsApi.GET_TEST_DESCRIPTION, tags = ConstantsApi.TAG,
      parameters = {
          @Parameter(in = ParameterIn.HEADER, name = Constants.DATE,
              description = ApiDocumentationConstants.DATE_HEADER_DESCRIPTION, required = false,
              schema = @Schema(type = Constants.STRING_TYPE)),
          @Parameter(in = ParameterIn.HEADER, name = Constants.ACCEPT,
              description = ApiDocumentationConstants.ACCEPT_HEADER_DESCRIPTION, required = true,
              schema = @Schema(type = Constants.STRING_TYPE)),
          @Parameter(in = ParameterIn.HEADER, name = Constants.ACCEPT_CHARSET,
              description = ApiDocumentationConstants.ACCEPT_CHARSET_HEADER_DESCRIPTION,
              required = false, schema = @Schema(type = Constants.STRING_TYPE)),
          @Parameter(in = ParameterIn.HEADER, name = Constants.ACCEPT_ENCODING,
              description = ApiDocumentationConstants.ACCEPT_ENCODING_HEADER_DESCRIPTION,
              required = false, schema = @Schema(type = Constants.STRING_TYPE)),
          @Parameter(in = ParameterIn.HEADER, name = Constants.ACCEPT_LANGUAGE,
              description = ApiDocumentationConstants.ACCEPT_LANGUAGE_HEADER_DESCRIPTION,
              required = false, schema = @Schema(type = Constants.STRING_TYPE)),
          @Parameter(in = ParameterIn.HEADER, name = Constants.AUTHORIZATION,
              description = ApiDocumentationConstants.AUTHORIZATION_HEADER_DESCRIPTION,
              required = true, schema = @Schema(type = Constants.STRING_TYPE)),
          @Parameter(in = ParameterIn.HEADER, name = Constants.HOST,
              description = ApiDocumentationConstants.HOST_HEADER_DESCRIPTION, required = false,
              schema = @Schema(type = Constants.STRING_TYPE)),
          @Parameter(in = ParameterIn.HEADER, name = Constants.USER_AGENT,
              description = ApiDocumentationConstants.USER_AGENT_HEADER_DESCRIPTION,
              required = false, schema = @Schema(type = Constants.STRING_TYPE)),
          @Parameter(in = ParameterIn.HEADER, name = Constants.CONTENT_ENCODING,
              description = ApiDocumentationConstants.CONTENT_ENCODING_HEADER_DESCRIPTION,
              required = false, schema = @Schema(type = Constants.STRING_TYPE)),
          @Parameter(in = ParameterIn.HEADER, name = Constants.CONTENT_LANGUAGE,
              description = ApiDocumentationConstants.CONTENT_LANGUAGE_HEADER_DESCRIPTION,
              required = false, schema = @Schema(type = Constants.STRING_TYPE)),
          @Parameter(in = ParameterIn.HEADER, name = Constants.CONTENT_LENGTH,
              description = ApiDocumentationConstants.CONTENT_LENGTH_HEADER_DESCRIPTION,
              required = false, schema = @Schema(type = Constants.STRING_TYPE)),
          @Parameter(in = ParameterIn.HEADER, name = Constants.CONTENT_MD5,
              description = ApiDocumentationConstants.CONTENT_MD5_HEADER_DESCRIPTION,
              required = false, schema = @Schema(type = Constants.STRING_TYPE)),
          @Parameter(in = ParameterIn.HEADER, name = Constants.UUID,
              description = ApiDocumentationConstants.UUID_HEADER_DESCRIPTION, required = true,
              schema = @Schema(type = Constants.STRING_TYPE))})
  @ApiResponses(value = {
      @ApiResponse(
          content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = ProductProcessResponse.class))},
          responseCode = Constants.CODE_OK, description = ApiDocumentationConstants.OK_DESCRIPTION),
      @ApiResponse(
          content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = ErrorResponse.class))},
          responseCode = Constants.CODE_BAD_REQUEST,
          description = ApiDocumentationConstants.BAD_REQUEST_DESCRIPTION),
      @ApiResponse(
          content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = ErrorResponse.class))},
          responseCode = Constants.CODE_UNAUTHORIZED,
          description = ApiDocumentationConstants.UNAUTHORIZED_DESCRIPTION),
      @ApiResponse(
          content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = ErrorResponse.class))},
          responseCode = Constants.CODE_ACCESS_NOT_CONFIGURED,
          description = ApiDocumentationConstants.FORBIDEN_DESCRIPTION),
      @ApiResponse(
          content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = ErrorResponse.class))},
          responseCode = Constants.CODE_RESOURCE_NOT_FOUND,
          description = ApiDocumentationConstants.NOT_FOUND_DESCRIPTION),
      @ApiResponse(
          content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = ErrorResponse.class))},
          responseCode = Constants.CODE_RESOURCE_REQUEST_TIMEOUT,
          description = ApiDocumentationConstants.REQUEST_TIMEOUT_DESCRIPTION),
      @ApiResponse(
          content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = ErrorResponse.class))},
          responseCode = Constants.CODE_BUSINESS_VALIDATION_FAILED,
          description = ApiDocumentationConstants.UNPROCESSABLE_ENTITY_DESCRIPTION),
      @ApiResponse(
          content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = ErrorResponse.class))},
          responseCode = Constants.CODE_INTERNAL_ERROR,
          description = ApiDocumentationConstants.INTERNAL_SERVER_ERROR_DESCRIPTION)})
  @GetMapping(value = ConstantsApi.GET_TEST, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ProductProcessResponse> archetypeController(
      @RequestHeader HttpHeaders headers, @RequestParam String interest) {
    log.debug(LogConstants.REQUEST, interest);

    return new ResponseEntity<>(archetypeService.archetypeService(interest), HttpStatus.OK);
  }
}