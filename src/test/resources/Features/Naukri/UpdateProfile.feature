@UpdateProfile
Feature: Naukri Profile Update
  Scenario:Verify and Update Naukri profile
    Given Launch application 'Naukri'
    When Input Value 'Vikas' to the field 'username'
    When Input Value 'pass' to the field 'password'
    When clicks on Button_Link 'login'
