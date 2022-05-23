package task2.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task2.database.entity.Student;
import task2.database.dao.StudentDao;

import java.util.List;

@Service
public class StudentService {

    private final StudentDao studentRepository;

    @Autowired
    public StudentService(StudentDao studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public Integer saveStudent(Student student){
        return studentRepository.save(student);
    }

    public boolean deleteStudent(Integer id){
        return studentRepository.delete(id);
    }
}
