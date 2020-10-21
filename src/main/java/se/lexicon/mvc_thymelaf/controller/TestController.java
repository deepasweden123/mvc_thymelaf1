package se.lexicon.mvc_thymelaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.lexicon.mvc_thymelaf.dto.StudentDTO;
import se.lexicon.mvc_thymelaf.entity.Student;
import se.lexicon.mvc_thymelaf.repository.StudentRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mehrdad Javan
 * Date: Oct, 2020
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private StudentRepository studentRepository;


    List<Student> students = new ArrayList<>();

    String name;
    int price;

    @RequestMapping("/thymeleaf")
    public String getTestPage(Model model) {
        model.addAttribute("serverTime", LocalDateTime.now());

        name = "test";
        price = 1000;
        LocalDate date = LocalDate.now();

        model.addAttribute("name", name);
        model.addAttribute("price", price);
        model.addAttribute("d", date);


//        students.add(new Student(1, "Test1", "test1@lexicon.se", "Java"));
//        students.add(new Student(2, "Test2", "test2@lexicon.se", "Java"));
//        students.add(new Student(3, "Test3", "test3@lexicon.se", "Java"));

        model.addAttribute("students", students);

        StudentDTO dto =new StudentDTO();
        model.addAttribute("dto",dto);
        return "test";
    }


    @PostMapping("add")
    public String saveStudent(@ModelAttribute StudentDTO dto){
        Student student = new Student(dto.getName(),dto.getEmail(),dto.getCourse());
         Student stdRes = studentRepository.save(student);
        students.add(stdRes);
        return "redirect:/test/thymeleaf";
    }
}
