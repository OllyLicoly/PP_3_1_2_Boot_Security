package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.entities.Role;

//public interface RoleRepository {
@Repository
    public interface RoleRepository extends JpaRepository<Role, Long> {

//    List<Role> getAllRoles();
//
//    void saveRole(Role role);

}
