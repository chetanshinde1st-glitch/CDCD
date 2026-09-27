Feature: Purchase order from ecommerce Website
Background:
Given user at Ecomerce website
@Reggresion
Scenario Outline:Submit order end to end flow
Given Logged in with username<Email> and password<Password>
When I add product to cart <Product>
And checkout <Product> and submit the order
Then comfirmation msg dispayed "Thankyou for the order."

Examples:
|Email                  |Password  |Product    |
|chetanshinde1@gmail.com|Chetan@123|ZARA COAT 3|

