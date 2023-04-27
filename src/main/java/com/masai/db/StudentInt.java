package com.masai.db;

import com.masai.dto.Student;
import com.masaischool.lifecycle_dao.exception.NoRecordFoundException;
import com.masaischool.lifecycle_dao.exception.SomethingWentWrongException;

public interface StudentInt {
void addStudent(Student s) throws NoRecordFoundException;
void updateStudent(int id, String course, int level) throws NoRecordFoundException, SomethingWentWrongException;
Student getStudentById(int id) throws NoRecordFoundException, SomethingWentWrongException;
void deleteStudent(int id);
}
