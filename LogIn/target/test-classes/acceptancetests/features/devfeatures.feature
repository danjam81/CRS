Feature: lop list entries
#This feature file contains several cucmber test scenarios. All tests are 
#performed against the "LOP list" application that was developed for training 
#purposes. 



#The first two scenarios are rest tests:
#@rest
#Scenario Outline: Add new entries
#Given I use the REST API
#When I call webservice AddNewEntry with "<subject>" "<owner>" <datePlusDays> "<status>" "<notes>"
#Then I get the returncode <returncode>
#And the amount of total rest entries was increased by 1
#Examples:
#|subject              |owner     |datePlusDays |status    |notes   |returncode |
#|TestSubjectRest1     |Korenko   |0            |PENDING   |aaaa    |201        |
#|TestSubjectRest2     |Dovas     |1            |ACTIVE    |bbbb    |201        |
#|TestSubjectRest3     |Taborsky  |2            |INACTIVE  |cccc    |201        |
#|TestSubjectRest4     |Richter   |3            |DONE      |dddd    |201        |

#@rest
#Scenario Outline: Remove entries
#Given I use the REST API
#When I call webservice RemoveIfEntry with subject "<subject>"
#Then the entry disappears from the list of entries
#And I get the returncode <returncode>
#And the amount of total rest entries was decreased by 1
#Examples:
#|subject              |returncode |
#|TestSubjectRest1     |200        |
#|TestSubjectRest2     |200        |
#|TestSubjectRest3     |200        |
#|TestSubjectRest4     |200        |


#The next three scenario outlines are UI tests:
@web
Scenario Outline: add entries for CRS7.LogIn
Given I navigate to the WEB UI
When I enter the value "<user1>" into the "username" field
And I enter the value "<owner>" into the "owner" field
And I enter the value "<date>" into the "date" field
And I enter the value "<status>" into the "status" field
And I enter the value "<note>" into the "note" field
And I click on Add
Then the subject "<subject>" exists on the overview page
And the amount of total web entries was increased by 1
Examples:
|username        |owner    |date       |status   |note    |
|qxy1677         |Al       |03/01/2018 |ACTIVE   |aaaaaaaa|


#@web
#Scenario Outline: update entries for CRS7.LogIn
#Given I navigate to the WEB UI
#And the subject "<subject>" exists on the overview page
#When I click  on "update" entry with subject "<subject>" 
#And I enter the value "<newSubject>" into the "subject" field
#And I enter the value "<newOwner>" into the "owner" field
#And I enter the value "<newDate>" into the "date" field
#And I enter the value "<newStatus>" into the "status" field
#And I enter the value "<newNote>" into the "note" field
#And I click on Save
#And I click on Back
#Then the subject "<newSubject>" exists on the overview page
#And the amount of total web entries was increased by 0
#Examples:
#|subject        |newSubject      |newOwner  |newDate       |newStatus |newNote |
#|Buy beer       |Buy drinks      |Amanda    |03/24/2018    |DONE      |aaaaaaaa|


#@web
#Scenario Outline: remove entries for CRS7.LogIn
#Given I navigate to the WEB UI
#And The subject "<subject>" exists in the overview
#When I click  on "remove" entry with subject "<subject>" 
#Then The subject "<subject>" does not exist in the overview
#Examples:
#|subject       |
#|Buy drinks    |



#The next three scenarios are UI tests:
# @web
# Scenario: add entry
# Given I navigate to the WEB UI
# When I enter the value "Buy drinks" into the "subject" field
# And I enter the value "Christos" into the "owner" field
# And I enter the value "03/23/2018" into the "date" field
# And I enter the value "DONE" into the "status" field
# And I enter the value "I have to hurry up!" into the "note" field
# And I click on Add
# Then the subject "Buy drinks" exists on the overview page
# And the amount of total web entries was increased by 1
# 
# 
# @web
# Scenario: update entry
# Given I navigate to the WEB UI
# And the subject "Buy drinks" exists on the overview page
# When I click  on "update" entry with subject "Buy drinks" 
# And I enter the value "Buy chips" into the "subject" field
# And I enter the value "anton" into the "owner" field
# And I enter the value "03/24/2018" into the "date" field
# And I enter the value "ACTIVE" into the "status" field
# And I enter the value "I have the chips!" into the "note" field
# And I click on Save
# And I click on Back
# Then the subject "Buy chips" exists on the overview page
# And the amount of total web entries was increased by 0
# 
# 
# @web
# Scenario: remove entry
# Given I navigate to the WEB UI
# And the subject "Buy chips" exists on the overview page
# When I click  on "remove" entry with subject "Buy chips" 
# Then the subject "Buy chips" does not exist in the overview
# And the amount of total web entries was decreased by 1