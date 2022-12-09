package com.example.softwarearchitecture.service;


import com.example.softwarearchitecture.dto.User;
import com.example.softwarearchitecture.repository.AddressPepository;
import com.example.softwarearchitecture.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final AddressPepository addressPepository;

    public UserService(UserRepository userRepository, AddressPepository addressPepository) {
        this.userRepository = userRepository;
        this.addressPepository = addressPepository;
    }

    @Transactional
    public User addUser(User user) {
        return userRepository.save(user);
    }
}
