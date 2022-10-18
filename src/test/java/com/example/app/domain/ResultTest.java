package com.example.app.domain;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.Date;

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
@ContextConfiguration(classes = {TestConfig.class})
class ResultTest {

	// テスト対象
	Result result = new Result();
	Errors errors = new BindException(result, "result");
	
	@Autowired
	Validator validator;
	
	@BeforeEach
	void setUp() {
		result.setUserId(1);
		result.setDerection("東家");
		result.setRank(1);
		result.setTime(new Date());
		result.setEastScore(25000);
		result.setSouthScore(25000);
		result.setWestScore(25000);
		result.setNorthScore(25000);
		result.setEastPlayer("山田太郎");
		result.setSouthPlayer("鈴木次郎");
		result.setWestPlayer("小林三郎");
		result.setNorthPlayer("渋谷五郎");	
	}
	
	@Test
	void all_正常系() {
		// When
		validator.validate(result, errors);
		
		// Then
		assertThat(errors.getFieldError(), is(nullValue()));
	}

	@ParameterizedTest
	@CsvSource({",自家を選択してください"})
	void derection_異常系(String derection, String msg) {
		// Given
		result.setDerection(derection);
		
		// when
		validator.validate(result, errors);
		
		// Then
		assertThat(errors.getFieldError().toString(), is(containsString(msg)));
	}
	
	@ParameterizedTest
	@CsvSource({"-999999, 9999999"})
	void eastScore_正常系(Integer eastScore) {
		// Given
		result.setEastScore(eastScore);
		
		// when
		validator.validate(result, errors);
		
		// Then
		assertThat(errors.getFieldError(), is(nullValue()));
	}
	
	@ParameterizedTest
	@CsvSource({",を入力してください", "-1000000, 7文字以内で入力してください", "10000000, 7文字以内で入力してください"})
	void eastScore_異常系(Integer eastScore, String msg) {
		// Given
		result.setEastScore(eastScore);
		
		// when
		validator.validate(result, errors);
		
		// Then
		assertThat(errors.getFieldError().toString(), is(containsString(msg)));
	}
	
	@ParameterizedTest
	@CsvSource({"-999999, 9999999"})
	void southScore_正常系(Integer southScore) {
		// Given
		result.setSouthScore(southScore);
		
		// when
		validator.validate(result, errors);
		
		// Then
		assertThat(errors.getFieldError(), is(nullValue()));
	}
	
	@ParameterizedTest
	@CsvSource({",を入力してください", "-1000000, 7文字以内で入力してください", "10000000, 7文字以内で入力してください"})
	void southScore_異常系(Integer southScore, String msg) {
		// Given
		result.setSouthScore(southScore);
		
		// when
		validator.validate(result, errors);
		
		// Then
		assertThat(errors.getFieldError().toString(), is(containsString(msg)));
	}
	
	@ParameterizedTest
	@CsvSource({"-999999, 9999999"})
	void westScore_正常系(Integer westScore) {
		// Given
		result.setWestScore(westScore);
		
		// when
		validator.validate(result, errors);
		
		// Then
		assertThat(errors.getFieldError(), is(nullValue()));
	}
	
	@ParameterizedTest
	@CsvSource({",を入力してください", "-1000000, 7文字以内で入力してください", "10000000, 7文字以内で入力してください"})
	void westScore_異常系(Integer westScore, String msg) {
		// Given
		result.setWestScore(westScore);
		
		// when
		validator.validate(result, errors);
		
		// Then
		assertThat(errors.getFieldError().toString(), is(containsString(msg)));
	}
	
	@ParameterizedTest
	@CsvSource({"-999999, 9999999"})
	void northScore_正常系(Integer northScore) {
		// Given
		result.setNorthScore(northScore);
		
		// when
		validator.validate(result, errors);
		
		// Then
		assertThat(errors.getFieldError(), is(nullValue()));
	}
	
	@ParameterizedTest
	@CsvSource({",を入力してください", "-1000000,7文字以内で入力してください", "10000000,7文字以内で入力してください"})
	void northScore_異常系(Integer northScore, String msg) {
		// Given
		result.setNorthScore(northScore);
		
		// when
		validator.validate(result, errors);
		
		// Then
		assertThat(errors.getFieldError().toString(), is(containsString(msg)));
	}
	
	@ParameterizedTest
	@CsvSource({"01234567890123456789"})
	void eastPlayer_正常系(String eastPlayer) {
		// Given
		result.setEastPlayer(eastPlayer);
		
		// when
		validator.validate(result, errors);
		
		// Then
		assertThat(errors.getFieldError(), is(nullValue()));
	}
	
	@ParameterizedTest
	@CsvSource({",が未入力です", "-01234567890123456789,20文字以内で入力してください"})
	void eastPlayer_異常系(String eastPlayer, String msg) {
		// Given
		result.setEastPlayer(eastPlayer);
		
		// when
		validator.validate(result, errors);
		
		// Then
		assertThat(errors.getFieldError().toString(), is(containsString(msg)));
	}
	
	@ParameterizedTest
	@CsvSource({"01234567890123456789"})
	void southPlayer_正常系(String southPlayer) {
		// Given
		result.setSouthPlayer(southPlayer);
		
		// when
		validator.validate(result, errors);
		
		// Then
		assertThat(errors.getFieldError(), is(nullValue()));
	}
	
	@ParameterizedTest
	@CsvSource({",が未入力です", "-01234567890123456789,20文字以内で入力してください"})
	void southPlayer_異常系(String southPlayer, String msg) {
		// Given
		result.setSouthPlayer(southPlayer);
		
		// when
		validator.validate(result, errors);
		
		// Then
		assertThat(errors.getFieldError().toString(), is(containsString(msg)));
	}
	
	@ParameterizedTest
	@CsvSource({"01234567890123456789"})
	void westPlayer_正常系(String westPlayer) {
		// Given
		result.setWestPlayer(westPlayer);
		
		// when
		validator.validate(result, errors);
		
		// Then
		assertThat(errors.getFieldError(), is(nullValue()));
	}
	
	@ParameterizedTest
	@CsvSource({",が未入力です", "-01234567890123456789,20文字以内で入力してください"})
	void westPlayer_異常系(String westPlayer, String msg) {
		// Given
		result.setWestPlayer(westPlayer);
		
		// when
		validator.validate(result, errors);
		
		// Then
		assertThat(errors.getFieldError().toString(), is(containsString(msg)));
	}
	
	@ParameterizedTest
	@CsvSource({"01234567890123456789"})
	void northPlayer_正常系(String northPlayer) {
		// Given
		result.setNorthPlayer(northPlayer);
		
		// when
		validator.validate(result, errors);
		
		// Then
		assertThat(errors.getFieldError(), is(nullValue()));
	}
	
	@ParameterizedTest
	@CsvSource({",が未入力です", "-01234567890123456789,20文字以内で入力してください"})
	void northPlayer_異常系(String northPlayer, String msg) {
		// Given
		result.setNorthPlayer(northPlayer);
		
		// when
		validator.validate(result, errors);
		
		// Then
		assertThat(errors.getFieldError().toString(), is(containsString(msg)));
	}
}
