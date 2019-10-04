package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;



@Controller
public class HomeController {

    @Autowired
    GuestRepository guestRepository;

    @RequestMapping("/")
    public String listGuests(Model model) {
        model.addAttribute("guest", guestRepository.findAll());
        return "list";
    }


    @GetMapping("/add")
    public String guestForm(Model model) {
        model.addAttribute("guest", new Guest());
        return "guestform";

    }

    @PostMapping("/process")
    public String processForm(@Valid Guest guest, BindingResult result) {
        if (result.hasErrors()) {
            return "guestform";
        }
        guestRepository.save(guest);
        return "redirect:/";

    }

    @RequestMapping("/detail/{id}")
    public String showGuest(@PathVariable("id") long id, Model model) {
        model.addAttribute("guest", guestRepository.findById(id).get());
        return "show";
    }

        @RequestMapping("/update/{id}")
        public String updateGuest ( @PathVariable("id") long id, Model model){
            model.addAttribute("guest", guestRepository.findById(id).get());
            return "list";
        }

        @RequestMapping("/delete/{id}")
        public String delGuest ( @PathVariable("id") long id){
            guestRepository.deleteById(id);
            return "redirect:/";
        }

    }

