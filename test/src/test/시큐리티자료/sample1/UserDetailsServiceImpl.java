/**
* <pre>
* 1. 패키지명 : config.security3_1
* 2. 타입명 : UserDetailsServiceImpl.java
* 3. 작성일 : 2017. 12. 16. 오후 6:08:54
* 4. 저자 : 최준호
* 
* </pre>
*
*/
package config.security_sample_3_1;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//@Service("userDetailService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserServiceDAO userService;
 
	@Transactional(readOnly =true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	    MUser  user =userService.findUserByUsername(username);
	    if (user != null) {
	        String password = user.getPassword();
	        boolean enabled = user.getActive();
	        boolean accountNonExpired = user.getActive();
	        boolean credentialsNonExpired = user.getActive();
	        boolean accountNonLocked = user.getActive();

	        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//	        for (Role r : user.getRoles()) {
//	            authorities.add(new SimpleGrantedAuthority(r.getAuthority()));
//	        }
//	        org.springframework.security.core.userdetails.User securedUser = new org.springframework.security.core.userdetails.User(
//	                username, password, enabled, accountNonExpired,
//	                credentialsNonExpired, accountNonLocked, authorities);
	        return null;
	        
	    } else {
	        throw new UsernameNotFoundException("Unable to find user with username provided!!");
	    }
	}
 
}
