package com.sadat.NIC.DTO;
import com.sadat.NIC.Entity.G_User.Role;

import lombok.Data;

@Data
public class G_UserDTO {
    private Long id;
    private String username;
    private String email;
    private String password; // for signup;
    private Role role;
    private Boolean isActive;
}
