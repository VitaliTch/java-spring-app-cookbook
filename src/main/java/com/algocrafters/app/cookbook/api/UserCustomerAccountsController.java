package com.algocrafters.app.cookbook.api;

import com.algocrafters.app.cookbook.dto.UserDetailsData;
import com.algocrafters.app.cookbook.service.UserCustomerAccountsService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Provides a collection of API endpoints to perform operation on Customer Accounts.
 *
 * @author Vitali Tchalov (github/VitaliTch)
 * @author {name}
 *
 * @since 0.1
 */
@RestController
@RequestMapping(value = {"/v1"}, produces = {MediaType.APPLICATION_JSON_VALUE})

public class UserCustomerAccountsController {
    private final UserCustomerAccountsService userCustomerAccountsService;

    public UserCustomerAccountsController(UserCustomerAccountsService userCustomerAccountsService) {
        this.userCustomerAccountsService = userCustomerAccountsService;
    }

    @GetMapping(value = "/public/accounts/{accountId}/users/{username}")
    public ResponseEntity<UserDetailsData> getByUsername(
            @PathVariable(value = "accountId", required = true) String accountId,
            @PathVariable(value = "username", required = true) String username) {

        Optional<UserDetailsData> userDetailsData = userCustomerAccountsService.findByUsername(accountId, username);

        return ResponseEntity.of(userDetailsData);
    }
}
