package com.dochdonatello.firststartspringboot.service.impl;

import com.dochdonatello.firststartspringboot.models.User;
import com.dochdonatello.firststartspringboot.repository.UserRepository;
import com.dochdonatello.firststartspringboot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    //Dependency inject => Create new object
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUserActive() {
        return userRepository.findAllByStatus("ACT");
    }

    @Override
    public void insertAndUpdate(User user) {
        user.setId(user.getId());
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        user.setStatus("ACT");
        user.setEmail(user.getEmail());
        user.setPhoneNumber(user.getPhoneNumber());
        userRepository.save(user);
    }
}
