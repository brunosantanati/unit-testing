package me.brunosantana.utils

import me.brunosantana.model.MyValue
import java.math.BigDecimal

fun MutableMap<String, MyValue>.getString(key: String): String? {
    return this[key]?.s
}

fun MutableMap<String, MyValue>.getNumber(key: String): BigDecimal? {
    return this[key]?.n
}