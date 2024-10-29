package com.asree.stock_spring_boot.services;

import com.asree.stock_spring_boot.models.UserModel;
import com.asree.stock_spring_boot.repositorys.UserRepo;
import com.asree.stock_spring_boot.utils.JwtUtil;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService extends UserRepo {
    @Autowired
    private UserRepo repo;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(EntityManager entityManager) {
        super(entityManager);
    }

    public UserModel singUp(UserModel data) {
        try{
            String newPassword = passwordEncoder.encode(data.getPassword());
            data.setPassword(newPassword);
            System.out.println("new pass " + data);
            return repo.repoCreate(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public String signIn(UserModel data) {
        try{
            if (data.getEmail() == null || data.getEmail().isEmpty()) {
                throw new IllegalArgumentException("Email cannot be null or empty");
            }

            UserModel result = repo.repoFindByEmail(data.getEmail());
            if (result == null) {
                throw new RuntimeException("User not found in database");
            }

            // ตรวจสอบรหัสผ่าน
            if (!passwordEncoder.matches(data.getPassword(), result.getPassword())) {
                throw new RuntimeException("Email or Password does not match");
            }
            return jwtUtil.generateToken(result.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
