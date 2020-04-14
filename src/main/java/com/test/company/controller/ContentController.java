/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.company.controller;

import com.test.company.domain.BaseRestApi;
import com.test.company.dto.ContentDTO;
import com.test.company.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author OREOPON
 */
@RestController
@RequestMapping("/content")
public class ContentController {

     private ContentService contentService;

    @Autowired
    private ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("/get")
    public BaseRestApi get() {
        return contentService.get();
    }

    @PostMapping("/register")
    public BaseRestApi insert(@RequestBody ContentDTO content) {
        return contentService.register(content);
    }

    @PutMapping("/update/id")
    public BaseRestApi update(@PathVariable Long id,@RequestBody ContentDTO content) {
        return contentService.update(id,content);
    }

    @DeleteMapping("/delete/id")
    public BaseRestApi delete(@PathVariable Long id) {
        return contentService.delete(id);
    }

}
