package ru.test.phonebook.service;

import org.springframework.stereotype.Service;
import ru.test.phonebook.entity.Member;
import ru.test.phonebook.repository.PhonesRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final PhonesRepository phonesRepository;

    public MemberService(PhonesRepository phonesRepository) {
        this.phonesRepository = phonesRepository;
    }

    public List<Member> allMembers() {
        List<Member> members = phonesRepository.findAll();
        members.sort(Comparator.comparing(Member::getId));
        return members;
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

    public Member findById(Long id) {
        Optional<Member> member = phonesRepository.findById(id);
        return member.orElseGet(Member::new);
    }
}
