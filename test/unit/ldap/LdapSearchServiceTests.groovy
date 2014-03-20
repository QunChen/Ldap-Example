package ldap



import edu.uow.security.ldap.LdapUOWUserDetails
import edu.uow.security.ldap.LdapIdsUOWUserDetails
import grails.test.mixin.*
import org.junit.*
import org.springframework.ldap.core.support.LdapContextSource
import javax.naming.directory.SearchControls

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(LdapSearchService)
class LdapSearchServiceTests {

	
	void testSearchLdapIdsUOW() {
		defineBeans {
			ldapIdsUOW(LdapContextSource){
				url = 'ldap://ldap-ids.uow.edu.au:389'
				base = "ou=People,dc=uow,dc=edu,dc=au"
				userDn = "uid=biomechuserldap,ou=Special Users,dc=uow,dc=edu,dc=au"
				password = "Abx\\xn\$4"
			}
		}
		
		SearchControls.SUBTREE_SCOPE

		def result= service.searchLdapIdsUOW("ad648");
		assert result[0].cn == "Anna Dalecki"
		assert result[0].sn == "Dalecki"
		assert result[0].employeeType == "student"
	}
	
	void testSearchLdapUOW() {
		defineBeans {
			ldapUOW(LdapContextSource){
				url="ldap://ldap.uow.edu.au:389"
				base="o=University of Wollongong,c=AU"
			}
		}

		def result= service.searchLdapUOW("jabbott");
		assert result[0].cn == "Joe Abbott"
		assert result[0].sn == "Abbott"
		assert result[0].description == "Senior Technical Officer"
	}

}
