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

package ${package}.exception.custom;

/**
 * Clase que representa la excepcion para cuando el servicio corta la peticion debido a una espera
 * demasiado larga de algun servicio externo invocado.
 *
 * @author Nova Solution Systems.
 */
public class TimeoutException extends RuntimeException {

  /**
   * UID autogenerado para el versionado de la clase.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constructor por defecto.
   */
  public TimeoutException() {
    super();
  }

  /**
   * Constructor que define el mensage de error.
   *
   * @param message Mensaje de la excepcion.
   */
  public TimeoutException(String message) {
    super(message);
  }

  /**
   * Constructor que recibe una excepcion a ser disparada.
   *
   * @param throwable Error de la excepcion.
   */
  public TimeoutException(Throwable throwable) {
    super(throwable);
  }
}
