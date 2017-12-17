/**
* <pre>
* 1. 패키지명 : config.security3_2
* 2. 타입명 : BankService.java
* 3. 작성일 : 2017. 12. 16. 오후 5:20:18
* 4. 저자 : 최준호
* 
* </pre>
*
*/
package config.security_sample_3_2;

import org.springframework.security.access.annotation.Secured;

public interface BankService {

/*	@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
	public Account readAccount(Long id);

	@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
	public Account[] findAccounts();

	@Secured("ROLE_TELLER") 
	public Account post(Account account, double amount);

	*/
}
