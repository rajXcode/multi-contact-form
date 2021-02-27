# Multi Contact Form
The web form will have name, email and phone number of the contact. The user should able to add a new contact, validate and remove already added contact. You need to have following codes to meet test requirements.

- Frontend Validation Write an OO JavaScript class to validate all input elements on the web form. When user clicks validation, display the validation errors near the input fields. 
- Backend Validation Write an OO PHP class to validate all input elements on the web form at server side. Assume that JavaScript is disabled and server side PHP validation is on place. Validation class should collect all validation errors and displays to the user all together. If there is no validation error on server side, save all contact data into a text file. 
- Validation Rules: 
   Name: Alphabets and space. 
   Email: Able to validate all valid emails. 
   Phone: Numbers only 
- Action Buttons 
   Add Contact: This button should insert an empty set of contact form (Name, Email, Phone) to the same web page. 
   Validate: This button should trigger JavaScript validation for all input elements. Validation errors should be displayed under each input element. 
   Remove: This button should remove selected set of contact form from web page and the text file which has been saved. 
   Save: This button should submit the forms on the page to server side so PHP can handle form validation and save into the text file. 

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites
 - IntelliJ IDEA 2019+
 - JDK 1.8

1. Install MySQL on your machine. You can configure the user and password in application.properties file as per your MySQL credentials.
2. Create filesystem schema on port 3306.
3. Clone or download the repository on your local environment and import the project in IntelliJ IDEA and build the project.

## Running the project from IntelliJ IDEA
Right click on the MultiContactFormApplication.java file and click on Run 'MultiContactFormApplication' and see if all is well and server goes up. I have taken the port number as 8082 because 8080 is by default. You can set your desired port in application.properties file.

## License
This project is licensed under the GNU GENERAL PUBLIC LICENSE-Version 3 - see the [LICENSE.md](LICENSE.md) file for details

## Authors
* **Rajender Singh Chauhan**
