package me.brunosantana.utils;

import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

//Projeto baseado no post:
//https://reliablesoftwareblog.wordpress.com/2016/04/28/achieving-100-code-coverage-testing-getters-and-setters/
//Para checar a cobertura:
//mvn clean cobertura:cobertura
//O relatório é gerado em:
//file:///C:/Users/myuser/eclipse-workspace/unit-testing/test-pojo/target/site/cobertura/index.html

public class PojoTestUtils {

	private static final Validator ACCESSOR_VALIDATOR = ValidatorBuilder.create()
			.with(new GetterTester())
			.with(new SetterTester()).build();

	public static void validateAccessors(final Class<?> clazz) {
		ACCESSOR_VALIDATOR.validate(PojoClassFactory.getPojoClass(clazz));
	}
}
