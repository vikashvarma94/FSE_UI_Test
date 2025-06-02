@Common
Feature: Just for user reference

  Scenario:Below are the common steps implemented for user

#     it fetch title from properties file
    Given Launch application 'Title'

#    input page name as string, webElement name as string, input value as string
    When Input Value 'value' to the field 'field' on 'page'

#    input page name as string, webElement name as string,
    When clicks on Button_Link 'page' on 'field'

#   input page name as string, webElement name as string, Expected text as string
#   -  it get the text from webElement and assert with actual text
    When Verify expected text '' from '' on ''