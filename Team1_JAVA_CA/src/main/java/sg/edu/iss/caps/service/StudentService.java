package sg.edu.iss.caps.service;

import java.util.ArrayList;

import org.springframework.data.domain.Page;


import sg.edu.iss.caps.domain.Enrolment;
import sg.edu.iss.caps.domain.Lecturer;
import sg.edu.iss.caps.domain.Student;

public interface StudentService {


	public ArrayList<Enrolment>listEnrolmentByCourseId(String courseId);

	public ArrayList<Enrolment>listEnrolmentByStudentId(String studentId);
	public Student getStudentByEmail(String email);
	
	
	public ArrayList<Enrolment> listCoursesEnrolledByStudentEmail (String email);
	
	public Student findStudentById(String id);
	public Student findStudentByName(String name);

}
