package ru.test.phonebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.phonebook.entity.Member;

public interface PhonesRepository extends JpaRepository<Member, Long> {
    Member findByPhoneNumber(String phoneNumber);
}
