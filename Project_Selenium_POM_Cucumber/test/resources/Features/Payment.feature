Feature: Payment Details 
Scenario: User will give invalid payment details 
	Given User is on payment page 
	When User hit 'Register' button without entering 'FirstName' 
	Then Displays 'Please fill the FirstName' 
	
	When User hit 'Register' button without entering 'LastName' 
	Then Displays 'Please fill the LastName' 
	
	When User hit 'Register' button without entering 'DebitCardNumber' 
	Then Displays 'Please fill the Debit card Number' 
	
	When User hit 'Register' button without entering 'CVV' 
	Then Displays 'Please fill the CVV' 
	
	When User hit 'Register' button without entering 'ExpirationMonth' 
	Then Displays 'Please fill expiration month' 
	
	When User hit 'Register' button without entering 'ExpirationYear' 
	Then Displays 'Please fill expiration year' 
	
Scenario: User will give valid payment details 
	Given User is on payment page 
	When User provides all valid payment details 
	Then Displays 'Registarion successful!!!' 
  	 