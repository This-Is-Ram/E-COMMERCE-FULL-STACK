package com.ram.user_service.service;

import com.ram.user_service.model.Users;
import com.ram.user_service.model.UsersLogin;
import com.ram.user_service.ropository.UserRepo;
import com.ram.user_service.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepo userRepo;

    @Autowired
    public JwtService jwtService;

    @Autowired
    public AuthenticationManager authenticationManager;

    @Autowired
    public PasswordEncoder passwordEncoder;

    public Users registerUser(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public String loginUser(UsersLogin user) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getEmail(),
                            user.getPassword()
                    )
            );
            Users dbusers = userRepo.findByEmail(user.getEmail()).orElseThrow();
            return jwtService.generateToken(
                    dbusers.getEmail(),
                    dbusers.getRole()
            );
        } catch (Exception e) {

            return "Invalid Email or Password";
        }

    }

    public List<Users> getUsers() {
        return userRepo.findAll();
    }
}
