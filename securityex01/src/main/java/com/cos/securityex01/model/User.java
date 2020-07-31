package com.cos.securityex01.model;

import lombok.Data;

@Data
public class User {
	private int id;
	private String username;
	private String password;
	private String email;
}
