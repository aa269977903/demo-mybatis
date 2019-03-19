package com.cest.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder(toBuilder = true)
@Data
public class User implements Serializable{

    private String id;

    private String userName;

    private Integer age;

    private String password;

    private String gender;

    private String genderName;
}