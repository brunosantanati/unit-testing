package me.brunosantana.enums;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class TrinityTest {

    @Test
    public void shouldTestFather() {
        assertEquals("FATHER", Trinity.FATHER.name());
    }

    @Test
    public void shouldTestSon() {
        assertEquals("SON", Trinity.SON.name());
    }

    @Test
    public void shouldTestHolyGhost() {
        assertEquals("HOLY_GHOST", Trinity.HOLY_GHOST.name());
    }

}
