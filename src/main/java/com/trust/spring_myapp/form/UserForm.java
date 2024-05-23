package com.trust.spring_myapp.form;

import jakarta.validation.constraints.NotBlank;

public class UserForm {
	private Integer id;
	private String email;
    private String password;
    private String userName;

    // ゲッター セッター
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getEmail() {
        return email;
    }

    @NotBlank
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    @NotBlank
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    @NotBlank
    public void setUserName(String userName) {
        this.userName = userName;
    }

}
