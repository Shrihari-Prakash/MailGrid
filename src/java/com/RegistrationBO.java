package com;

public class RegistrationBO {

    public int saveUser(User user) {
        RegistrationDAO registrationDAO = new RegistrationDAO();
        int i = registrationDAO.saveUser(user);
        return i;
    }
}
