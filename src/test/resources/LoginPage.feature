

@tag
Feature: Employee Login

Background:
	Given the user is on the login page
	
	@tag1
	Scenario Outline: the Employee can Login using their uname and pass
	
	When the Employee types in their "<uname>" and "<pass>" and clicks the employee login
	Then the Employee should be on the home page

    Examples: 
      | uname            | pass                |
      | Expo             | kingofthekitchen    | 
      | MrManager        | Maeby               | 
      
	@tag2
	Scenario Outline: the Employee cannot Login using their uname and pass
	
	When the Employee types in the incorrect "<uname>" or "<pass>" and clicks the employee login
	Then the Employee should recieve an invalid credentials alert

    Examples: 
      | uname            | pass                |
      | Expo             | kingothekitchen     | 
      | ImMrManager      | Maeby               | 
      
