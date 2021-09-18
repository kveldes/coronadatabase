//Μια απλη POJO class για να κραταει τα credentials για το authentication.
package com.test.coronadatabase.domain;

public class AccountCredentials {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
