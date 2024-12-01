@NormalTest
  Feature: Basic Test


    Background:
      Given Launch application

    Scenario:Verify home page
      When User lands on home page "Google"
      #Then Verify all broken links
      Then Verify home page "Full Stack Application"