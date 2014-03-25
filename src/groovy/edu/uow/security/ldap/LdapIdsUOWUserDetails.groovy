package edu.uow.security.ldap

import javax.naming.directory.Attributes
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User;

@groovy.transform.ToString(includeNames = true, includeFields = true)
class LdapIdsUOWUserDetails extends User{

	final String cn
	final String sn
	final String employeeType
	final String mail
	final String uid


	LdapIdsUOWUserDetails(String cn, String sn, String employeeType,String mail,String uid,String username,String password,boolean enabled, boolean accountNonExpired,
	boolean credentialsNonExpired, boolean accountNonLocked,
	Collection<GrantedAuthority> authorities) {

		super(username, password, enabled, accountNonExpired, credentialsNonExpired,
		accountNonLocked, authorities)

		this.cn=cn
		this.sn=sn
		this.employeeType=employeeType
		this.mail=mail
		this.uid=uid
	}

	static LdapIdsUOWUserDetails build(Attributes attrs){

		String cn=attrs.get("cn").get()
		String sn=attrs.get("sn").get()
		String employeeType=attrs.get("employeeType").get()
		String mail=attrs.get("mail").get()
		String uid=attrs.get("uid").get()
		String username=attrs.get("uid").get()

		new LdapIdsUOWUserDetails(cn,sn,employeeType,mail,uid,username, "", true, true, true, true,
				new ArrayList<GrantedAuthority>())
	}
}
