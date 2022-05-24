Feature: Tickets reservation service check

  Scenario: Checking reservation data via API
    Given flight from "RIX" to "SVO"
    And passenger info:
      | name             | random     |
      | surname          | Tester     |
      | discount         | CCCCCC     |
      | passengers count | 7          |
      | child count      | 7          |
      | luggage          | 7          |
      | date             | 13-05-2018 |
    And seat number is: 12

    When we are opening home page
    And selecting airports

    Then airports are displayed on passenger info page

    When we are submitting passenger info

    Then name appears in summary
    And price calculated is: 585
#    And reservation number appears

    When we are pressing Book button
    And selecting seat number

    Then seat number appears on page

    When we are booking flight

    Then success message appears

    When we are requesting reservations via API

    Then our reservation with correct data appears