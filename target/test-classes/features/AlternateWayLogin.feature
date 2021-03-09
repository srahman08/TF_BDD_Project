@AlternateLogin
 Feature: Validate Techfios Login Functionality 

Background: 
	Given User is on the Techfios Login page  
	
@Scenario1	
Scenario Outline: 1 User should be able to login with valid credentials 

	Given User enters "<userName>" and "<password>"
	When User clicks on signin button 			 	     
	Then User should land on Dashboard page    

	When The user enters Bank&Cash button 
	When User enters New customer button 
	Then User land on New Account page 
	When User enters "<AccountTitle>" and "<InitialBalance>" and "<ContactPer>" 
	And click on the Save Button 
	Then account should be created 
Examples:
  |userName			|password|AccountTitle|InitialBalance|ContactPer|
  |demo@techfios.com|abc123	|SHAMIM|1000|SELF|
	 
	 
	