package pl.akademia.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.akademia.entity.ClassT;
import pl.akademia.entity.Student;
import pl.akademia.service.ClassTService;

@RestController
@RequestMapping("/api/v1")
public class ClassRestController {

        private final ClassTService classService;

    public ClassRestController(ClassTService classService) {
        this.classService = classService;
    }


    @PostMapping("/classes")
    public ResponseEntity<ClassT> addOrUpdateClass(@RequestBody ClassT class1){
        if (class1.getId() == null){
            return new ResponseEntity<>(classService.addOrUpdateClass(class1),HttpStatus.CREATED);
        }
        return  new ResponseEntity<>(classService.addOrUpdateClass(class1),HttpStatus.OK);
    }

}
