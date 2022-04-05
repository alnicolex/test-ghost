Feature: app-web

  Scenario Outline: Create web platform
    Given Administrator user accesses the portal
    When Administrator page appears
    And User enters the following information <email> and <password>
    And User clicks on the start button
    And The configuration page is displayed
    And User selects the configuration option
    And User makes the following changes to the general settings
      | title     | description | timezone                        | twitterProfile  |
      | test page | test page   | (GMT -5:00) Bogota, Lima, Quito | https://twitter.com/startupyworld |
    And User presses the save button
    Then The changes are saved
    And User exits the application

    Examples:
      | email          | password             |
      | web-a@mail.com | Qwertyuiopasdfghjkl  |

  Scenario Outline: User create a new page
    Given Administrator user accesses the portal
    When Administrator page appears
    And User enters the following information <email> and <password>
    And User clicks on the start button
    And The configuration page is displayed
    And User selects the configuration of pages
    And User clicks on new page
    And User creates a page with the following information
      | title     | description |
      | test-page | this is my firts page   |
    Then User publishes the page
    And User links the url in the navigation path
    And User exits the application

    Examples:
      | email          | password             |
      | web-a@mail.com | Qwertyuiopasdfghjkl  |


  Scenario Outline: User delete page
    Given Administrator user accesses the portal
    When Administrator page appears
    And User enters the following information <email> and <password>
    And User clicks on the start button
    And The configuration page is displayed
    And User selects the configuration of pages
    And The user delete the page <pageDelete>
    And The user deletes from the navigation path the page
    Then The user saves the changes
    And User exits the application

    Examples:
      | email          | password             | pageDelete  |
      | web-a@mail.com | Qwertyuiopasdfghjkl  | test-page   |