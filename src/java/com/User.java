/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

/**
 *
 * @author NIIT
 */
public class User {
    private String name;
    private String password;
 private String email;
    public String getName() {
        return name;
    }
 public String getEmail() {
      return email;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
  public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "User{" + "name=" + name + ", password=" + password + '}';
    }
    
    
}
