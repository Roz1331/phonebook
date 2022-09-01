package ru.test.phonebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.test.phonebook.entity.Member;
import ru.test.phonebook.service.MemberService;

import java.util.List;

@Controller
public class PhonesTableController {
    final MemberService memberService;

    @Autowired
    public PhonesTableController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        List<Member> members = memberService.allMembers();
        model.addAttribute("allMembers", members);
        return "index";
    }
}
