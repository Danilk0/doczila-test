package task2.http.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import task2.database.entety.Student;
import task2.database.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getStudents(Model model){
        model.addAttribute("students",studentService.findAllStudents());
        return "students";
    }

    @PostMapping
    public String create(Student student) {
        var integer = studentService.saveStudent(student);
        return "redirect:/students";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
