package com.example.wk01hw02_android_rest_api;

import java.util.ArrayList;
import java.util.List;

public class Users {

    public static List<User> getUsers(){
        List<User> users = new ArrayList<User>();
        User user1 = new User(1, "Bob", "secret1");
        User user2 = new User(2, "Joe", "secret2");
        User user3 = new User(3, "Jen", "secret3");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        return users;
    }
}
