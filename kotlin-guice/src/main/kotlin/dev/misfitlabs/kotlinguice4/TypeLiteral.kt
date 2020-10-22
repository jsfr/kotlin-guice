/*
 * Copyright (C) 2017 John Leacox
 * Copyright (C) 2017 Brian van de Boogaard
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.misfitlabs.kotlinguice4

import com.google.inject.TypeLiteral
import kotlin.reflect.jvm.javaType
import kotlin.reflect.typeOf

/**
 * Creates a new [TypeLiteral] for the specified generic type [T].
 *
 * @see TypeLiteral
 * @author John Leacox
 * @since 1.0
 */
inline fun <reified T> typeLiteral() = object : TypeLiteral<T>() {}

@ExperimentalStdlibApi
inline fun <reified T> kotlinTypeLiteral(): TypeLiteral<T> {
    val ktype = typeOf<T>()
    val baseType = ktype.javaType

    @Suppress("UNCHECKED_CAST")
    return TypeLiteral.get(baseType) as TypeLiteral<T>
}
