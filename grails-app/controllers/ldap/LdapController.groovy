package ldap

import javax.naming.NamingEnumeration
import grails.util.Environment

class LdapController {

	def ldapSearchService

	def index() {
	}
	
	def search(){
		render ldapSearchService.searchLdapUOW(params.username).toString()
	}
	
	def searchIds(){
		render ldapSearchService.searchLdapIdsUOW(params.username).toString()
	}
}
