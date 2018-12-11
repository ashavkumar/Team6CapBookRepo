Feature: Capbook Home page
Usig this feature User can go to Capbook Profile page

Scenario: User wants to "get password" on the portal
Given User is on the CapBook homepage
When User clicks on forgot password button
Then User is navigated to Forgot Password Page

Scenario: User wants to "get  new password" on the Forgot Password page
Given User is on the Forgot Password Page
When User enters valid emailId
Then User gets greeting message on Forgot Password page

Scenario: User wants to "get  new password" on the Forgot Password page
Given User is on the Forgot Password Page
When User enters invalid emailId
Then User gets error message on Forgot Password page