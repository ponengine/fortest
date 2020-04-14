/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.company.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author OREOPON
 */
@Getter
@Setter
public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String nickName;

}
