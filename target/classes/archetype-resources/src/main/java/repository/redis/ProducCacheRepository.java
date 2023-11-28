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

package ${package}.repository.redis;

import ${package}.entity.redis.ProductCache;
import org.springframework.data.repository.CrudRepository;

/**
 * Repositorio que representa el ejemplo para obtener informacion de Redis.
 *
 * <p>Esta clase es solo para ejemplificar la estructura del arquetipo, de favor evitar dejar dentro
 * del codigo magic Strings o magic Numbers.
 *
 * <p>Ajustar el javadoc de las clases, metodos y propiedades de acuerdo al contexto del repositorio
 * o componente en cuestion.
 *
 * <p>Recuerda que entre mas legible es tu codigo mas facil es darle mantenimiento.
 *
 * <p>Recuerda ordenar los imports de tus clases e interfaces.
 *
 * @author Nova Solution Systems.
 */
public interface ProducCacheRepository extends CrudRepository<ProductCache, String> {

}
