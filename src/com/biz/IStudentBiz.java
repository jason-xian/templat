package com.biz;

import java.util.List;

import com.pojo.Clazz;
import com.pojo.Student;

public interface IStudentBiz {
	public boolean save(Student st);

	public boolean update(Student st);

	public boolean delById(String sid);

	public Student findById(String sid);

	public List<Student> findAll();

	public List<Clazz> doinit();
}
