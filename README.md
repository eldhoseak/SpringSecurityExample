# SpringSecurityExample

This is a sample Spring project to demonstrate the spring security concepts. 
1. if we add the spring boot dependency in the classpath a default authentication will be inforce. The username for which is 'user' 
  and the password will be logged in the Spring boot start up logs.
2. The in memory authentication, allows us to configure username and passsword in the code. 
3. The JDBC authentication using Spring's UserDetailsService class. Allows us to authenticate against a database table containing users.
   This method also has the user roles for each user.
   
The URL to test endpoint http://localhost:8080/person
