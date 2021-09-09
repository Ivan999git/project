package com.technicalTask.controller;

import com.technicalTask.model.Mkb;
import com.technicalTask.repository.MkbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Registration {

    private final MkbRepository mkbRepository;

    @Autowired
    public Registration(MkbRepository mkbRepository) {
        this.mkbRepository = mkbRepository;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addMkb(@RequestParam String code, @RequestParam String diagnosis, Model model) {
        Mkb mkb = new Mkb(code, diagnosis);
        mkbRepository.save(mkb);

        List<Mkb> mkbList = mkbRepository.findAll();
        model.addAttribute("mkb", mkbList);
        return "redirect:/";
    }
}
