package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.entities.User;

import java.util.List;


//public interface UserRepository {
    public interface UserRepository{

//    @Query("select u from User u left join fetch u.roles")
    List<User> getAllUsers();

//    @Query("select u from User u left join fetch u.roles where u.username=:username")
    User findByUsername(String username);

//    @Query("select u from User u left join fetch u.roles where u.id=:id")
    User findUserById(Long id);

//    @Query("insert into User (name, password, age, email, left join fetch u.roles) values (:name, :password, :age, :email, left join fetch u.roles :role)")
//    void saveNewUser(User user);

//    INSERT INTO users (name, password, age, email) VALUES ('user5', 'user5', 25, 'user5@mail.ru');
//    @Modifying

//    @Query("INSERT INTO User (name, password, age, email) select u.name, u.password, u.age, u.email from User u")
//    void saveNewUser(User user);


//    @Query(value = "INSERT INTO User (username, password, age, email, role) SELECT username, password, age, email, role FROM user", nativeQuery = true)
//    void saveNewUser(User user);

//    @Transactional
//    @Modifying
//    @Query(value = "INSERT INTO users (name, password, age, email) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    void saveUser(User user);


//    @Query("update User u set u.username=:username, u.password=:password, u.age=:age, u.email=:email")
//            " INSERT INTO User (name, password, age, email) select u.name, u.password, u.age, u.email ")
//    void updateUser(User user);

//    update Customer c set c.name = :newName where c.name = :oldName";
//
//    insert into DelinquentAccount (id, name) select c.id, c.name from Customer c where ...";

//    @Query("delete from User u where u.id=:id")
    void deleteUserById(Long id);

}
