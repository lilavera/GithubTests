# GitHub Tests

This projects tests CRUD functionality for the Github API and checks if user is authenticated.

Endpoints for CRUD:

- /user/repos (Create a repository for authenticated user)
- /repos/{owner}/{repo} (Update a repository)
- /repos/{owner}/{repo} (Delete a repository)


Endpoint is tested for the authentication user
- /user (Get the authenticated user)


To check if test will pass paste change following parmeters in src/main/resources/config.properties file your access token from Github account and your name profile for github where you create your repo


![image](https://github.com/user-attachments/assets/0c37d054-a9b2-42cd-bb29-c248916b0b98)



To run tests you may run directly in tests class (src/test/java/GetTheAuthenticatedUserTest.java and src/test/java/RepositoryFlowTest.java):


![image](https://github.com/user-attachments/assets/38ca66bf-43af-4f6d-8cff-affca1855549)

or using maven command:

mvn test -DsuiteXmlFile=src/test/resources/testng.xml

(if tests are runnning in IJ by default configuration "mvn" can be omitted):

![image](https://github.com/user-attachments/assets/fbd3f0da-c00e-4d32-80c4-ede7f8a44e77)









