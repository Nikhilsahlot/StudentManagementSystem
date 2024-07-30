package com.example.sms.controller;

import com.example.sms.entity.Student;
import com.example.sms.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller//to tell spring that this class will handle all http requests
public class StudentController {
private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    //handler method to handle list students and return mode and view
    @GetMapping("/students")
    public String listStudent(Model model){
        model.addAttribute("students",studentService.getAllStudents());
        return "students";//we are returning view and this view we have created in templates
    }
    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        //create student object to hold form data(firstname,lastname,email of new student)
        Student student=new Student();
        model.addAttribute("student",student);
        return "create_student";
    }
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
    studentService.saveStudent(student);
    return "redirect:/students";
    }
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model){
    model.addAttribute("student",studentService.getStudentById(id));
    return "edit_student";
    }
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("student") Student student,
                                Model model){
        //get student from database by id
        Student existingStudent =studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstname((student.getFirstname()));
        existingStudent.setLastname(student.getLastname());
        existingStudent.setEmail(student.getEmail());
        //save updated student object
        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }
    @GetMapping("/students/{id}")
        public String deleteStudents(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}


