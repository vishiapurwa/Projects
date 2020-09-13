Feature: Conference Registration
Scenario: User will give invalid credentials to register for conference
Given User is on Conference Page
	When User hit 'Next' button without entering 'FirstName'
	Then Displays 'Please fill the First Name'
	
	When User hit 'Next' button without entering 'LastName'
	Then Displays 'Please fill the Last Name' 
	
	When User hit 'Next' button without entering 'Email'
	Then Displays 'Please fill the Email'

	When User hit 'Next' button without entering 'ContactNo'
	Then Displays 'Please fill the ContactNo'
	
	When User hit 'Next' button after entering invalid 'ContactNo'
	Then Displays 'Enter 10 digit ContactNo'
	
	When User hit 'Next' button without selecting 'NumberOfPeopleAttending'
	Then Displays 'Please select Number Of People Attending'
	
	When User hit 'Next' button without entering 'Address1'
	Then Displays 'Please fill the Building & Room No'
	
	When User hit 'Next' button without entering 'Address2'
	Then Displays 'Please fill the Area name'
	
	When User hit 'Next' button without slecting 'City'
	Then Displays 'Please select city'
	
	When User hit 'Next' button without slecting 'State'
	Then Displays 'Please select state'
	
	When User hit 'Next' button without slecting 'Membership'
	Then Displays 'Please select membership status'
	
Scenario: User will give valid credentials to register for conference
Given User is on Conference Page
	When User fill the all the fields with valid credentials
	Then Displays 'Personal Details are Validated'
	