package pl.akademia.service;

import org.springframework.stereotype.Service;


import pl.akademia.repository.TeacherRepository;
import pl.akademia.entity.Teacher;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TeacherService {


    private final TeacherRepository repository;

    public TeacherService(TeacherRepository repository) {
        this.repository = repository;
    }

    public Teacher saveTeacher(Teacher teacher){
       return repository.save(teacher);
    }

    public List<Teacher> saveTeacher(List<Teacher> teachers){

        return repository.saveAll(teachers);
    }

    public List<Teacher> getTeachers(){

        return repository.findAll();
    }

    public List<Teacher> getAllTeachers(){
       List<Teacher> teachers = repository.findAll();
        return teachers;
    }

    public Teacher getTeacherById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Teacher> getTeacherBySubject(String subject){
        return repository.getTeacherBySubject(subject);
    }

    public Teacher addOrUpdateTeacher(Teacher teacher){
        return repository.save(teacher);
    }
    @Transactional
    public int deleteTeacherById(Long id){
       return repository.deleteTeacherById(id);
    }



    public List<Teacher> getTeacherByName(String lastName){
        return repository.getTeacherByLastname(lastName);
    }
}
