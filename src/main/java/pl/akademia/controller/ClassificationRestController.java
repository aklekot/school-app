package pl.akademia.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.akademia.entity.Classification;
import pl.akademia.service.ClassificationService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClassificationRestController {
    private final ClassificationService classificationService;

    public ClassificationRestController(ClassificationService classificationService) {
        this.classificationService = classificationService;
    }

    @GetMapping("/classification")
    public ResponseEntity<?> getStudentsMarks(@RequestParam(required = false, value = "studentId") Long studentId){
        if (studentId!=null){
            List<Classification> classification = classificationService.getStudentMarks(studentId);
            return new ResponseEntity<>(classification, HttpStatus.OK);
        }
        List<Classification> classifications= classificationService.getStudentsMarks();
        return  new ResponseEntity<>(classifications, HttpStatus.OK);
    }

    @GetMapping("/classification/{id}/score/avg")
    public ResponseEntity<BigDecimal> avgStudentById(@PathVariable Long id) {
        if (classificationService.avgStudentById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(classificationService.avgStudentById(id),HttpStatus.OK);
    }
}
