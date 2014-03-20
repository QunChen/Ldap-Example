<!DOCTYPE html>
<html>
	<head></head>
	<body>
	<p>UOW Ldap</p>
	  <g:form controller="ldap">
  <div>
  <label for="username">Username: </label>
  <g:textField name="username"/> <br>
  </div>
  <div>
  <g:actionSubmit value="search" action="search"/>

  </div>
 </g:form>
 
 <p>UOW Ldap-ids</p>
	  <g:form controller="ldap">
  <div>
  <label for="username">Username: </label>
  <g:textField name="username"/> <br>
  </div>
  <div>
  <g:actionSubmit value="search" action="searchIds"/>

  </div>
 </g:form>
	
	</body>
	</html>