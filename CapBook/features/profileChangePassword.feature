Feature: Capbook Home page
Using this feature User can change password

Scenario: User fails  to go to the profilePage
Given User is on the  CapBook homepage  
When User enters  invalid mailId or  invalid Password
Then User gets error message  on the  capbook home page

Scenario: User succeed  to go to the profile page
Given User is on the CapBook homepage 
When User enters  a  valid mailId and a valid Password
Then User is navigated to capbook profile page

Scenario: User  wants to "change password" on the portal
Given User is on the CapBook profilePage
When User clicks on the  account setting and then on the change password
Then User  remains on the same page and got option for password change

Scenario: User  fails to do "change password" on the portal
Given User is on the CapBook profilePage
When User enters a  wrong current password and a valid new password,confirm password
Then User remains on the same  page and gets an error message

Scenario: User  again fails to do "change password" on the portal
Given User is on the CapBook profilePage 
When User enters  the current password and an invalid new password, confirm password
Then User remains on the same page and get the error message

Scenario: User  is able to do "change password" on the portal
Given User is on the CapBook profilePage   
When User enters the correct current password and the valid new password and valid confirm password
Then User remains on the same page and get a  greeting message