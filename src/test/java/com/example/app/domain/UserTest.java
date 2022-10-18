package com.example.app.domain;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.app.config.TestConfig;

@SpringBootTest
@ContextConfiguration(classes = { TestConfig.class })
class UserTest {

	// テスト対象と結果
	User user = new User();
	Errors errors = new BindException(user, "user");

	@Autowired
	Validator validator;

	@BeforeEach
	void setUp() {
		user.setLoginId("山田花子");
		user.setLoginPass("1234");
	}
	
	@Test
	void all_正常系() {
		// When
		validator.validate(user, errors);

		// Then
		assertThat(errors.getFieldError(), is(nullValue()));
	}

	@ParameterizedTest
	@CsvSource({"01234567890123456789"})
	void LoginId_正常系(String id) {
		// Given
		user.setLoginId(id);
		
		// When
		validator.validate(user, errors);
		
		// Then
		assertThat(errors.getFieldError(), is(nullValue()));
	}
	
	@ParameterizedTest
	@CsvSource({",が未入力です", "012345678901234567890, 20文字以内で入力してください"})
	void LoginId_異常系(String id, String msg) {
		// Given
		user.setLoginId(id);
		
		// When
		validator.validate(user, errors);
		
		// Then
		assertThat(errors.getFieldError().toString(), is(containsString(msg)));
		
	}
	
	@Test
	void LoginPass_正常系() {
		// When
		validator.validate(user, errors);
		
		// Then
		assertThat(errors.getFieldError(), is(nullValue()));
	}
	
	@ParameterizedTest
	@CsvSource({",が未入力です"})
	void LoginPass_異常系(String pass, String msg) {
		// Given
		user.setLoginPass(pass);
		
		// When
		validator.validate(user, errors);
		
		// 
		assertThat(errors.getFieldError().toString(), is(containsString(msg)));
	}
}
