package ldap

import edu.uow.security.ldap.LdapUOWUserDetails
import edu.uow.security.ldap.LdapIdsUOWUserDetails

import org.springframework.beans.factory.InitializingBean
import org.springframework.ldap.filter.AndFilter
import org.springframework.ldap.filter.EqualsFilter

import javax.naming.directory.SearchControls;

/**
 * A class provides ldap search service on ldap uow and ldap-ids uow 
 * @author qun
 *
 */
class LdapSearchService implements InitializingBean{

	def ldapUOW
	def ldapIdsUOW
	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		ldapUOW.afterPropertiesSet();
		ldapIdsUOW.afterPropertiesSet();
	}

	def searchLdapIdsUOW(username){

		def ldapTemplate = new org.springframework.ldap.core.LdapTemplate(ldapIdsUOW)
		def attrMapper = new org.springframework.ldap.core.AttributesMapper() {
					public Object mapFromAttributes(javax.naming.directory.Attributes attrs) throws javax.naming.NamingException {
						return LdapIdsUOWUserDetails.build(attrs)
					}
				}
		AndFilter filter=new AndFilter()
		filter.and(new EqualsFilter("objectclass","person")).and(new EqualsFilter("uid", username));

		def results = ldapTemplate.search("", filter.toString(),SearchControls.SUBTREE_SCOPE,attrMapper);
	}


	def searchLdapUOW(username) {
		

		def ldapTemplate = new org.springframework.ldap.core.LdapTemplate(ldapUOW)
		def attrMapper = new org.springframework.ldap.core.AttributesMapper() {
					public Object mapFromAttributes(javax.naming.directory.Attributes attrs) throws javax.naming.NamingException {
						return LdapUOWUserDetails.build(attrs)
					}
				}
		AndFilter filter=new AndFilter()
		filter.and(new EqualsFilter("objectclass","person")).and(new EqualsFilter("uid", username));

		def results = ldapTemplate.search("", filter.toString(), attrMapper);
	}


}
