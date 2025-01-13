package com.dochdonatello.firststartspringboot.service;
import com.dochdonatello.firststartspringboot.models.User;
import java.util.List;

public interface UserService {
    List<User> getAllUserActive();
    void insertAndUpdate(User user);
}
