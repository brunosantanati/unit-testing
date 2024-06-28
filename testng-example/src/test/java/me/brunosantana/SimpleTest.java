package me.brunosantana;

import org.testng.annotations.*;

public class SimpleTest {

    @BeforeClass
    public void setUp() {
        // code that will be invoked when this test is instantiated
        System.out.println("Execute this before class");
    }

    @AfterClass
    public void tearsDown() {
        System.out.println("Execute this after class");
    }

    @Test(groups = {"fast"})
    public void aFastTest() {
        System.out.println("Fast test");
    }

    @Test(groups = {"slow"})
    public void aSlowTest() {
        System.out.println("Slow test");
    }

}
