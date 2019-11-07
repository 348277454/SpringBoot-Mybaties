package com.ss.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.ResultHandler;

import com.ss.pojo.Student;

@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM student")
    List<Student> findAll();

	int insert(Student student);

	void searchForwardOnly(ResultHandler<Student> resultHandler);
}