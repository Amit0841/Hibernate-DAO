package com.masai.db;

import com.masai.dto.Student;
import com.masaischool.lifecycle_dao.exception.NoRecordFoundException;
import com.masaischool.lifecycle_dao.exception.SomethingWentWrongException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class StudentImpel implements StudentInt{


	@Override
	public void addStudent(Student s) throws NoRecordFoundException {
		EntityManager em= connectionClass.connectionget();
		EntityTransaction et=em.getTransaction();
		et.begin();
		try {
		em.persist(s);
		}catch(IllegalArgumentException el) {
			throw new NoRecordFoundException(el.getMessage());
		}finally{
			et.commit();
		em.close();
		}
	}
	
	@Override
	public void updateStudent(int id, String course, int level)throws NoRecordFoundException,SomethingWentWrongException {
		Student id2= getStudentById( id);
		id2.setCourse(course);
		id2.setLevel(level);
		
		EntityManager em= connectionClass.connectionget();
		EntityTransaction et=em.getTransaction();
		try {
			et.begin();
			em.merge(id2);
		}catch(IllegalArgumentException  el) {
			throw new SomethingWentWrongException(el.getMessage());
		}
		finally{
		et.commit();
		em.close();
		}
	}

	@Override
	public Student getStudentById(int id) throws NoRecordFoundException, SomethingWentWrongException{
		EntityManager em= connectionClass.connectionget();

		Student stu=null;
		
			stu=em.find(Student.class, id);
			em.close();
			if(stu==null) {
				throw new NoRecordFoundException("Invalid id ");
			}

		return stu;
	}

	@Override
	public void deleteStudent(int id) {
		
		EntityManager em= connectionClass.connectionget();
		EntityTransaction et=em.getTransaction();
		Student stu= em.find(Student.class, id);
		et.begin();
		em.remove(stu);
		et.commit();
		em.close();
	}





}
