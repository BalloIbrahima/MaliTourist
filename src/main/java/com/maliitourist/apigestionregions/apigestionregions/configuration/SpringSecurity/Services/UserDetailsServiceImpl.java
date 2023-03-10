package com.maliitourist.apigestionregions.apigestionregions.configuration.SpringSecurity.Services;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.maliitourist.apigestionregions.apigestionregions.models.Admin;
import com.maliitourist.apigestionregions.apigestionregions.repository.AdminRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    AdminRepository userRepository;
  
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Admin user = userRepository.findByUsername(username)
          .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
  
      return UserDetailsImpl.build(user);
    }
  
}
