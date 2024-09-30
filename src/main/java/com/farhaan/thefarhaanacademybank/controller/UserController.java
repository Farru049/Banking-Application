package com.farhaan.thefarhaanacademybank.controller;

import com.farhaan.thefarhaanacademybank.dto.BankResponse;
import com.farhaan.thefarhaanacademybank.dto.UserRequest;
import com.farhaan.thefarhaanacademybank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint to create a new account
    @PostMapping("/create")
    public ResponseEntity<BankResponse> createAccount(@RequestBody UserRequest userRequest) {
        BankResponse bankResponse = userService.createAccount(userRequest);
        return ResponseEntity.ok(bankResponse);
    }

    // Other endpoints related to User operations can go here
}
