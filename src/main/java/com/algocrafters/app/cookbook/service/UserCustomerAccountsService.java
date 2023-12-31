package com.algocrafters.app.cookbook.service;

import com.algocrafters.app.cookbook.dto.UserDetailsData;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

/**
 * The service provides functional operations on Customer Accounts and Account Users.
 *
 * @author Vitali Tchalov (github/VitaliTch)
 * @author {name}
 *
 * @since 0.1
 */
@Service
public class UserCustomerAccountsService {

    public Optional<UserDetailsData> findByUsername(@NonNull String accountId, @NonNull String username) {
        // TODO: temporary placeholder implementation
        return Optional.ofNullable(
                new UserDetailsData(accountId, username, "pwd-temp",
                    Collections.emptySet(), true, true, true, true)
        );
    }
}
