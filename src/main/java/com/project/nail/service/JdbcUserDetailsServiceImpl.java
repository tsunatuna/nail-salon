package com.project.nail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.project.nail.Repository.UserRepository;
import com.project.nail.entity.Users;

/**
 * DBを参照してユーザ情報を提供します。
 *
 */
@Component
public class JdbcUserDetailsServiceImpl implements UserDetailsService  {

	@Autowired
	private UserRepository userRepository;

	/* (非 Javadoc)
	* @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	*/
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		if ( username == null || username.isEmpty() ){
			throw new UsernameNotFoundException("username is empty");
		}

		Users foundUser = userRepository.findByLoginId(username);
		if( foundUser != null ){
			return foundUser.toMyUserDetail();
		}
		throw new UsernameNotFoundException( username + "is not found");
	}
}