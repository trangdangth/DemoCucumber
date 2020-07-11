Feature: login function, as the potential user, i can login to system successfully

  Scenario: On loginPage, User login to system successfully
    Given the user input company name 'performance_company'
    When the user tap on 'Next' button
    And the user input username 'performance_am_account_9' and password 'Testing@123'
    And the user tap on 'Login' button
    And the user input OTP 1 1 1 1 1 1
    Then the user login to system successfully

  Scenario:On loginPage, login unsuccessfully: wrong company name
    Given the user input company name 'performance_company_test'
    When the user tap on 'Next' button
    Then the user can see error message 'Company does not exist'

  Scenario Outline:On loginPage, login unsuccessfully: wrong username and password
    Given the user input company name 'performance_company'
    When the user tap on 'Next' button
    And the user input username "<username>" and password "<password>"
    And the user tap on 'Login' button
    Then the user can see error message 'Username and/or password do not match. Please try again.'
    Examples:
    | username                 |  password    |
    | performance_am_account   |  Testing@123 |
    | performance_am_account_9 |  Testing@1   |


  Scenario: On loginPage, login unsuccessfully: wrong OTP
    Given the user input company name 'performance_company'
    When the user tap on 'Next' button
    And the user input username 'performance_am_account_9' and password 'Testing@123'
    And the user tap on 'Login' button
    And the user input OTP 1 2 3 4 5 6
    Then the user can see error message 'Incorrect OTP entered. Please try again.'