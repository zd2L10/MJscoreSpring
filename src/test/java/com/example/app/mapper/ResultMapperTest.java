package com.example.app.mapper;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import com.example.app.config.TestConfig;
import com.example.app.domain.Result;

@MybatisTest
@MapperScan
@ContextConfiguration(classes = {TestConfig.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ResultMapperTest {

	// テスト対象
	@Autowired
	ResultMapper resultMapper;
	
	// SQLファイルのパス
	final String INIT_RESULT = "classpath:test_data/init_result.sql";
	final String TRUNCATE_RESULT = "classpath:test_data/truncate_result.sql";
	
	@Test
	@Sql(INIT_RESULT)
	void findNewerResults_正常系() throws Exception {
		// Given
		Integer userId = 1;
		
		// When
		List<Result> list = resultMapper.findNewerResults(userId);
		
		// Then
		// 本番環境ではORDER BY time DESCが適用される
		assertThat(list.size(), is(13));
		assertThat(list.get(0).getResultId(), is(15));
		assertThat(list.get(0).getUserId(), is(1));
		assertThat(list.get(0).getDerection(), is("北家"));
		assertThat(list.get(0).getRank(), is(4));
		assertThat(list.get(0).getTime().toString(), is("Mon Oct 17 10:16:06 JST 2022"));
		assertThat(list.get(0).getEastScore(), is(25700));
		assertThat(list.get(0).getSouthScore(), is(35100));
		assertThat(list.get(0).getWestScore(), is(24200));
		assertThat(list.get(0).getNorthScore(), is(15000));
		assertThat(list.get(0).getEastPlayer(), is("小林三郎"));
		assertThat(list.get(0).getSouthPlayer(), is("渋谷五郎"));
		assertThat(list.get(0).getWestPlayer(), is("鈴木次郎"));
		assertThat(list.get(0).getNorthPlayer(), is("山田太郎"));
		
	}
	
	@Test
	@Sql(INIT_RESULT)
	void findById_正常系() throws Exception {
		// When
		Result result = resultMapper.findById(1);
		
		// Then
		assertThat(result.getResultId(), is(1));
		assertThat(result.getUserId(), is(1));
		assertThat(result.getDerection(), is("西家"));
		assertThat(result.getRank(), is(1));
		assertThat(result.getTime().toString(), is("Wed Aug 03 10:41:45 JST 2022"));
		assertThat(result.getEastScore(), is(18500));
		assertThat(result.getSouthScore(), is(29300));
		assertThat(result.getWestScore(), is(37900));
		assertThat(result.getNorthScore(), is(14300));
		assertThat(result.getEastPlayer(), is("鈴木次郎"));
		assertThat(result.getSouthPlayer(), is("小林三郎"));
		assertThat(result.getWestPlayer(), is("山田太郎"));
		assertThat(result.getNorthPlayer(), is("佐藤四朗"));
		
	}

	@Test
	@Sql(TRUNCATE_RESULT)
	void insert_正常系() throws Exception {
		// Given
		Result inputResult = new Result();
		inputResult.setUserId(1);
		inputResult.setDerection("東家");
		inputResult.setRank(1);
		inputResult.setTime(new Date());
		inputResult.setEastScore(26000);
		inputResult.setSouthScore(25000);
		inputResult.setWestScore(25000);
		inputResult.setNorthScore(24000);
		inputResult.setEastPlayer("山田太郎");
		inputResult.setSouthPlayer("鈴木次郎");
		inputResult.setWestPlayer("小林三郎");
		inputResult.setNorthPlayer("渋谷五郎");
		
		// When
		resultMapper.insert(inputResult);
		
		// Then
		Result result = resultMapper.findById(1);
		assertThat(result.getResultId(), is(1));
		assertThat(result.getUserId(), is(inputResult.getUserId()));
		assertThat(result.getDerection(), is(inputResult.getDerection()));
		assertThat(result.getRank(), is(inputResult.getRank()));
		long diff = result.getTime().getTime() - inputResult.getTime().getTime();
		assertThat(diff <= 1000L, is(true));
		assertThat(result.getEastScore(), is(inputResult.getEastScore()));
		assertThat(result.getSouthScore(), is(inputResult.getSouthScore()));
		assertThat(result.getWestScore(), is(inputResult.getWestScore()));
		assertThat(result.getNorthScore(), is(inputResult.getNorthScore()));
		assertThat(result.getEastPlayer(), is(inputResult.getEastPlayer()));
		assertThat(result.getSouthPlayer(), is(inputResult.getSouthPlayer()));
		assertThat(result.getWestPlayer(), is(inputResult.getWestPlayer()));
		assertThat(result.getNorthPlayer(), is(inputResult.getNorthPlayer()));
	}
	
	@Test
	@Sql(INIT_RESULT)
	void update_正常系() throws Exception {
		// Given
		Result inputResult = resultMapper.findById(1);
		inputResult.setDerection("南家");
		inputResult.setRank(2);
		inputResult.setTime(new Date());
		inputResult.setEastScore(26000);
		inputResult.setSouthScore(25000);
		inputResult.setWestScore(25000);
		inputResult.setNorthScore(24000);
		inputResult.setEastPlayer("山田太郎");
		inputResult.setSouthPlayer("鈴木次郎");
		inputResult.setWestPlayer("小林三郎");
		inputResult.setNorthPlayer("渋谷五郎");
		
		// When
		resultMapper.update(inputResult);
		
		// Then
		Result result = resultMapper.findById(1);
		assertThat(result.getResultId(), is(1));
		assertThat(result.getDerection(), is(inputResult.getDerection()));
		assertThat(result.getRank(), is(inputResult.getRank()));
		assertThat(result.getTime().toString(), is("Wed Aug 03 10:41:45 JST 2022"));
		assertThat(result.getEastScore(), is(inputResult.getEastScore()));
		assertThat(result.getSouthScore(), is(inputResult.getSouthScore()));
		assertThat(result.getWestScore(), is(inputResult.getWestScore()));
		assertThat(result.getNorthScore(), is(inputResult.getNorthScore()));
		assertThat(result.getEastPlayer(), is(inputResult.getEastPlayer()));
		assertThat(result.getSouthPlayer(), is(inputResult.getSouthPlayer()));
		assertThat(result.getWestPlayer(), is(inputResult.getWestPlayer()));
		assertThat(result.getNorthPlayer(), is(inputResult.getNorthPlayer()));

	}
	
	@Test
	@Sql(INIT_RESULT)
	void delete_正常系() throws Exception {
		// When
		resultMapper.delete(1);
		
		// Then
		Result result = resultMapper.findById(1);
		assertThat(result, is(nullValue()));
	}
	
	@Test
	@Sql(INIT_RESULT)
	void countResult_正常系() throws Exception {
		// Given
		Integer userId = 1;
		
		// When
		Long longResult = resultMapper.countResult(userId);
		
		// Then
		assertThat(longResult, is(13L));
	}
	
	/*
	 * ページ分割1ページ目 1件目から10件分を取得
	 */
	
	@Test
	@Sql(INIT_RESULT)
	void selectLimited_正常系_page1() throws Exception {
		// Given
		Integer userId = 1;
		
		// When
		List<Result> list = resultMapper.selectLimited(userId, 0, 10);
		
		// Then
		// 本番環境ではORDER BY time DESCが適用される
		assertThat(list.size(), is(10));
		
		assertThat(list.get(0).getResultId(), is(15));
		assertThat(list.get(0).getUserId(), is(1));
		assertThat(list.get(0).getDerection(), is("北家"));
		assertThat(list.get(0).getRank(), is(4));
		assertThat(list.get(0).getTime().toString(), is("Mon Oct 17 10:16:06 JST 2022"));
		assertThat(list.get(0).getEastScore(), is(25700));
		assertThat(list.get(0).getSouthScore(), is(35100));
		assertThat(list.get(0).getWestScore(), is(24200));
		assertThat(list.get(0).getNorthScore(), is(15000));
		assertThat(list.get(0).getEastPlayer(), is("小林三郎"));
		assertThat(list.get(0).getSouthPlayer(), is("渋谷五郎"));
		assertThat(list.get(0).getWestPlayer(), is("鈴木次郎"));
		assertThat(list.get(0).getNorthPlayer(), is("山田太郎"));
	}
	
	@Test
	@Sql(INIT_RESULT)
	void selectLimited_正常系_page2() throws Exception {
		// Given 
		Integer userId = 1;
		
		// When
		List<Result> list = resultMapper.selectLimited(userId, 10, 10);
		
		// Then
		// 本番環境ではORDER BY time DESCが適用される
		assertThat (list.size(), is(3));
		
		assertThat(list.get(0).getResultId(), is(5));
		assertThat(list.get(0).getUserId(), is(1));
		assertThat(list.get(0).getDerection(), is("東家"));
		assertThat(list.get(0).getRank(), is(1));
		assertThat(list.get(0).getTime().toString(), is("Wed Oct 05 14:13:32 JST 2022"));
		assertThat(list.get(0).getEastScore(), is(50000));
		assertThat(list.get(0).getSouthScore(), is(27600));
		assertThat(list.get(0).getWestScore(), is(27100));
		assertThat(list.get(0).getNorthScore(), is(-4700));
		assertThat(list.get(0).getEastPlayer(), is("山田太郎"));
		assertThat(list.get(0).getSouthPlayer(), is("鈴木次郎"));
		assertThat(list.get(0).getWestPlayer(), is("渋谷五郎"));
		assertThat(list.get(0).getNorthPlayer(), is("小林三郎"));
	}
}
