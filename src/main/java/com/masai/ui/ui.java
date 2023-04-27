package com.masai.ui;

import java.util.Scanner;

import com.masai.db.StudentImpel;
import com.masai.db.StudentInt;
import com.masai.dto.Student;
import com.masaischool.lifecycle_dao.exception.NoRecordFoundException;
import com.masaischool.lifecycle_dao.exception.SomethingWentWrongException;

public class ui {
public static void main(String[] args)  {
	showMenu() ;

	
}

 private static void deleteStudentUI(Scanner sc) throws NoRecordFoundException, SomethingWentWrongException{
	 System.out.println("Enter Student id");
		int id=sc.nextInt();

			StudentInt sa=new StudentImpel ();
		   sa.deleteStudent(id);
}

private static void updateStudentUI(Scanner sc) throws NoRecordFoundException, SomethingWentWrongException {
	
	System.out.println("Enter Student id");
	int id=sc.nextInt();
	System.out.println("Enter course");
	String course=sc.next();

	System.out.println("Enter level");
	int level=sc.nextInt();
		StudentInt sa=new StudentImpel ();
		try {
			sa.updateStudent(id,course,level);
			System.out.println("Update Successfuly");
		}catch(IllegalArgumentException el) {
			throw new NoRecordFoundException(el.getMessage());
		}
}

private static void viewStudentUI(Scanner sc) throws NoRecordFoundException, SomethingWentWrongException {

	try {
		int id=sc.nextInt();

		StudentInt sa=new StudentImpel ();
	  Student a= sa.getStudentById(id);
	  System.out.println(a);
	}catch( NoRecordFoundException | SomethingWentWrongException e) {
		System.out.println(e.getMessage());
		showMenu();
	}
}

private static void showMenu() {
	
	Scanner sc = new Scanner(System.in);
	int choice = -1;
	do {
		System.out.println("0. Exit");
		System.out.println("1. Add Student");
		System.out.println("2. View Student by Id");
		System.out.println("3. Update Student");
		System.out.println("4. Delete Student");
		System.out.print("Enter Selection ");
		try {
		choice = sc.nextInt();
		switch(choice) {
			case 0:
				System.out.print("Thanks for using our services");
				break;
			case 1:
				addStudentUI(sc);
				break;
			case 2:
				viewStudentUI(sc);
				break;
			case 3:
				updateStudentUI(sc);
				break;
			case 4:
				deleteStudentUI(sc);
				break;
			default:
				System.out.print("Invalid Selection, try again");
		}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			showMenu() ;
		}
	}while(choice != 0);
	sc.close();
	
}

private static void addStudentUI(Scanner sc)  throws NoRecordFoundException{
	 
System.out.println("Enter email");	
String email=sc.next();

System.out.println("Enter Address");
String address=sc.next();

System.out.println("Enter course");
String course=sc.next();

System.out.println("Enter level");
int level=sc.nextInt();

	Student s=new Student(email, address, course, level);
	
	StudentInt sa=new StudentImpel ();
   try {
	sa.addStudent(s);
} catch (IllegalArgumentException e) {
	// TODO Auto-generated catch block
	throw new NoRecordFoundException(e.getMessage()) ;
}
}


}
