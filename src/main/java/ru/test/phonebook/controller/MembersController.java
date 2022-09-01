package ru.test.phonebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.test.phonebook.entity.Member;
import ru.test.phonebook.service.MemberService;

@RestController
public class MembersController {
    private final MemberService memberService;

    public MembersController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("add")
    public void addMember(@RequestParam(value = "name") String name,
                          @RequestParam(value = "phoneNumber") String phoneNumber) {
        memberService.saveMember(new Member(name, phoneNumber));
    }

}
