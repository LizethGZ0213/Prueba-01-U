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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase que representa la excepcion para cuando la peticion tiene parametros o headers incorrectos
 * que no pueden ser procesados.
 *
 * @author Nova Solution Systems.
 */
public class BadRequestException extends RuntimeException {

  /**
   * UID autogenerado para el versionado de la clase.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Lista de campos incorrectos en la peticion.
   */
  private final List<String> badFields;

  /**
   * Constructor para inizializar la lista de campos incorrectos.
   *
   * @param message Mensaje de excepcion arrojada por bad request.
   * @param badFields Lista de campos que originaron la excepcion.
   */
  public BadRequestException(String message, List<String> badFields) {
    super(message);
    this.badFields = Collections.unmodifiableList(badFields);
  }

  /**
   * Metodo para obtener la lista de campos.
   *
   * @return Lista de los campos.
   */
  public List<String> getBadFields() {
    return new ArrayList<>(badFields);
  }
}
