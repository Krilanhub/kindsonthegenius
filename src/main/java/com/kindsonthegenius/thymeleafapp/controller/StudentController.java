package com.kindsonthegenius.thymeleafapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kindsonthegenius.thymeleafapp.models.Student;
import com.kindsonthegenius.thymeleafapp.services.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/getAll")
	public String getAll(Model model) {
		List<Student> students = studentService.getAll();
		model.addAttribute("students", students);

		String username = "Krilan";
		model.addAttribute("username", username);

		return "allstudent";
	}

	@RequestMapping("/getOne")
	@ResponseBody
	public Optional<Student> getOne(Integer Id) {
		return studentService.getOne(Id);
	}

	@PostMapping("/addNew")
	public String addNew(Student student, BindingResult br) {
		studentService.addNew(student);
		if (br.hasErrors()) {
			System.out.println(br.getAllErrors());
		}
		return "redirect:/students/getAll";
	}

	@RequestMapping(value = "/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Student student) {
		studentService.update(student);
		return "redirect:/students/getAll";
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer Id) {
		studentService.delete(Id);
		return "redirect:/students/getAll";
	}

}
