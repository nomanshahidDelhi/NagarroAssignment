# NagarroAssignment
Softwares Required For Project execution:  
Jdk 11  
Maven  
SonarQube(Community edition)  
Postman(Optional)/Swagger portal can be used  
----------------------------------------------------
Steps to run and test the application:  
  
1.Do maven install and build  
2.Run the application as springBoot App  
3.Login to the application: http://localhost:8080/login  
username: admin and password: admin  
username: user and password: user  
4.Open Swagger portal for APIs: http://localhost:8080/swagger-ui/index.html#  

  
Sonarqube:  
1.Path to start Sonarqube:  
C:\Users\noman\Downloads\sonarqube-developer-8.9.10.61524\sonarqube-8.9.10.61524\bin\windows-x86-64  
2.run StartSonar.batch file  
3.Add NagarroAssignment springboot project to Sonarqube as:  
4.build the project by passing the  
    Goals: sonar:sonar -Dsonar.login=admin -Dsonar.password=admin123  
    Profiles:pom.xml  
  
  
To see the test coverage:  
NagarroAssignment->target->site->jacoco->index.html(open in browser)  
