package me.brunosantana.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class PersonTest {

    @Test
    fun `should convert map to Person successfully`() {
        val map = mutableMapOf(
            "name" to MyValue("Bruno", null),
            "salary" to MyValue(null, BigDecimal("1000"))
        )

        val person = Person.mapToPerson(map)

        Assertions.assertNotNull(person)
        Assertions.assertEquals("Bruno", person?.name)
        Assertions.assertEquals(BigDecimal("1000"), person?.salary)
    }

}