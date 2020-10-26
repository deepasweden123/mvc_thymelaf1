package se.fortnox.mvc_thymelaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.fortnox.mvc_thymelaf.dto.BoxDTO;
import se.fortnox.mvc_thymelaf.entity.Box;
import se.fortnox.mvc_thymelaf.repository.BoxRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private BoxRepository boxRepository;
    List<Box> boxes = new ArrayList<>();
    String name;
    int price;
    String color;
    @RequestMapping("/thymeleaf")
    public String getTestPage(Model model) {
        model.addAttribute("serverTime", LocalDateTime.now());
        name = "test";
        price = 1000;
        LocalDate date = LocalDate.now();
        model.addAttribute("name", name);
        model.addAttribute("price", price);
        model.addAttribute("color", color);
        model.addAttribute("d", date);


//        students.add(new Student(1, "Test1", "test1@lexicon.se", "Java"));
//        students.add(new Student(2, "Test2", "test2@lexicon.se", "Java"));
//        students.add(new Student(3, "Test3", "test3@lexicon.se", "Java"));

        Object boxes = null;
        model.addAttribute("Boxes", boxes);
        BoxDTO dto =new BoxDTO("Hema",50,"blue");
        model.addAttribute("dto",dto);
        return "test";
    }
    @PostMapping("add")
    public String saveStudent(@ModelAttribute BoxDTO dto){
        Box box = new Box(dto.getReceiverName(),dto.getWeight(),dto.getColor(),dto.getCountry());
       Box stdRes = boxRepository.save(box);
        boxes.add(stdRes);
        return "redirect:/test/thymeleaf";
    }
}
