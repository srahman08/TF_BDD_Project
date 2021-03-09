@login
 Feature: Validate Techfios Login Functionality 

Background: 
	Given User is on the Techfios Login page  
	
Scenario: 1 User should be able to login with valid credentials 

	Given User enters username as "demo@techfios.com"     
	Given User enters password as "abc123"                
	When User clicks on signin button 			 	     
	Then User should land on Dashboard page     
	
  