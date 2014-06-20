Feature: Search google.com

Scenario: Search Found
Given I am on google
When I search for a arm
Then I should found results

Scenario: Search Not Found
Given I am on google
When I search for a armasdasdasdaslkd;aslkdlsafkjlkdfjopiejqwporkjl;j
Then I should not found results
