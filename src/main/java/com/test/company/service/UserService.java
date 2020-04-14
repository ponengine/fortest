/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.company.service;

import com.test.company.domain.BaseResponse;
import com.test.company.domain.BaseRestApi;
import com.test.company.dto.UserDTO;
import com.test.company.model.User;
import com.test.company.repository.UserRepository;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author OREOPON
 */
@Service
public class UserService {

    private UserRepository userReppository;

    @Autowired
    private UserService(UserRepository userReppository) {
        this.userReppository = userReppository;
    }

    public BaseRestApi get() {
        BaseRestApi baseapi = new BaseRestApi();
        BaseResponse<List<User>> response = new BaseResponse<List<User>>();
        List<User> findAllData = userReppository.findAll();
        response.setData(findAllData);
        baseapi.setResponse(response);
        baseapi.setSuccess(true);
        return baseapi;
    }

    public BaseRestApi register(UserDTO user) {
        BaseRestApi baseapi = new BaseRestApi();
        BaseResponse<List<User>> response = new BaseResponse<List<User>>();
        User userConditon = userReppository.findByUserName(user.getUsername());
        if (userConditon != null) {
            response.setErrorCode("005");
            response.setErrorMessage("Already user in system");
            baseapi.setResponse(response);
            baseapi.setSuccess(false);
            return baseapi;
        }
        User newUser = new User();

        BeanUtils.copyProperties(newUser, user);
        userReppository.save(newUser);
        baseapi.setSuccess(true);
        return baseapi;

    }

    public BaseRestApi update(UserDTO user) {
        BaseRestApi baseapi = new BaseRestApi();
        BaseResponse<List<User>> response = new BaseResponse<List<User>>();
        User userData = userReppository.findByUserName(user.getUsername());
        if (userData != null) {
            response.setErrorCode("006");
            response.setErrorMessage("User not found");
            baseapi.setResponse(response);
            baseapi.setSuccess(false);
            return baseapi;
        }
        userData.setNickName(user.getNickName());
        userData.setEmail(user.getEmail());
        userReppository.save(userData);
        baseapi.setSuccess(true);
        return baseapi;

    }

    public BaseRestApi delete(Long id) {
        BaseRestApi baseapi = new BaseRestApi();
        BaseResponse<List<User>> response = new BaseResponse<List<User>>();
        User userData = userReppository.findById(id.toString());
        if (userData != null) {
            response.setErrorCode("006");
            response.setErrorMessage("User not found");
            baseapi.setResponse(response);
            baseapi.setSuccess(false);
            return baseapi;
        }
        userReppository.delete(userData);
        baseapi.setSuccess(true);
        return baseapi;
    }

}
