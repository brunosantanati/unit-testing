package me.brunosantana.model;

import org.junit.Test;

import me.brunosantana.utils.PojoTestUtils;

public class MailMessageTest {
	
	@Test
    public void testAccesors_shouldAccessProperField() { 
        PojoTestUtils.validateAccessors(MailMessage.class);
    }

}
