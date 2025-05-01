@Smoke
Feature:Smoke Suite
  Verify Major functionality

  Background:
    Given Launch application "Naukri"

#  @Homepage
#  Scenario:1.Verify Employee MGM home page buttons and links
#    When User lands on home page "React App"
#    Then Verify home page header "Full Stack Application"
#    And Verify employees table column names
#      | S.No     |
#      | Name     |
#      | Username |
#      | Email    |
#      | Action   |
#    And Verify all broken links
#
#  @Add
#  Scenario Outline:2.Verify Add user feature
#    When User lands on home page "React App"
#    And User navigates to add user page by clicking on add button
#    And User enters new user details and clicks on submit <Name>, <Username>, <Email>
#    Then Verify new user <Name> is added in home page
#    Examples:
#      | Name  | Username  | Email               |
#      | test1 | testuser1 | testmail1@gmail.com |
#
#  @View
#  Scenario Outline:3.Verify View user page
#    When User lands on home page "React App"
#    And User navigates to view <Name> user page by clicking on view button
#    Then Verify user can see the expected details <Name>, <Username>, <Email>
#    And Verify user lands on home page after clicking back to home button
#    Examples:
#      | Name  | Username  | Email               |
#      | test1 | testuser1 | testmail1@gmail.com |
#
#  @Edit
#  Scenario Outline:4.Verify Edit user feature
#    When User lands on home page "React App"
#    And User navigates to edit <Name> user page by clicking on edit button
#    And User enters new user details and clicks on submit <newName>, <newUsername>, <newEmail>
#    Then Verify new user <newName> is added in home page
#    Examples:
#      | Name  | Username  | Email               | newName  | newUsername  | newEmail            |
#      | test1 | testuser1 | testmail1@gmail.com | newtest1 | newUsername1 | newEmail1@gmail.com |
#
#  @Delete
#  Scenario:5.Verify Delete user feature
#    When User lands on home page "React App"
#    And Deleted user "newtest1" by clicking on delete button
#    Then Verify user "newtest1" is deleted from homepage