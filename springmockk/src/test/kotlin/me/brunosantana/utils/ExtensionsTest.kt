package me.brunosantana.utils

import me.brunosantana.model.MyValue
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class ExtensionsTest {

    @Nested
    @DisplayName("getString and getNumber")
    inner class GetStringAndGetNumberTests {

        @Test
        fun `should return the right string from map based on the key`() {
            val myMap = mutableMapOf<String, MyValue>(
                "key1" to MyValue("value1", null)
            )

            val result = myMap.getString("key1")

            Assertions.assertEquals("value1", result)
        }

        @Test
        fun `should return the right number from map based on the key`() {
            val myMap = mutableMapOf<String, MyValue>(
                "key1" to MyValue(null, BigDecimal("50"))
            )

            val result = myMap.getNumber("key1")

            Assertions.assertEquals(BigDecimal("50"), result)
        }

    }
}