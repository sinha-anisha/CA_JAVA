package sg.edu.iss.caps.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.service.StudentService;

@Controller
@RequestMapping("/studentEnrolment")
public class StudentEnrolmentController 
{
	
	@Autowired
	StudentService sservice;

	@RequestMapping("/coursesForEnrolment")
	public String showCoursesForEnrolment(@ModelAttribute("courses") Course courses,Model model)
	{
		return "view-courses";
	}
	
	//filter by email and list down courses that a particular student is enrolled in
	//hard-coded email address in to test the code first
	@RequestMapping("/enrolledCourses")
	public String showEnrolledCourses(@ModelAttribute("courses") Course courses,Model model,
						HttpSession session)
	{
		UserSession usession = (UserSession) session.getAttribute("usession");
		String currentusername=usession.getUser().getUsername();
		model.addAttribute("sdata", sservice.listCoursesEnrolledByStudentEmail(currentusername));
		return "enrolled-courses";
	}
}
