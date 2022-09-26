package me.brunosantana.model

import me.brunosantana.utils.getNumber
import me.brunosantana.utils.getString
import java.math.BigDecimal

data class Person (
        val name: String,
        val salary: BigDecimal
) {
        companion object {
                fun mapToPerson(map: MutableMap<String, MyValue>): Person? {
                        try {
                                return Person(
                                        name = map.getString("name") ?: "",
                                        salary = map.getNumber("salary") ?: BigDecimal.ZERO
                                )
                        } catch (ex: Exception) {
                                ex.printStackTrace()
                        }

                        return null
                }
        }
}