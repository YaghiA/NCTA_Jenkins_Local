Feature: As an user, I want create new account page, so that user can create new Web Personal exterior free CCVisa account

Scenario: user should be able to create new Web Personal exterior free CCVisa  account
Given a user 
When User goes to NCTA signUp page and click on signUp button
Then Terms tab should display
When User choose personal account type and click on agree terms checkBox and click continue button
Then User personal inforamtion tab should display
When User fill personal inforamtion fields and click continue button
Then Security tab should display
When User fill security details field and click continue button
Then Vehicles & transponders tab should display
When User add vehicles and transponders and click continue button
Then Billing Tab should display
When User fill billing CCVisa details and click continue button
Then Confirmation tab should display
When User click continue button on confirm tab
Then Payment Tab Should display
When User fill payment CCVisa detailes and click continue button
Then Payment reciept tab should display
When User click on print receipt and print account summary icons and click on view your new account button
Then New account profile page should display