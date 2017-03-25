# csoftz-rappi-test
Spring Boot Application for Rappi test case coding challenge.
The code challenge is at https://www.hackerrank.com/challenges/cube-summation

V1.0.0-Mar.25/2017

To run the application you must have Java 8+ and Maven, both configured.

In the terminal type the following commands.
$ mvn clean package

If status is SUCCESSFUL then go to containing folder and look for 'target' folder
and type

$ java -jar csoftz-rappi-test-1.0.1-RELEASE.jar

The open a browser window to the Chrome Browser (or any browser you like)
point to http://localhost:8090/home

There you will find the HOME page with a bootstrap like interface with an 'Options' menu. Click there
and then th choic for 'Summation' which will lead you to the Cube Page, where
you will enter the code challenge input like format and press in the 'Do it!' button to
process the information and give in another page the results for this calculation.

It is compiled using Spring Boot v1.5.2 as of Mar.25/2017

NOTE: code-challenge-ans.txt is a file with the whole terms for questions.
