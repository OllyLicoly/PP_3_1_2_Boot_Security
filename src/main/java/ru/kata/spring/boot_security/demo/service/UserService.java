package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.entities.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    User findUserById(Long id);

    User findUserByUsername(String username);

    void updateUser(User user);
//    void updateUser(User user, Long id);

    void deleteUserById(Long id);

    List<User> getAllUsers();
}
