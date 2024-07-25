# Web Automation on OrangeHRM Website with Selenium TestNG

## What is Automation?

Automation is the process of using software tools and scripts to perform tasks that would typically be done manually by a human. In the context of software testing, automation involves using tools to execute test cases and compare the actual results with the expected results automatically.

## Why do we use Selenium TestNG for Automation?

Selenium is a popular open-source testing tool widely used for automating web browsers. It allows developers and testers to automate web-based applications' testing across multiple browsers and platforms. Selenium provides a set of APIs to interact with web elements and manipulate their properties and behaviors, making it an ideal tool for automating UI tests.

TestNG is a testing framework for Java that is designed to be more flexible and powerful than JUnit. It supports a wide range of testing functionalities, including unit, integration, and end-to-end testing, as well as parallel execution, data-driven testing, and reporting. TestNG is often used with Selenium to create robust and scalable test automation frameworks.

## Technology used:
- Selenium Webdriver
- TestNG Framework
- Java
- Gradle
- Intellij idea
- Allure

## How to run this project

- Clone this project
- Hit the following command into the terminal:
 ```gradle clean test```
 
- For generating Allure Report use these commands:
```allure generate allure-results --clean -o allure-report``` and
```allure serve allure-results```

## Scenario:

- Login to orange hrm demo site: https://opensource-demo.orangehrmlive.com/
- Create 2 new employees and save it to a JSON list
- Now go to the PIM dashboard and search by 1st user name. Assert that the user is found.
- Now click on the user from the search table and update the ID by a random user
- Now again search the user by new user ID from the PIM dashboard menu and assert that the user is found
- Now login from admin and log in with the 2nd user from your JSON list
- Now click on My Info menu
- Select Gender and Blood Type and save it
- Click on contact details and input your address and email
- Logout the user

## Test case checklist based on the Scenario:

- Admin Login with Invalid credential. 
- Admin Login with valid credentials.
- Create an employee without a username.
- Create the first employee.
- create a second employee.
- Search existing employees with invalid names.
- Search employee with a valid name.
- Update employee ID by random ID.
- Search the employee again with an updated employee ID.
- Logout Admin.
- Login second user with a valid credential. 
- Insert the second user's Gender, Blood, Address, and email. 
- Log out the second user. 


## Allure report:

![180](https://github.com/zafir100100/TestNG-orangehrmdemo/blob/master/assets/allure-report.png)


## Site automated:
  - Link (https://opensource-demo.orangehrmlive.com)

![181](https://github.com/zafir100100/TestNG-orangehrmdemo/blob/master/assets/orangehrmdemo.png)

