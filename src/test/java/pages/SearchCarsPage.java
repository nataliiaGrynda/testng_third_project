package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchCarsPage{

  public SearchCarsPage(WebDriver driver){
    PageFactory.initElements(driver, this);
  }
  @FindBy(css = "div[data-qa=\"menu-flex\"]>button")
  public List<WebElement> filterOptions;

 @FindBy(css = "input[data-qa='search-bar-input']")
  public WebElement searchInputBoxSearchPage;

 @FindBy(css = "button[data-qa='go-button']")
 public WebElement goButton;

 @FindBy(css = "div[class='result-tile']")
 public List<WebElement> searchResultTiles;

 @FindBy(css = "div[class='result-tile']>a>div>div>picture>img")
  public List<WebElement> imgTile;

 @FindBy(css = "div[data-qa='base-favorite-vehicle']")
  public List<WebElement> favoriteButton;

 @FindBy(css = "div[class='tk-frame middle-frame']")
  public List<WebElement> tileBody;

 @FindBy(xpath = "//div[@data-qa=\"base-inventory-type\"]/..")
  public List<WebElement> inventoryList;

 @FindBy(xpath = "//div[@class='year-make']/..")
  public List<WebElement> yearMakeModelInformation;

 @FindBy(xpath = "//div[@data-qa=\"trim-mileage\"]")
  public List<WebElement> trimMileageInformation;

 @FindBy(css = ".monthly-payment")
  public List<WebElement> monthlyPayment;

 @FindBy(css = ".down-payment")
  public List<WebElement> downPaymentInformation;

 @FindBy(xpath = "//div[@data-qa=\"delivery-chip\"]/..")
  public List<WebElement> shippingInformation;

 @FindBy(xpath = "div[class='price ']")
  public List<WebElement> carPrice;
}
