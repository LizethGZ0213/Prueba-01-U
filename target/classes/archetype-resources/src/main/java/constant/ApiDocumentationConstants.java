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
 * Clase que contiene los valores de las constantes para la documentacion de las API's.
 *
 * @author Nova Solution Systems.
 * @since ${date}.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiDocumentationConstants {

  /**
   * Constante con la descripcion del header Date.
   */
  public static final String DATE_HEADER_DESCRIPTION =
      "Fecha del dispositivo o del servidor de acuerdo a HTTP-Date.";

  /**
   * Constante con la descripcion del header Accept.
   */
  public static final String ACCEPT_HEADER_DESCRIPTION =
      "Media type que son aceptados en la peticion.";

  /**
   * Constante con la descripcion del header Accept-Charset.
   */
  public static final String ACCEPT_CHARSET_HEADER_DESCRIPTION =
      "Tipo de caracteres de la aplicacion.";

  /**
   * Constante con la descripcion del header Accept-Encoding.
   */
  public static final String ACCEPT_ENCODING_HEADER_DESCRIPTION =
      "La aplicacion debera aceptar compresion de datos.";

  /**
   * Constante con la descripcion del header Accept-Language.
   */
  public static final String ACCEPT_LANGUAGE_HEADER_DESCRIPTION =
      "La aplicacion por defecto usuara español de Mexico requerido.";

  /**
   * Constante con la descripcion del header Authorization.
   */
  public static final String AUTHORIZATION_HEADER_DESCRIPTION =
      "Token de autorizacion recibido durante el login.";

  /**
   * Constante con la descripcion del header Host.
   */
  public static final String HOST_HEADER_DESCRIPTION = "Host de la aplicacion.";

  /**
   * Constante con la descripcion del header User-Agent.
   */
  public static final String USER_AGENT_HEADER_DESCRIPTION =
      "Identificador de la version de frontend.";

  /**
   * Constante con la descripcion del header Content-Encoding.
   */
  public static final String CONTENT_ENCODING_HEADER_DESCRIPTION = "Datos comprimidos.";

  /**
   * Constante con la descripcion del header Content-Language.
   */
  public static final String CONTENT_LANGUAGE_HEADER_DESCRIPTION = "Lenguaje de la aplicacion.";

  /**
   * Constante con la descripcion del header Content-Length.
   */
  public static final String CONTENT_LENGTH_HEADER_DESCRIPTION = "Tamaño del mensaje.";

  /**
   * Constante con la descripcion del header Content-MD5.
   */
  public static final String CONTENT_MD5_HEADER_DESCRIPTION =
      "Huella MD5 del contenido del mensaje.";

  /**
   * Constante con la descripcion del header Content-Type.
   */
  public static final String CONTENT_TYPE_HEADER_DESCRIPTION =
      "Media type que son enviados en la peticion.";

  /**
   * Constante con la descripcion del header uuid.
   */
  public static final String UUID_HEADER_DESCRIPTION = "UUID que se genera para cada sesion.";

  /**
   * Constante utilizada para mostrar la descripcion del status "200".
   */
  public static final String OK_DESCRIPTION = "Operacion satisfactoria.";

  /**
   * Constante utilizada para mostrar la descripcion del status "400".
   */
  public static final String BAD_REQUEST_DESCRIPTION = "Parametros faltantes/Paramteros invalidos.";

  /**
   * Constante utilizada para mostrar la descripcion del status "401".
   */
  public static final String UNAUTHORIZED_DESCRIPTION =
      "Falta de credenciales/Credenciales invalidas.";

  /**
   * Constante utilizada para mostrar la descripcion del status "403".
   */
  public static final String FORBIDEN_DESCRIPTION =
      "La operacion solicitada no ha sido configurada para acceder a este recurso.";

  /**
   * Constante utilizada para mostrar la descripcion del status "404".
   */
  public static final String NOT_FOUND_DESCRIPTION = "El recurso solicitado no ha sido encontrado.";

  /**
   * Constante utilizada para mostrar la descripcion del status "408".
   */
  public static final String REQUEST_TIMEOUT_DESCRIPTION =
      "El servidor ha decidido cerrar la conexión en lugar de continuar esperando.";

  /**
   * Constante utilizada para mostrar la descripcion del status "422".
   */
  public static final String UNPROCESSABLE_ENTITY_DESCRIPTION =
      "La peticion estaba bien formada pero no se pudo seguir debido a errores de semantica.";

  /**
   * Constante utilizada para mostrar la descripcion del status "500".
   */
  public static final String INTERNAL_SERVER_ERROR_DESCRIPTION =
      "La peticion falló debido a un error interno del servidor/Servidor no disponible.";
}
