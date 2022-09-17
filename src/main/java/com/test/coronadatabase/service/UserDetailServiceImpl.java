/*
Κλάση η οποία χρησιμοποιείτε για User Authentication & User Authorization
 Class used for User Authentication and User Authorization
*/
package com.test.coronadatabase.service;

import com.test.coronadatabase.domain.User;
import com.test.coronadatabase.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository repository;


    @Override /*
             Η μέθοδος αυτή επιστρέφει το UserDetails object το οποίο απαιτείται για το authentication.
              This method returns the UserDetails object required for authentication.
             */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User currentUser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core
                .userdetails.User(username, currentUser.getPassword()
                , true, true, true, true,
                AuthorityUtils.createAuthorityList(currentUser.getRole()));
        return user;
    }
}

