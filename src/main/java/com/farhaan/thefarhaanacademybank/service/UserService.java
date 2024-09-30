package com.farhaan.thefarhaanacademybank.service;

import com.farhaan.thefarhaanacademybank.dto.BankResponse;
import com.farhaan.thefarhaanacademybank.dto.UserRequest;

public interface UserService {
    BankResponse createAccount(UserRequest userRequest);

}
