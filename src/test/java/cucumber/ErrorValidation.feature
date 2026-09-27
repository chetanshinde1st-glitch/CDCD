Feature:Ecomerce Website
Scenario Outline: Login Error validation
Given user at Ecomerce website
When  Logged in with username<Email> and password<Password>
Then System give "Incorrect email or password."

Examples:
|Email                  |Password  |Product    |
|chetanshinde1@gmail.com|Chetan@1234|ZARA COAT 3|