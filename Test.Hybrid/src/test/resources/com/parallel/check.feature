Feature: testing login details

Scenario Outline: validating details

Given Launch browser and enter url
When Enter "<username>" and "<value>" click on enter
Then Validate HomeIcon
When Post the message 
|message|
|Hello World|
Examples:
|username|value|
|d.nandakishorereddy454@gmail.com|Test@1234|


