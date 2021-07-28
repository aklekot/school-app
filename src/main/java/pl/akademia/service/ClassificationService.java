package pl.akademia.service;

import org.springframework.stereotype.Service;
import pl.akademia.entity.Classification;
import pl.akademia.repository.ClassificationRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ClassificationService {
     private ClassificationRepository classificationRepository;

    public ClassificationService(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }


    public List<Classification> saveMarks(List<Classification> classifications){
        return classificationRepository.saveAll(classifications);
    }

    public List<Classification> getStudentsMarks(){
        return classificationRepository.findAll();
    }

    public List<Classification> getStudentMarks(Long id){
        return classificationRepository.getStudentMarks(id);
    }

    public Classification addOrUpdateClassification(Classification classification){
        return classificationRepository.save(classification);
    }

    public BigDecimal avgStudentById(Long id){
        return classificationRepository.avgStudentById(id);
    }
}
