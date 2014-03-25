Ldap-Example
============

Spring Ldap example for Grails application


In this example, it shows how to setup a Spring Ldap connection for Grails application. 

1  set up configuration file for connecting LDAP server

In the conf/spring/resources.groovy file, a server can be instanced by org.springframework.ldap.core.support.LdapContextSource and attributes including url, base, userDN and password can be populated. The pattern should looks like this: 
			
			[definded Name](LdapContextSource){
				url = 'ldap://[your ldap url]'
				base = "ou=[your ou],dc=[your dc],dc=[your dc],dc=[your au]"
				userDn = "uid=[your uid],ou=[your ou],dc=[your dc],dc=[your dc],dc=[your dc]"
				password = [your password]
			}
			
Please remove the [] when you use your own values. 

2  Define class for storing LDAP output

You could check the code under src/groovy/edu.uow.security.ldap

3 Create service class for doing the search 

In the services/ldap folder, you can find a class do the search job. 

3.1  you must use afterPropertiesSet() function to loading Properties in the resources file. 

3.2 in the search function, you have to create LdapTemplate with your server details, overrite AttributesMapper to define retured object, then you set up a filter and finally, you do the real search. 
