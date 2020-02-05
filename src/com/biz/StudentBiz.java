package com.biz;

import java.util.List;

import com.dao.IStudentDao;
import com.dao.StudentDao;
import com.pojo.Clazz;
import com.pojo.Student;

public class StudentBiz implements IStudentBiz {
	private IStudentDao idao = new StudentDao();

	@Override
	public boolean save(Student st) {
		// TODO Auto-generated method stub
		return idao.save(st);
	}

	@Override
	public boolean update(Student st) {
		// TODO Auto-generated method stub
		return idao.update(st);
	}

	@Override
	public boolean delById(String sid) {
		// TODO Auto-generated method stub
		return idao.delById(sid);
	}

	@Override
	public Student findById(String sid) {
		// TODO Auto-generated method stub
		return idao.findById(sid);
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return idao.findAll();
	}

	@Override
	public List<Clazz> doinit() {
		// TODO Auto-generated method stub
		return idao.doinit();
	}

}
