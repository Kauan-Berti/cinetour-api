package com.group.cinetour.service;

import com.group.cinetour.dto.RegisterDTO;
import com.group.cinetour.model.User;
import com.group.cinetour.model.enums.UserRole;
import com.group.cinetour.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void insert(RegisterDTO data){
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.name(), data.email(), encryptedPassword, UserRole.USER);
        this.userRepository.save(newUser);
    }
}
