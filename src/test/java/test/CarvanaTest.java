package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.Waiter;

public class CarvanaTest extends Base {
  /*
  Test Case 1: Test name = Validate Carvana home page title and url
Given user is on "https://www.carvana.com/"
Then validate title equals to "Carvana | Buy & Finance Used Cars Online | At Home Delivery"
And validate url equals to "https://www.carvana.com/"
*/
  @Test(priority = 1, description = "validate TITLE and URL")
  public void validateTitleAndUrl(){
  driver.get("https://www.carvana.com/");
  String expectedTitle = "Carvana | Buy & Finance Used Cars Online | At Home Delivery";
  String actualTitle = driver.getTitle();
  String expectedURL = "https://www.carvana.com/";
  String actualURL = driver.getCurrentUrl();
  Assert.assertEquals(actualTitle, expectedTitle);
  Assert.assertEquals(actualURL, expectedURL);
}
/*
Test Case 2: Test name = Validate the Carvana logo
Test priority = 2
Given user is on "https://www.carvana.com/"
Then validate the logo of the “Carvana” is displayed
*/
 @Test(priority = 2, description = "validate the carvana Logo")
   public void carvanaLogo() {
   driver.get("https://www.carvana.com/");
   Assert.assertTrue(carvanaHomePage.carvanaLogo.isDisplayed());
   }
   /*
Test Case 3: Test name = Validate the main navigation section items
Test priority = 3
Given user is on "https://www.carvana.com/"
Then validate the navigation section items below are displayed
|HOW IT WORKS      |
|ABOUT CARVANA     |
|SUPPORT & CONTACT |
*/
  @Test(priority = 3, description = "Validate the main navigation section items")
   public void mainNavigationSectionItem() {
    driver.get("https://www.carvana.com/");
    String[] expectedResultMainNavigationSectionItems = {"HOW IT WORKS", "ABOUT CARVANA", "SUPPORT & CONTACT"};
    for (int i = 0; i < 3; i++) {
      Assert.assertEquals(carvanaHomePage.mainNavigationSectionItems.get(i).getText(), expectedResultMainNavigationSectionItems[i]);
    }
  }
/*
Test name = Validate the sign in error message
Test priority = 4
Given user is on "https://www.carvana.com/"
When user clicks on “SIGN IN” button
Then user should be navigated to “Sign in” modal
When user enters email as “johndoe@gmail.com”
And user enters password as "abcd1234"
And user clicks on "SIGN IN" button
Then user should see error message as "Email address and/or password combination is incorrect
Please try again or reset your password."
*/
   @Test(priority = 4, description = "Validate the sign in error message")
  public void validateTheSignInErrorMessage(){
     driver.get("https://www.carvana.com/");
     carvanaHomePage.signInButton.click();
  Assert.assertTrue(carvanaHomePage.signInModal.isDisplayed());
  Assert.assertTrue(carvanaHomePage.emailInputBox.isDisplayed());
  Assert.assertTrue(carvanaHomePage.passwordInputBox.isDisplayed());
  Assert.assertTrue(carvanaHomePage.signInModal.isDisplayed());
  carvanaHomePage.emailInputBox.sendKeys("johndoe@gmail.com");
  carvanaHomePage.passwordInputBox.sendKeys("abcd1234");
  carvanaHomePage.signInModal.click();
  Assert.assertTrue(carvanaHomePage.errorMassage.isDisplayed());
   }
/*
Test Case 5: Test name = Validate the search filter options and search button
Test priority = 5
Given user is on "https://www.carvana.com/"
When user clicks on "SEARCH CARS" link
Then user should be routed to "https://www.carvana.com/cars"
And user should see filter options
|PAYMENT & PRICE      |
|MAKE & MODEL      |
|BODY TYPE         |
|YEAR & MILEAGE      |
|FEATURES      |
|MORE FILTERS      |
*/
   @Test(priority = 5, description = "validate the search filter option and search button")
   public void searchFilterOptionAndSearchButton() {
     driver.get("https://www.carvana.com/");
     Assert.assertTrue(carvanaHomePage.searchCarsLink.isDisplayed());
     carvanaHomePage.searchCarsLink.click();
     String[] expectedResult = {"PAYMENT & PRICE", "MAKE & MODEL", "BODY TYPE", "YEAR & MILEAGE", "FEATURES", "MORE FILTERS"};
     for (int i = 0; i < 6; i++) {
       Assert.assertEquals(searchCarsPage.filterOptions.get(i).getText(), expectedResult[i]);
     }
   }

   @Test(priority = 6, description = "validate the search result tiles")
   public void searchResultTiles() {
     driver.get("https://www.carvana.com/");
     carvanaHomePage.searchCarsLink.click();
     String expectedURL = "https://www.carvana.com/cars";
     String actualURL = driver.getCurrentUrl();
     Assert.assertEquals(actualURL, expectedURL);
     searchCarsPage.searchInputBoxSearchPage.sendKeys("mercedes-benz");
     searchCarsPage.goButton.click();
     Waiter.pause(1);
     Assert.assertTrue(driver.getCurrentUrl().contains("mercedes-benz"));
     for (int i = 0; i < searchCarsPage.searchResultTiles.size(); i++) {
       Assert.assertTrue(searchCarsPage.searchResultTiles.get(i).isDisplayed());
       Assert.assertTrue(searchCarsPage.imgTile.get(i).isDisplayed());
       Assert.assertTrue(searchCarsPage.favoriteButton.get(i).isDisplayed());
       Assert.assertTrue(searchCarsPage.tileBody.get(i).isDisplayed());
       Assert.assertFalse(searchCarsPage.inventoryList.get(i).getText().isEmpty());
       Assert.assertTrue(searchCarsPage.inventoryList.get(i).isDisplayed());
       Assert.assertFalse(searchCarsPage.yearMakeModelInformation.get(i).getText().isEmpty());
       Assert.assertTrue(searchCarsPage.yearMakeModelInformation.get(i).isDisplayed());
       Assert.assertFalse(searchCarsPage.trimMileageInformation.get(i).getText().isEmpty());
       Assert.assertTrue(searchCarsPage.trimMileageInformation.get(i).isDisplayed());
       Assert.assertFalse(searchCarsPage.monthlyPayment.get(i).getText().isEmpty());
       Assert.assertTrue(searchCarsPage.monthlyPayment.get(i).isDisplayed());
       Assert.assertFalse(searchCarsPage.downPaymentInformation.get(i).getText().isEmpty());
       Assert.assertTrue(searchCarsPage.downPaymentInformation.get(i).isDisplayed());
   Assert.assertTrue(searchCarsPage.shippingInformation.get(i).isDisplayed()); //... 7
       //  Assert.assertTrue(searchCarsPage.carPrice.get(i).isDisplayed());//....4

     }
   }

  }

















