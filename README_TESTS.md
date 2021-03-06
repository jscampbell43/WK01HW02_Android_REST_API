# WK01HW02_Android_REST_API
Wk01Hw02 Android REST API, Login, Landing Page

TESTS

Test 1: Correct Username and Password

Username: Bob
Password: secret1
UserId: 1

User enters: Username: Bob Password: secret1
App displays: Welcome page with "Welcome Bob! Your User Id is: 1"  followed by a list of all the posts from the user with ID 1.


Test 2: Creation of Intents

User enters: username: Bob Password: secret1
App displays: Upon clicking the Login button with the correct username and password a new Intent is created and a new Activity is started displaying. Welcome page with "Welcome Bob! Your User Id is: 1"  followed by a list of all the posts from the user with ID 1.


Test 3: Username not found

Username: Bob
Password: secret1
UserId: 1

User enters: username: Bob1 Password: secret1
App displays: Username not found and the username field is highlighted red


Test 4: Incorrect Password 

Username: Bob
Password: secret2
UserId: 1

User enters: username: Bob Password: secret2
App displays: Incorrect password and the password field is highlighted red




Test 5: Posts pulled from API

User enters: username: Bob Password: secret1
App displays: Welcome page with "Welcome Bob! Your User Id is: 1"  followed by a list of all the posts from the user with ID 1.
User enters: username: JoePassword: secret2
App displays: Welcome page with "Welcome Joe! Your User Id is: 2"  followed by a list of all the posts from the user with ID 2.
Code Check: Check code for API interface, Post class for holding JSON objects, and implementation of https://jsonplaceholder.typicode.com/posts API in Landing Page Activity.
