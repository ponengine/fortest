/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.company.repository;

import com.test.company.model.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author OREOPON
 */
public interface UserRepository extends CrudRepository<User, Long>{
    List<User> findAll();
    User findByUserName(String userName);
    User findById(String id);
    
}
