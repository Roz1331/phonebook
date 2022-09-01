package ru.test.phonebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.test.phonebook.entity.Member;
import ru.test.phonebook.repository.PhonesRepository;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    PhonesRepository phonesRepository;

    public List<Member> allMembers() {
        return phonesRepository.findAll();
    }

    public boolean saveMember(Member member) {
        Member memberDB = phonesRepository.findByPhoneNumber(member.getPhoneNumber());
        if (memberDB != null) return false;

        phonesRepository.save(member);
        return true;
    }

    public boolean deleteMember(Long id) {
        if (phonesRepository.findById(id).isPresent()) {
            phonesRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
