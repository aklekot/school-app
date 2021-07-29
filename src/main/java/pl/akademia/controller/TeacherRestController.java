package pl.akademia.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.akademia.entity.Student;
import pl.akademia.exceptions.StudentNotFoundException;
import pl.akademia.exceptions.TeacherNotFoundException;
import pl.akademia.service.TeacherService;
import pl.akademia.entity.Teacher;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TeacherRestController {

    private final TeacherService teacherService;

    public TeacherRestController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public ResponseEntity<?> getTeachers(@RequestParam(required = false, value = "lastName") String lastName){
        List<Teacher> teachers = teacherService.getTeacherByName(lastName);
        if (lastName!=null) {
            if (teachers == null) {
                throw new TeacherNotFoundException("Teacher not found");
            }
            return new ResponseEntity<>(teachers,HttpStatus.OK);
        }
        List<Teacher> teachers1 = teacherService.getAllTeachers();
        return new ResponseEntity<>(teachers1,HttpStatus.OK);
    }


    @GetMapping("/teachers/{id}")
    public ResponseEntity<?> getTeacherById(@PathVariable Long id){
        Teacher teacher = teacherService.getTeacherById(id);
        if (teacher == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return  new ResponseEntity<>(teacher, HttpStatus.OK);

    }

    @GetMapping("/teachers/subject/{subject}")
    public ResponseEntity<?> getTeacherBySubject(@PathVariable String subject){
        List<Teacher> teachers = teacherService.getTeacherBySubject(subject);
        if (teachers == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @PostMapping("/teachers")
    public ResponseEntity<Teacher> addOrUpdateTeacher(@RequestBody Teacher teacher){
    if (teacher.getId() == null){
        return new ResponseEntity<>(teacherService.addOrUpdateTeacher(teacher),HttpStatus.CREATED);
    }
    return  new ResponseEntity<>(teacherService.addOrUpdateTeacher(teacher),HttpStatus.OK);
    }

    @DeleteMapping("/teachers/{id}/delete")
    public  ResponseEntity<?> deleteTeacherById(@PathVariable Long id){
        if (teacherService.deleteTeacherById(id)>0){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }



}
