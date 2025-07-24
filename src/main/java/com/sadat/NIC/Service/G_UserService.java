package com.sadat.NIC.Service;

import com.sadat.NIC.Entity.G_User;
import com.sadat.NIC.Repository.G_UserRepository;
 



import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class G_UserService {
    private final G_UserRepository userRepository;

    public G_UserService(G_UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public G_User saveUser(G_User user) {
        return userRepository.save(user);
    }

    public Optional<G_User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<G_User> getAllUsers() {
        return userRepository.findAll();
    }

    public void toggleActive(Long id) {
        Optional<G_User> userOpt = userRepository.findById(id);
        userOpt.ifPresent(user -> {
            user.setIsActive(!user.getIsActive());
            userRepository.save(user);
        });
    }
}