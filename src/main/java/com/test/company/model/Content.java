/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.company.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Helper;

/**
 *
 * @author OREOPON
 */
@Table
@Entity
@Getter
@Setter
public class Content {
    
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "content_seq")
    @SequenceGenerator(name = "content_seq", sequenceName = "content_seq", allocationSize = 1)
    @Id
    private Long id;
    private String title;
    private String detail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

}
