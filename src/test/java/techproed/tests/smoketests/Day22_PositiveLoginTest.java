package techproed.tests.smoketests;

import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day22_PositiveLoginTest {

    //Name:
    //US100201_Admin_Login
    //Description:
    //Admin bilgileriyle giris
    //Acceptance Criteria:
    //Admin olarak uygulamaya giris yapabilmeliyim
    //https://www.bluerentalcars.com/
    //Admin email: jack@gmail.com
    //Admin password:12345
    BlueRentalHomePage blueRentalHomePage=new BlueRentalHomePage();
    BlueRentalLoginPage blueRentalLoginPage=new BlueRentalLoginPage();

    @Test
    public void test01(){

        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        blueRentalHomePage.loginLink.click();
        blueRentalLoginPage.email.sendKeys(ConfigReader.getProperty("admin_email"));
        blueRentalLoginPage.password.sendKeys(ConfigReader.getProperty("admin_sifre"));
        blueRentalLoginPage.submitButon.click();
        assert blueRentalHomePage.kullaniciId.isDisplayed();
        Driver.closeDriver();

    }
}
