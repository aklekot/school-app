package pl.akademia.service;

import org.springframework.stereotype.Service;
import pl.akademia.entity.ClassT;
import pl.akademia.entity.Student;
import pl.akademia.repository.ClassRepository;

import java.util.List;

@Service
public class ClassTService {
    private ClassRepository classRepository;

    public ClassTService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    public ClassT saveClass(ClassT aClassT){
        return classRepository.save(aClassT);
    }

    public List<ClassT> saveClass(List<ClassT> aClassTS){

        return classRepository.saveAll(aClassTS);
    }

    public List<ClassT> getClasses(){

        return classRepository.findAll();
    }


    public ClassT addOrUpdateClass(ClassT classT1){
        return classRepository.save(classT1);
    }



}
