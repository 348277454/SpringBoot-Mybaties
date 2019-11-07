package com.ss;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ss.mapper.GxidResultHandler;
import com.ss.mapper.StudentMapper;
import com.ss.pojo.Student;
import com.ss.service.StudentService;

/**
 * @author cronous
 * @create 2018-11-01 15:20
 */
@ComponentScan("com.ss")
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ChapterTest.class)
@SpringBootTest
public class ChapterTest {

	private static final Logger log = LoggerFactory.getLogger(ChapterTest.class);

	@Resource
	private StudentMapper studentMapper;

	@Resource
	private StudentService studentService;

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	

	@Autowired
	GxidResultHandler gxidResultHandler;

	@Test
	public void test1() throws Exception {

		final int row1 = studentMapper.insert(new Student("佟大为"));
		log.info("[添加结果] - [{}]", row1);
		final int row2 = studentMapper.insert(new Student("任盈盈"));
		log.info("[添加结果] - [{}]", row2);
		final int row3 = studentMapper.insert(new Student("令狐冲"));
		log.info("[添加结果] - [{}]", row3);

	}

	@Test
	public void test2() throws Exception {

		studentService.searchAll();

	}

	@Test
	public void test3() throws Exception {
		
		String sql = "com.ss.mapper.StudentMapper.searchForwardOnly";
		sqlSessionTemplate.select(sql, gxidResultHandler);
	}
}
