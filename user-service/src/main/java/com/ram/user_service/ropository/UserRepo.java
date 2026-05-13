package com.ram.user_service.ropository;

import com.ram.user_service.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users,Long> {


    Optional<Users> findByEmail(String email);
}
