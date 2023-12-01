package ru.edu;

import java.util.*;

public class UserStorage {

    private final Map<String, UserInfo> USERS = new HashMap<>();

    public Collection<UserInfo> getAll() {
        return USERS.values();
    }

    public UserInfo getById(String id) {
        return USERS.get(id);
    }

    public UserInfo create(UserInfo user) {
        USERS.put(user.getId(), user);
        return user;
    }

    public UserInfo update(UserInfo user) {
        USERS.put(user.getId(), user);
        return user;
    }
}
