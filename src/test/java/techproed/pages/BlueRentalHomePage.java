package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class BlueRentalHomePage {
   public BlueRentalHomePage(){
       PageFactory.initElements(Driver.getDriver(),this);
   }
   @FindBy(partialLinkText = "Login")
    public WebElement loginLink;

   @FindBy(id = "dropdown-basic-button")
    public WebElement kullaniciId;

   @FindBy(xpath = "//select[@name='car']")
    public WebElement selectCar;

   @FindBy(name = "pickUpLocation")
    public WebElement pickUpLocation;

   @FindBy(name = "dropOfLocation")
    public WebElement dropOffLocation;

   @FindBy(name = "pickUpDate")
    public WebElement pickUpDate;

   @FindBy(name = "pickUpTime")
    public WebElement pickUpTime;

   @FindBy(name = "dropOffDate")
    public WebElement dropOffDate;

   @FindBy(name = "dropOffTime")
    public WebElement dropOffTime;

   @FindBy(xpath = "//*[@class='w-100 btn btn-primary btn-lg']")
    public WebElement continueReservation;

   @FindBy(xpath = "//div[@role='alert']")
    public WebElement pleaseFirstLogin;



}
