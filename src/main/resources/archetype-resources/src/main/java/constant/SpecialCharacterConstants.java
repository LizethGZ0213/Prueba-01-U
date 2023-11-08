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
 * Clase de constantes correspondiente a caracteres especiales.
 *
 * @author Nova Solution Systems.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SpecialCharacterConstants {

  /**
   * Constante para representar un slash y un punto.
   */
  public static final String SLASH_DOT = "\\.";

  /**
   * Constante para representar un punto.
   */
  public static final String DOT = ".";

  /**
   * Constante para representar un slash y un pipe.
   */
  public static final String SLASH_PIPE = "\\|";

  /**
   * Constante llaves.
   */
  public static final String CURLY_BRACKETS = "{}";

  /**
   * Constante separador por comma.
   */
  public static final String COMMA_SEPARATOR = ", ";

  /**
   * Constante para representar una coma.
   */
  public static final String COMMA = ",";

  /**
   * Constante para representar una tilde.
   */
  public static final String TILDE = "~";

  /**
   * Constante para representar un square bracket que abre.
   */
  public static final String SQUARE_BRACKET_LABEL = "[";

  /**
   * Constante para representar un square bracket que cierra.
   */
  public static final String SQUARE_BRACKET_CLOSE_LABEL = "]";

  /**
   * Constante para representar una cadena vacia.
   */
  public static final String EMPTY_STRING = "";

  /**
   * Constante para representar un espacio vacio.
   */
  public static final String SPACE_STRING = " ";

  /**
   * Constante para representar dos puntos.
   */
  public static final String COLON = ":";

  /**
   * Constante para representar punto y comma.
   */
  public static final String SEMI_COLON = ";";

  /**
   * Constante para representar la cadena '0'.
   */
  public static final String ZERO_VALUE_STRING = "0";

  /**
   * Constante para representar la cadena '1'.
   */
  public static final String ONE_VALUE_STRING = "1";

  /**
   * Constante para representar la cadena '2'.
   */
  public static final String TWO_VALUE_STRING = "2";

  /**
   * Constante que contiene el valor -1.
   */
  public static final int INT_NEGATIVE_ONE = -1;

  /**
   * Constante que contiene el valor 0.
   */
  public static final int INT_ZERO_VALUE = 0;

  /**
   * Constante que contiene el valor 1.
   */
  public static final int INT_ONE_VALUE = 1;

  /**
   * Constante que contiene el valor 2.
   */
  public static final int INT_TWO_VALUE = 2;

  /**
   * Constante que contiene el valor 3.
   */
  public static final int INT_THREE_VALUE = 3;

  /**
   * Constante que contiene el valor 4.
   */
  public static final int INT_FOUR_VALUE = 4;

  /**
   * Constante que representa el pipe.
   */
  public static final String PIPE = "|";

  /**
   * Expresion regular numerica.
   */
  public static final String NUMERIC_REGEX = "[0-9]*";
}
