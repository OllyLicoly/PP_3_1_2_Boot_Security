//package ru.kata.spring.boot_security.demo.repositories;
//
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//import ru.kata.spring.boot_security.demo.entities.Role;
//import ru.kata.spring.boot_security.demo.entities.User;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.List;
//
//@Repository
//public class RoleRepositoryImp implements RoleRepository{
//
//    @PersistenceContext
//    private EntityManager manager;
//
//    @Override
//    public List<Role> getAllRoles() {
//        return manager.createQuery("from Role", Role.class).getResultList();
//    }
//
//    @Transactional
//    @Override
//    public void saveRole(Role role) {
//        manager.persist(role);
//    }
//}
