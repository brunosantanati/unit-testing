package me.brunosantana.model;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEquals;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCode;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanToString;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

// Classe baseada em: https://github.com/orien/bean-matchers

public class MyBeanTest {

    // One big test
    @Test
    public void testBean() {
        assertThat(MyBean.class, allOf(
                hasValidBeanConstructor(),
                hasValidGettersAndSetters(),
                hasValidBeanHashCode(),
                hasValidBeanEquals(),
                hasValidBeanToString()
        ));
    }

    // Individual, well named tests

    @Test
    public void shouldHaveANoArgsConstructor() {
        assertThat(MyBean.class, hasValidBeanConstructor());
    }

    @Test
    public void gettersAndSettersShouldWorkForEachProperty() {
        assertThat(MyBean.class, hasValidGettersAndSetters());
    }

    @Test
    public void allPropertiesShouldInfluenceHashCode() {
        assertThat(MyBean.class, hasValidBeanHashCode());
    }

    @Test
    public void allPropertiesShouldBeComparedDuringEquals() {
        assertThat(MyBean.class, hasValidBeanEquals());
    }

    @Test
    public void allPropertiesShouldBeRepresentedInToStringOutput() {
        assertThat(MyBean.class, hasValidBeanToString());
    }

}

