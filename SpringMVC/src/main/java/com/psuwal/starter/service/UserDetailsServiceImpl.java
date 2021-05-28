package com.psuwal.starter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.psuwal.starter.repository.UserRepository;
import com.psuwal.starter.entity.User;
import com.psuwal.starter.entity.UserPrincipal;

public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user  = userRepository.findByUsername(username).orElse(null); 
		
		if(user == null) {
			throw new UsernameNotFoundException("No username " + username + " found!");
		}
		return new UserPrincipal(user);
	}
}
