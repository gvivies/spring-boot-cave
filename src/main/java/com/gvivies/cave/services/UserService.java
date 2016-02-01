package com.gvivies.cave.services;

import java.util.Collection;
import java.util.Optional;

import com.gvivies.cave.model.User;
import com.gvivies.cave.model.UserCreateForm;

public interface UserService {

    Optional<User> getUserById(String id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

}
