package edu.uow.security.ldap

import java.util.Collection;

import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;

@Deprecated
class MyUserDetailsContextMapper implements UserDetailsContextMapper{

	@Override
	public UserDetails mapUserFromContext(DirContextOperations ctx,
	String id, Collection<GrantedAuthority> authorities) {
		// TODO Auto-generated method stub

		String fullname =  ctx.originalAttrs.attrs['name'].values[0]
		String email = ctx.originalAttrs.attrs['mail'].values[0].toString().toLowerCase()
		String username = ctx.originalAttrs.attrs['samaccountname'].values[0].toString().toLowerCase()
		def title = ctx.originalAttrs.attrs['title']

		new LdapUOWUserDetails(username, null, true, true, true, true,
		authorities, fullname, email, title == null ? '' : title.values[0]) {

		}
	}
		@Override
		public void mapUserToContext(UserDetails arg0, DirContextAdapter arg1) {
			// TODO Auto-generated method stub
			throw new IllegalStateException("Only retrieving data from AD is currently supported")
		}

	}
