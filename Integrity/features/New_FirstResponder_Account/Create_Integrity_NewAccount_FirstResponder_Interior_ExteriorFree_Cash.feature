Feature: As an Integrity user, I want account creation page, so that a valid user can create New FirstResponder Exterior Free Cash Account

Scenario: Valid Integrity user should be able to create new FirstResponder Exterior Free Cash  account
Given a valid Integrity user 
When User goes to NCTA Integrity site and login with valid Credential
Then Home page should display
When User click on hamburger and click on Create new account
Then Account type tab should display
When User choose account type FirstResponder and click next
Then Contact tab should display
When User fill Business contact information fields and click next
Then Vehicles tab should display
When User add vehicles and transponders Exterior Free warehouse and click next
Then Billing tab should display
When User fill billing Cash details and click next
Then Confirm tab should display
When User click next on confirmation tab
Then Summary tab should display
When User click on print and send by email the details
Then Details and receipt email msg should display and print page should display
And Store FirstResponder Account Number take screenshot and click finish button

#Examples:
#|row_index|
#|12|