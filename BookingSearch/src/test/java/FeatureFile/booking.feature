Feature: BookingTest

  @loginActing
  Scenario Outline: Successful Register
    Given User is on Home Page

    When User enter "<username>" as the Username
    And User enter "<password>" as the Password

    #examples for signing in
    Examples:
      | username      | password |
      | TiisetsoMadi | Ora#20042018  |

    Scenario Outline: Booking a hotel
      Given User is logged in
      When user selects/enter "<location>", "<hotel>", "<room_type>", "<NOR>", "<CID>", "<COD>", "<APR>","<CPR>" as the search options
      And User clicks search button
      Then Select hotel page should open
      And User select hotel details
      Then User clicks Continue
      And User selects/enter "<first_name>", "<last_name>", "<address>", "<cc_number>" , "<cc_type>", "<cc_exp_month>", "<cc_exp_year>", "<cc_cvv>" as the booking details
     And user clicks book now
      Then User logs out



      #examples for search page
      Examples:
        |location|hotel|room_type|NOR|CID|COD|APR|CPR|first_name|last_name|address|cc_number|cc_type|cc_exp_month|cc_exp_year|cc_cvv|
        |Sydney  |Hotel Creek|Standard|1 - One | 28/03/2024 |29/03/204  |1 - One |1 - One|Tiisetso  |Madi     |7 6th avenue|4444555566667777|American Express|March|2029|333|

