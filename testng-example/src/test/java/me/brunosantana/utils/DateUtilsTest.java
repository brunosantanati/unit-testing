package me.brunosantana.utils;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class DateUtilsTest {

    @BeforeGroups(groups = "utils-group")
    public void setup() {
        System.out.println("Execute this before utils-group");
    }

    @AfterGroups(groups = "utils-group")
    public void tearsDown() {
        System.out.println("Execute this after utils-group");
    }

    @Test(groups = "utils-group")
    public void shouldGetDateAsString() {
        LocalDate date = LocalDate.of(1986, Month.SEPTEMBER, 19);
        String dateAsString = DateUtils.dateAsString(date);
        assertEquals(dateAsString, "19/09/1986");
    }

    @Test(groups = "utils-group")
    public void shouldThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            DateUtils.dateAsString(null);
        });
    }

    @Test
    public void shouldGetDateAsStringWithoutGroupInAnnotation() {
        // this is not execute by utils-suite because it does not have a group informed in the annotation
        LocalDate date = LocalDate.of(2000, Month.DECEMBER, 25);
        String dateAsString = DateUtils.dateAsString(date);
        assertEquals(dateAsString, "25/12/2000");
    }

}
