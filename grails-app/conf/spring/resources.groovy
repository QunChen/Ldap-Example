// Place your Spring DSL code here
import grails.util.GrailsUtil;
import grails.util.Environment
import org.springframework.ldap.core.support.LdapContextSource

beans = {

	switch(Environment.getCurrent() ){
		case Environment.PRODUCTION:
			break

		case Environment.DEVELOPMENT:
		//ldap server
			ldapUOW(LdapContextSource){
				url="ldap://ldap.uow.edu.au:389"
				base="o=University of Wollongong,c=AU"
			}

		//ldap-ids server
			ldapIdsUOW(LdapContextSource){
				url = 'ldap://ldap-ids.uow.edu.au:389'
				base = "ou=People,dc=uow,dc=edu,dc=au"
				userDn = "uid=biomechuserldap,ou=Special Users,dc=uow,dc=edu,dc=au"
				password = "XXXXXXXX"
			}
			break

		case Environment.TEST:
			break

	}
}
