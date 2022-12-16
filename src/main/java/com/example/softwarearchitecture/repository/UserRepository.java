package com.example.softwarearchitecture.repository;

import com.example.softwarearchitecture.dto.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("select * from user u join address a on u.id=a.user_id where a.id=:aid")
    Optional<User> find(int aid);

    @Query("select * from user u where u.account=:account and u.password=:password")
    User find(String account, String password);
}
