package me.brunosantana.model

import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.unmockkStatic
import me.brunosantana.utils.getString
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import org.assertj.core.api.Assertions as AssertionsAssertj

class PersonTest {

    @Nested
    @DisplayName("Test map to Person")
    inner class MapToPersonTests {
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

    @Nested
    @DisplayName("Comparing")
    inner class Compare2People {

        @Test
        fun `should compare all fields of 2 people that are equal`() {
            val person1 = Person(name = "Bruno", salary = BigDecimal("1000"))
            val person2 = Person(name = "Bruno", salary = BigDecimal("1000"))

            AssertionsAssertj.assertThat(person1)
                .usingRecursiveComparison()
                .isEqualTo(person2)
        }

        @Test
        fun `should compare all fields of 2 people that are NOT equal`() {
            val person1 = Person(name = "Bruno", salary = BigDecimal("1000"))
            val person2 = Person(name = "Bruno", salary = BigDecimal("2000"))

            AssertionsAssertj.assertThat(person1)
                .usingRecursiveComparison()
                .isNotEqualTo(person2)

            val person3 = Person(name = "Bruno", salary = BigDecimal("1000"))
            val person4 = Person(name = "Jackson", salary = BigDecimal("1000"))

            AssertionsAssertj.assertThat(person3)
                .usingRecursiveComparison()
                .isNotEqualTo(person4)
        }

        @Test
        fun `should compare all fields of 2 people ignoring salary`() {
            val person1 = Person(name = "Bruno", salary = BigDecimal("1000"))
            val person2 = Person(name = "Bruno", salary = BigDecimal("2000"))

            AssertionsAssertj.assertThat(person1)
                .usingRecursiveComparison()
                .ignoringFields("salary")
                .isEqualTo(person2)
        }

        @Test
        fun `should compare all fields of 2 people ignoring name`() {
            val person1 = Person(name = "Bruno", salary = BigDecimal("1000"))
            val person2 = Person(name = "Jackson", salary = BigDecimal("1000"))

            AssertionsAssertj.assertThat(person1)
                .usingRecursiveComparison()
                .ignoringFields("name")
                .isEqualTo(person2)
        }

        @Test
        fun `test example that shows the right order to pass the parameters`() {
            val expected = Person(name = "Bruno", salary = BigDecimal("1000"))
            val actual = Person(name = "Bruno", salary = BigDecimal("1000")) /*change the name in this line to Brunoo and you'll get this msg:
            field/property 'name' differ:
            - actual value  : "Brunoo"
            - expected value: "Bruno"
            */

            AssertionsAssertj.assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected)
        }

    }
}