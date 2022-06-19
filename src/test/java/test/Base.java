package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CarvanaHomePage;
import pages.SearchCarsPage;
import utilities.Driver;

public class Base {



  WebDriver driver;
  CarvanaHomePage carvanaHomePage;
  WebDriverWait implicitWait;
  SearchCarsPage searchCarsPage;

  @BeforeMethod
  public void setUp(){
    driver = Driver.getDriver();
    implicitWait = new WebDriverWait(driver, 30);
    carvanaHomePage = new CarvanaHomePage(driver);
    searchCarsPage = new SearchCarsPage(driver);

  }

  @AfterMethod
  public void tearDown(){
   Driver.quitDriver();
  }





}
