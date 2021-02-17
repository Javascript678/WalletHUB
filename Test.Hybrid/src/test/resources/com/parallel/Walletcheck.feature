Feature: Login to Wallet Hub.
Go to this URL: http://wallethub.com/profile/test_insurance_company/
2. On the reviews section of the page, hover over the stars and click on the fourth star. Yourcode should actually (a) do the hover and (b) make sure the stars inside get lit up when youhover over them, then (c) click on the fourth star. Simply redirecting the WebDriver to the nextpage isn’t an option.
3. On the page you get redirected to, click on the Policy dropdown and change the value to“Health Insurance”.
4. Click on the link “Write a review” and write some random text (minimum of 200 characters).
5. Press submit.
6. If you are successful, you should see a confirmation screen saying you have reviewed theinstitution. You then have to go to your profile and confirm that the “review feed” got updated.
7. Go to https://wallethub.com/profile/ and assert that you can see the review.



Scenario: Checking WalletHub feature
Given login to WalletHub URL
When reviewstars are hovered and  clicked  
|reviewstars|
|4          |
When Policy is selected 
|Policy         |
|Health Insurance|
When review is updated and clicks on submit button
Then validate review posted and review stars on my profile



