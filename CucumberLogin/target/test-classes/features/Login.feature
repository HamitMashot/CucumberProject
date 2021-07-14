Feature: Login

  Scenario: Successful Login with Valid Credentials
    Given User Launch Chrome browser
    When User opens URL "https://www.amazon.com"
    And User mouse move to Element "Account & Lists"
    And User enters Email as "masihuti.hamiti@menusifu.com" and Password as "Menusifu@67886788"
    And Click on Login
    When User click on Log out Link
    Then Page Title should be "Amazon.com. Spend less. Smile more."
    And close browser
