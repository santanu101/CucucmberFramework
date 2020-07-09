Feature: Searching Goibibo 

Scenario Outline: Search for a  flight Scenario
 Given launch browser 'chrome'
 When user navigates to the URL 'https://www.goibibo.com/'
 Then user enter 'HYD' and 'BBI'
 Then user click on search
 Then user click on Evening Flight
 Then user will get all the prices from the table
 Then user will get fastest flight
 Then user will click on Book
Examples: 
| From | Destination | 
| HYD  | BBI         |




