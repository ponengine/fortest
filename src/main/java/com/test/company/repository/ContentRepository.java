/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.company.repository;

import com.test.company.model.Content;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author OREOPON
 */
public interface ContentRepository extends CrudRepository<Content, Long>{

    List<Content> findAll();
    Content findById(String id);
    
    
    
}
