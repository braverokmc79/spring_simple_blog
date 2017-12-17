/**
* <pre>
* 1. 패키지명 : config.security3_1
* 2. 타입명 : MUser.java
* 3. 작성일 : 2017. 12. 16. 오후 7:39:42
* 4. 저자 : 최준호
* 
* </pre>
*
*/
package config.security_sample_3_1;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class MUser extends User{

	private boolean active;
	
	
	/**
	 * @param username
	 * @param password
	 * @param enabled
	 * @param accountNonExpired
	 * @param credentialsNonExpired
	 * @param accountNonLocked
	 * @param authorities
	 */
	public MUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		
	}


	public boolean getActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	/**
	 * @return
	 */
	public Object getRoles() {
		
		return null;
	}
	
	
	

}
