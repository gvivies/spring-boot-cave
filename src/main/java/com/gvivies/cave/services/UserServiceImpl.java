package com.gvivies.cave.services;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gvivies.cave.dto.UserCreateForm;
import com.gvivies.cave.dto.UserRole;
import com.gvivies.cave.model.AppAuthentication;
import com.gvivies.cave.model.Role;
import com.gvivies.cave.model.User;
import com.gvivies.cave.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private BottleService bottleService;
	
	@Autowired
	private WineService wineService;

	@Autowired
	private RegionService regionService;

	@Autowired
	private DealerService dealerService;
	
	@Autowired
	private ClassificationService classificationService;
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private DataService dataService;
	
	private Base64.Decoder decoder = Base64.getDecoder();

    @Override
    public Optional<User> getUserById(String id) {
        return Optional.ofNullable(userRepository.findOne(id));
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

	@Override
	public User findOne(String id) {
		return userRepository.findOne(id);
	}
	
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
    @Override
    public Collection<User> getAllUsers() {
    	Collection<User> users = userRepository.findAll(new Sort("email"));
    	return users;
    } 

    @Override
    public User create(UserCreateForm form) {
        User user = new User();
        user.setEmail(form.getEmail());
        user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setRole(form.getRole());
        return userRepository.save(user);
    }
    
	@Override
	public User insertAndInitData(User user) {
		User created  = userRepository.insert(user);
		dataService.initForUser(created.getId());
		return created; 
	}
	

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public void delete(User user) {
		deleteUserData(user.getId());
		userRepository.delete(user);
	}	

	@Override
	public List<UserRole> getUserRoles() {
		List<UserRole> userRoles = new ArrayList<UserRole>();
		for (int count = 0 ; count < Role.values().length; count++) {
			userRoles.add(new UserRole(Role.values()[count].getId(), Role.values()[count].getRoledesc()));
		}
		return userRoles;
	}

	@Override
	public User retrieveUserFromAuthentication(String authentication) {
		String[] credentials = new String(decoder.decode(authentication.substring("Basic ".length()))) //
				.split(":");	
		User user = new User();
		user.setUsername(credentials[0]);
		user.setPassword(credentials[1]);	
		return user;

	}

	@Override
	public User getLoggedInUser(User user) {
		User authenticated = userRepository.findByUsername(user.getUsername());
		if (authenticated != null) {
			if (authenticated.getPassword().equals(user.getPassword())) {
				return authenticated;
			} else {
				return user;
			}
		}		
		return user;
	}

	@Override
	public String getAuthenticatedUserId() {
	      AppAuthentication auth = (AppAuthentication) SecurityContextHolder.getContext().getAuthentication();
	      return auth.getId();
	}
	
	private void deleteUserData(String owner) {
		regionService.deleteAllForUser(owner);
		wineService.deleteAllForUser(owner);
		dealerService.deleteAllForUser(owner);
		classificationService.deleteAllForUser(owner);
		bottleService.deleteAllForUser(owner);
	}

}