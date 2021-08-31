package myCodeBook.services;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		//this is fake method we can use dao here
		if(username.equals("Prateek")) {
			return new User("Prateek","1234",new ArrayList<>());
		}
		else {
			throw new UsernameNotFoundException("Username not fount !");
		}
	}

}
