package pl.akademia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.akademia.entity.Student;
import pl.akademia.service.StudentService;


import java.util.Objects;

@Controller
public class StudentFrontController {
    private StudentService studentService;

    public StudentFrontController(StudentService studentService) {
        this.studentService = studentService;
    }

//    @GetMapping("/students")
//    public String getStudentPage(Model model,
//                                 @RequestParam(required = false) String getStudents,
//                                 @RequestParam(required = false) String getStudentByLastname,
//                                 @RequestParam(required = false) String getStudentByClassName,
//                                 @RequestParam(required = false) String info) {
//        if (Objects.equals(Integer.toString(1), getStudents)) {
//            model.addAttribute("students", studentService.getStudents());
//        }
//        if (getStudentByLastname != null) {
//            model.addAttribute("studentByLastname", studentService.getStudentByLastname(getStudentByLastname));
//        }
//        if(getStudentByClassName !=null) {
//            model.addAttribute("studentByClassName",studentService.getStudentByClassName(getStudentByClassName));
//        }
//        if (info != null){
//            model.addAttribute("info", info);
//        }
//        return "student";
//    }
//
//    @GetMapping("/addStudent")
//    public String getAddStudentPage(Model model, @RequestParam(required = false) String info){
//        model.addAttribute("info", info);
//        return "addStudent";
//    }
//
//    @PostMapping("add/student")
//    public String addStudent(@ModelAttribute Student student){
//        studentService.addOrUpdateStudent(student);
//        return "redirected:/addStudent?info=Student zostal zapisany/zaktualizowany";
//    }
//    @GetMapping("/delete/student")
//    public String deleteStudent(@RequestParam Long id) {
//        studentService.deleteStudentById(id);
//        String info = "Student o nr: "+ id + " zostal usuniety z bazy";
//        return "redirect:/student?info=" + info;
//    }
//
//    @GetMapping("/getStudents")
//    public String getAllStudents() {
//        return "redirect:/student?getAllStudents=1";
//    }
//
//    @GetMapping("/getStudentByLastname")
//    public String getStudentByLastname(@RequestParam String lastName) {
//        return "redirect:/student?getStudentByLastname=" + lastName;
//    }
//
//    @GetMapping("/getStudentByClassName")
//    public String getStudentByClassName(@RequestParam String className) {
//        return "redirect:/student?getStudentByClassName=" + className;
//    }
}