package com.farhaan.thefarhaanacademybank.service;

import com.farhaan.thefarhaanacademybank.dto.AccountInfo;
import com.farhaan.thefarhaanacademybank.dto.BankResponse;
import com.farhaan.thefarhaanacademybank.dto.UserRequest;
import com.farhaan.thefarhaanacademybank.entity.User;
import com.farhaan.thefarhaanacademybank.repository.UserRepository;
import com.farhaan.thefarhaanacademybank.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public BankResponse createAccount(UserRequest userRequest) {
        /**
         * Creating an account - saving a new user into the database
         */

        // Check if user with the given email already exists
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_EXIST_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_EXIST_MESSAGE)
                    .accountInfo(null)  // No account info in this case
                    .build();
        }

        // Create a new User entity
        User newUser = User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .otherName(userRequest.getOtherName())
                .gender(userRequest.getGender())
                .address(userRequest.getAddress())
                .stateOfOrigin(userRequest.getStateOfOrigin())
                .accountBalance(BigDecimal.ZERO)
                .accountNumber(AccountUtils.generateAccountNumber())  // Generate the account number
                .email(userRequest.getEmail())
                .phoneNumber(userRequest.getPhoneNumber())
                .status("ACTIVE")
                .build();

        // Save the new user in the database
        User savedUser = userRepository.save(newUser);

        // Create an AccountInfo DTO to return in the response
        AccountInfo accountInfo = AccountInfo.builder()
                .accountNumber(savedUser.getAccountNumber())
                .firstName(savedUser.getFirstName())  // Corrected line
                .lastName(savedUser.getLastName())
                .accountBalance(savedUser.getAccountBalance())
                .email(savedUser.getEmail())
                .status(savedUser.getStatus())
                .build();

        // Return the response with success message and account info
        return BankResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_CREATION_SUCCESS)
                .responseMessage(AccountUtils.ACCOUNT_CREATION_MESSAGE)
                .accountInfo(accountInfo)  // Set account info here
                .build();
    }
}
