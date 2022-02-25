# xmUI
XM UI-Automation task

Prerequirements for run- 
1. Installed chrome (Version 98.0.4758.102< (Official Build) (64-bit)) and firefox (for crossbrowser run(97.0.1<))
2. Java 11
3. Maven

Brief information

Framework built using Selenium and Testng. Supports parallel and crossbrowser run for tests. 

Test execution ways.
1. Single test run (play button): will run test using driver type provided in config.proerties
2. Command line run: can be executed via command mvn clean test -Dsurefire.suiteXmlFile=/src/test/resource/registrationTest.xml (from source root),
   will execute based on drivers provided in registrationTest.xml 
3. Suite run via IDEA: Ability to run tests via xml suite from IDEA


Task Description

Automation testing task #1 (UI)
Resource: xm.com
Tools: Selenium/Java (preferable) OR Cypress/JavaScript OR <your_choise>

Use Case:
1. Open Home page (make any check here if needed).
2. Click the <Partnership> link located at the right top corner (make any check here if needed).
3. Click <Register a Partner Account> button (make any check here if needed).
4. Fill in all mandatory fields.
IMPORTANT: Use "Test+any digit" for <First Name> and <Last Name> fields.
5. Do NOT check <I declare that I have carefully read and fully understood the entire text of the Terms and Conditions which I fully accept and agree with> check-box.
6. Click <Open Partner Account> button.
7. Verify the error message.
8. Check/select <I declare that I have carefully read and fully understood the entire text of the Terms and Conditions which I fully accept and agree with> check-box.
9. Click <Open Partner Account> button.
10. Make a final assertion.

At the end: Imported IntelliJ/other IDE project so we can run it on our local PC.
