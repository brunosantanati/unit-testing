package me.brunosantana.model

import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.unmockkStatic
import me.brunosantana.utils.getString
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

    @Test
    fun `should return null if map to Person conversion fails`() {
        mockkStatic("me.brunosantana.utils.ExtensionsKt")

        val mapMock = mockk<MutableMap<String, MyValue>>()
        every { mapMock.getString(any()) } throws RuntimeException("Convertion error")

        val person = Person.mapToPerson(mapMock)

        Assertions.assertNull(person)

        unmockkStatic("me.brunosantana.utils.ExtensionsKt")
    }

}