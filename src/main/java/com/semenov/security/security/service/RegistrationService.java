package com.semenov.security.security.service;


import com.semenov.security.security.entity.Person;
import com.semenov.security.security.exceptionhandling.RegistrationException;
import com.semenov.security.security.repositiry.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final PersonRepository personRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void register(Person person) {
        checkUser(person);

        String encodePassword = passwordEncoder.encode(person.getPassword());
        person.setPassword(encodePassword);
        person.setRole("ROLE_USER");
        personRepository.save(person);
    }


    private void checkUser(Person person) {
        Optional<Person> user = personRepository.findByUsername(person.getUsername());
        if (user.isPresent()) {
            throw new RegistrationException("User with name " + person.getUsername() + " already exists!");
        }
    }
}
