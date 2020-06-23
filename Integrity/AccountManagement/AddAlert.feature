Feature: As an Integrity user I want active account, so that i can add bad phone alert

Scenario: valid integrity user should be able to add bad phone alert
Given a valid Integrity user 
When User goes to NCTA Integrity site and login with valid Credential
Then Home page should display
When user click on Search glass
Then accounts list should dispaly
When user set FirstName filter as Automation and Account status as Active and click on the first account number
Then Account detailes page should display
When user click on contact tab
Then contact tab should display
When user click on edit phone number and click on bad phone check box and save
Then update phone number msg should display and bad phone symbol display
And user set phone number as good again
