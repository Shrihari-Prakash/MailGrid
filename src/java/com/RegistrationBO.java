/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;


public class RegistrationBO {
    public int saveUser(User user){
        RegistrationDAO registrationDAO=new RegistrationDAO();
        int i=registrationDAO.saveUser(user);
        return i;
    }
}
