Feature: Athena Portal API Automation

  Scenario Outline: Login User
    Given Set endpoint and method and PayloadName "<endpoint>" and "<Method>" and "<PayloadName>"
    Then Verify Status code <Expected_status>
    Examples:
      | endpoint | Method | Expected_status | PayloadName |
      | postApi  | post   | 200             | Login_cred  |

  Scenario Outline: Invalid User Credential Login
    Given Set invalid credential endpoint and method and PayloadName "<endpoint>" and "<Method>" and "<PayloadName>"
    Then Verify Status code <Expected_status>
    Examples:
      | endpoint | Method | Expected_status | PayloadName          |
      | postApi  | post   | 400             | Invalidlogin_cred    |
      | postApi  | post   | 400             | Incompletelogin_cred |
      | postApi  | get    | 405             | Login_cred           |


#  Scenario Outline: Reset Password
#    Given Authenticate endpoint and method and PayloadName "<endpoint>" and "<Method>" and "<PayloadName>"
#    Then Verify Status code <Expected_status>
#    Examples:
#      | endpoint      | Method | Expected_status | PayloadName |
#      | putUpdatePass | put    | 200             | ResetPass   |
