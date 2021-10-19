package me.brunosantana.model;

import org.junit.Test;

import me.brunosantana.utils.PojoTestUtils;

public class AttachmentTest {
	
	@Test
    public void testAccesors_shouldAccessProperField() {
        PojoTestUtils.validateAccessors(Attachment.class);
    }

}
