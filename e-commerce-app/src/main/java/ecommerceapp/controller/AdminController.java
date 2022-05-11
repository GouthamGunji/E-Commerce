package ecommerceapp.controller;

import ecommerceapp.dto.LoginDto;
import ecommerceapp.dto.PasswordDto;
import ecommerceapp.exception.InvalidAdminDetailsException;
import ecommerceapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService service;

    @PostMapping("/{adminName}/updatepassword")
    public String updatePassword(@PathVariable String adminName,
                                 @RequestBody PasswordDto passwordDto)
            throws InvalidAdminDetailsException {
        return service.updatePassword(adminName, passwordDto);
    }

    @PostMapping("/signin")
    public String signIn(@RequestBody LoginDto adminLoginDto)
            throws InvalidAdminDetailsException {
        return service.loginAdmin(adminLoginDto);

    }

}
