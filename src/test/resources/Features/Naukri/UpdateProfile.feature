@Login
Feature: Naukri Profile Update

  Scenario:Verify and Update Naukri profile
    Given Launch application 'Naukri'
    When Input Value 'Vikas' to the field 'userName' on 'NaukriLogin'
    When Input Value 'pass' to the field 'password' on 'NaukriLogin'
    When clicks on Button_Link 'login' on 'HomePage'
