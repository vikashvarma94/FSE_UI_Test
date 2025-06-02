@Login
Feature: Naukri Profile Update

  Scenario:Verify and Update Naukri profile
    Given Launch application 'Naukri'
    When Input Value 'Vikasvarma94@gmail.com' to the field 'userName' on 'NaukriLogin'
    When Input Value '******' to the field 'password' on 'NaukriLogin'
    When clicks on Button_Link 'login' on 'NaukriLogin'

    When Verify expected text 'Kalidini Naga Vikasa Varma' from 'header' on 'NaukriHome'
