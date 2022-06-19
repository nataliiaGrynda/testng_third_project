package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarvanaHomePage {
  public CarvanaHomePage(WebDriver driver){
    PageFactory.initElements(driver, this);
  }
  @FindBy(css = "div[data-qa='logo-wrapper']>a>svg")
  public WebElement carvanaLogo;

  @FindBy(css = "div[data-qa='navigation-wrapper']>div>a")
  public List<WebElement> mainNavigationSectionItems;

  @FindBy(xpath = "//a[@data-cv-test=\"headerSignInLink\"]/..")
  public WebElement signInButton;

 @FindBy(xpath = "//div[@data-cv-test=\"Header.Modal\"]")
public WebElement signInModal;

@FindBy(id = "usernameField")
public WebElement emailInputBox;

@FindBy(id = "passwordField")
public WebElement passwordInputBox;

@FindBy(css = "button[type=\"submit\"]")
public WebElement signInButtonInModal;

@FindBy(css = "div[data-qa=\"error-message-container\"]")
public WebElement errorMassage;

@FindBy(css = "a[data-cv-test=\"headerSearchLink\"]")
public WebElement searchCarsLink;
}
