package com.ss.service.impl;

import java.util.List;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.mapper.GxidResultHandler;
import com.ss.mapper.StudentMapper;
import com.ss.pojo.Student;
import com.ss.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentMapper studentMapper;

	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	GxidResultHandler gxidResultHandler;
	
	@Override
	public List<Student> findAll() {

		return studentMapper.findAll();
	}

	@Override
	public void searchAll() {

	    sqlSessionTemplate.select(" com.ss.mapper.StudentMapper.searchForwardOnly", gxidResultHandler);
	    //gxidResultHandler.end();

	}

	
}
