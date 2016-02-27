package com.gvivies.cave.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.gvivies.cave.dto.UserCreateForm;
import com.gvivies.cave.dto.UserRole;
import com.gvivies.cave.model.User;

public interface UserService {
    Optional<User> getUserById(String id);
    Optional<User> getUserByEmail(String email);
    User findOne(String id);
	User findByUsername(String username);
    Collection<User> getAllUsers();
    User create(UserCreateForm form);
    User insertAndInitData(User user);
    User save(User user);
    void delete(User user);
    List<UserRole> getUserRoles();
    User retrieveUserFromAuthentication(String credential);
    User getLoggedInUser(User user);
    String getAuthenticatedUserId();
}
