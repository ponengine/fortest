package com.test.company.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;



@Table
@Entity
@Getter
@Setter
public class User {
    
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    @Id
    private Long id;
    private String userName;
    private String password;
    private String email;
    private String nickName;
    
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  private List<Content> content;
}
