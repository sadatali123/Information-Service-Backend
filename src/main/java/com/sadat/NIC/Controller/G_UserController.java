package com.sadat.NIC.Controller;
import com.sadat.NIC.Entity.G_User;
import com.sadat.NIC.Service.G_UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class G_UserController {
    private final G_UserService userService;

    public G_UserController(G_UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<G_User> signup(@RequestBody G_User user) {
        G_User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        
        return ResponseEntity.ok("Login successful");
    }

    @GetMapping("/getall")
    public ResponseEntity<List<G_User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/{id}/toggle-active")
    public ResponseEntity<?> toggleActive(@PathVariable Long id) {
        userService.toggleActive(id);
        return ResponseEntity.ok("User active status toggled");
    }
}