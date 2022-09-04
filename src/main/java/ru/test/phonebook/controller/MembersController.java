package ru.test.phonebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.test.phonebook.entity.Member;
import ru.test.phonebook.service.MemberService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MembersController {
    private final MemberService memberService;

    @Autowired
    public MembersController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("add")
    public void addMember(@RequestParam(value = "name") String name,
                          @RequestParam(value = "phoneNumber") String phoneNumber) {
        memberService.saveMember(new Member(name, phoneNumber));
    }

    @GetMapping("updateTable")
    public Map<String, Object> getLastMember() {
        List<Member> members = memberService.allMembers();

        Member lastMember = members.get(members.size() - 1);
        Map<String, Object> result = new HashMap<>();
        result.put("id", lastMember.getId());
        result.put("name", lastMember.getName());
        result.put("phoneNumber", lastMember.getPhoneNumber());
        result.put("date", lastMember.getDate());

        return result;
    }

    @GetMapping("delete")
    public void deleteMember(@RequestParam(value = "id") String id) {
        memberService.deleteMember(Long.parseLong(id));
    }

    @GetMapping("updateMember")
    public void updateMember(@RequestParam(value = "id") String id,
                             @RequestParam(value = "name") String name,
                             @RequestParam(value = "phoneNumber") String phoneNumber) {

        Long id_parsed = Long.parseLong(id);
        Member member = memberService.findById(id_parsed);
        member.setName(name);
        member.setPhoneNumber(phoneNumber);
        memberService.saveMember(member);
    }
}
