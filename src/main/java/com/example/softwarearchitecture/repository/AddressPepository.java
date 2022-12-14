package com.example.softwarearchitecture.repository;

import com.example.softwarearchitecture.dto.Address;
import com.example.softwarearchitecture.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressPepository extends CrudRepository<Address, Integer> {

    @Query("select * from address a where a.user.id=:uid")
    List<Address> find(int uid);
}
