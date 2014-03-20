package edu.uow.security.ldap

import javax.naming.directory.Attributes
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User;

@groovy.transform.ToString(includeNames = true, includeFields = true)
class LdapUOWUserDetails extends User{

	final String cn
	final String sn
	final String description
	final String mail
	final String ou
	final String telephoneNumber
	final String title
	final String uid


	LdapUOWUserDetails(String cn, String sn, String description,String mail,String ou, String telephoneNumber,String title,String uid,String username,String password,boolean enabled, boolean accountNonExpired,
	boolean credentialsNonExpired, boolean accountNonLocked,
	Collection<GrantedAuthority> authorities) {

		super(username, password, enabled, accountNonExpired, credentialsNonExpired,
		accountNonLocked, authorities)

		this.cn=cn
		this.sn=sn
		this.description=description
		this.mail=mail
		this.ou=ou
		this.telephoneNumber=telephoneNumber
		this.title=title
		this.uid=uid
	}

	static LdapUOWUserDetails build(Attributes attrs){

		String cn=attrs.get("cn").get()
		String sn=attrs.get("sn").get()
		String description=attrs.get("description").get()
		String mail=attrs.get("mail").get()
		String ou=attrs.get("ou").get()
		String telephoneNumber=attrs.get("telephoneNumber").get()
		String title=attrs.get("title").get()
		String uid=attrs.get("uid").get()
		String username=attrs.get("uid").get()

		new LdapUOWUserDetails(cn,sn,description,mail,ou,telephoneNumber,title,uid,username, "", true, true, true, true,
				new ArrayList<GrantedAuthority>())
	}
}
