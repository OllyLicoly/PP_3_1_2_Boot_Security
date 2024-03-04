package ru.kata.spring.boot_security.demo.dbInit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entities.Role;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.service.RoleServiceImp;
import ru.kata.spring.boot_security.demo.service.UserServiceImp;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class DBInit {
    private final UserServiceImp userService;
    private final RoleServiceImp roleService;

    @Autowired
    public DBInit(UserServiceImp userService, RoleServiceImp roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void run() {
        Role adminRole = new Role("ADMIN");
        Role userRole = new Role("USER");

        roleService.addRole(adminRole);
        roleService.addRole(userRole);

        userService.saveUser(new User("admin", "123", 22, "admin@mail.ru", Set.of(adminRole)));

        userService.saveUser(new User("user1", "456", 23, "user1@mail.ru", Set.of(userRole)));


    }
}
