package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Clazz;
import com.pojo.Student;

public class StudentDao implements IStudentDao {
	private ResultSet rst = null;

	@Override
	public boolean save(Student st) {
		System.out.println("dao层" + st.toString());
		String sql = "insert into student(sname,sex,address,birthday,classid) values(?,?,?,?,?)";
		int rows = DbHelperDao.executeUpdate(sql,
				new Object[] { st.getSname(), st.getSex(), st.getAddress(), st.getBirthday(), st.getClassid() });
		if (rows > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Student st) {
		String sql = "update student set sname=?,sex=?,address=?,birthday=?,classid=? where stuid=?";
		int rows = DbHelperDao.executeUpdate(sql, new Object[] { st.getSname(), st.getSex(), st.getAddress(),
				st.getBirthday(), st.getClassid(), st.getStuid() });
		if (rows > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delById(String sid) {
		String sql = "delete from student where stuid=?";
		int rows = DbHelperDao.executeUpdate(sql, new Object[] { sid });
		if (rows > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Student findById(String sid) {
		String sql = "select * from vwstu where stuid=?";
		rst = DbHelperDao.executeQuery(sql, new Object[] { sid });
		try {
			if (rst.next()) {
				Student st = new Student(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4),
						rst.getString(5), rst.getString(6), rst.getString(7));
				return st;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Student> findAll() {
		List<Student> list = new ArrayList<Student>();
		String sql = "select * from vwstu";
		rst = DbHelperDao.executeQuery(sql, null);
		try {
			while (rst.next()) {
				Student st = new Student(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4),
						rst.getString(5), rst.getString(6), rst.getString(7));
				list.add(st);
			}
		} catch (Exception e) {

		}
		return list;
	}

	@Override
	public List<Clazz> doinit() {
		List<Clazz> lsca = new ArrayList<Clazz>();
		String sql = "select * from clazz where 1=1 order by cid";
		rst = DbHelperDao.executeQuery(sql, null);

		try {
			while (rst.next()) {
				System.out.println("111111111111");

				Clazz ca = new Clazz(rst.getString(1), rst.getString(2));
				lsca.add(ca);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(lsca.size());
		return lsca;
	}

}
