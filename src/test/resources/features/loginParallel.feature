Feature: Successful login

#  Scenario: Successful verify progress website with firefox
#    Given browser "Firefox"
#    And website loaded this address: "http://google.com"
#    When I execute a search for "ciela.net"
#    Then I should expect there are some results
#
#  Scenario: Successful verify progress website with chrome
#    Given browser "chrome"
#    And website loaded this address: "http://google.com"
#    When I execute a search for "ciela.net"
#    Then I should expect there are some results
#
#  @positive @ui
#  Scenario Outline: Successful verify progress website with chrome
#    Given browser "<browser>"
#    And website loaded this address: "http://google.com"
#    When I execute a search for "ciela.net"
#    Then I should expect there are some results
#    Examples:
#      | browser |
#      | firefox |
#      | chrome  |

  @positive @ui
  Scenario Outline: Verify that buttons are working
    Given browser "<browser>"
    And website loaded this address: "https://progressbg.net/"
    When i click on nachalo btn
    Then I should expect current page url in the address bar
    |https://progressbg.net/|
    |https://progressbg.net/%D0%B7%D0%B0-%D0%BD%D0%B0%D1%81/|
    |https://progressbg.net/%D0%BF%D1%80%D0%BE%D0%B3%D1%80%D0%B0%D0%BC%D0%B8%D1%80%D0%B0%D0%BD%D0%B5-%D1%81-python-2/|


    Examples:
      | browser |
      | chrome  |


    @api
    Scenario: base url: "https://"

      @api
      Scenario: Get information from my repository
        Given



