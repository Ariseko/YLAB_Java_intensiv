package org.example.service;

import org.example.User;
import org.example.utils.StringConstants;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private User currentUser;
    private final Map<String, User> users;

    public UserService(Map<String, User> users) {
        this.users = users;
    }

    public boolean register(User user) {
        if (users.containsKey(user.getLogin())) {
            System.out.println(StringConstants.USER_NOT_FOUND_ERROR.formatted(user.getLogin()));
            return false;
        }

        users.put(user.getLogin(), user);
        return true;
    }

    public boolean login(User user) {
        String login = user.getLogin();
        String password = user.getPassword();

        if (users.containsKey(login)) {
            User storedUser = users.get(login);
            if(storedUser.getPassword().equals(password)){
                currentUser = storedUser;
                return true;
            }
        }

        System.out.println(StringConstants.USER_ALREADY_EXISTS.formatted(login));
        return false;
    }

    public void logout() {
        currentUser = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean currentUserIsAdmin(){
        return currentUser.isAdmin();
    }
}
