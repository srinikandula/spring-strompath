getwell-java
============
1) git clone git@github.com:GetWellCities/getwell-java.git

2)import the project in to eclipse

3)Configure eclipse for lombak agent compiler. Refer to the below links for information

http://stackoverflow.com/questions/3418865/cannot-make-project-lombok-work-on-eclipse-helios
http://stackoverflow.com/questions/22310414/how-to-configure-lombok-in-eclipse-luna

You can run the command 'java -Dlombok.installer.fullpath -jar <lombok.jar path>' to launch the lombak UI to select an eclipse installation location. 
After this eclipse need to be restarted and now all lombak code will be compiled fine.

4)Download and install mongodb http://docs.mongodb.org/manual/installation/

5)Run the Integration test UserDAOIntegrationTest and check the test passed.

6)Create a maven run configuration with goals 'clean install tomcat7:run'. Run the maven configuration you just created. The app should be running on http://localhost:8081/

Developer instructions
----------------------
1)after checking out the code create a dev branch using the command

>git checkout -b <branchName> or use eclipse menu option Team-> Switch To

2)Make your changes and commit the code using git command line or eclipse menu Team -> Commit

3) Push the changes to a remote branch using the below command

>git push origin branchname:remotebranchname

for example: git push origin mynameDev:dev/myname/FixForSecurityIntegration

4)Go to https://github.com/GetWellCities/getwell-java and create a pull request for push you just did

5)Assign the pull request to a peer for code review and merge to master

6)Once the pull request is merged to master branch update local master using the below commands

>git checkout master

>git pull

7)Switch to development branch and rebase it to master

>git checkout branchname

>git rebase master




Reference documents to read 
---------------------------

1)Spring data mongo : http://docs.spring.io/spring-data/mongodb/docs/current/reference/html/


sample git commands 
-------------------
>git commit -m "changing the build name"

>git push origin sriniDev:dev/srini/PomFix

>git checkout master

>git pull

>git branch

>git checkout sriniDev

>git rebase master
