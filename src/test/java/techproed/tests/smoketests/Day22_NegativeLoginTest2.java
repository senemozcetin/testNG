package techproed.tests.smoketests;

import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day22_NegativeLoginTest2 {

    //Description:
    //Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapılamamalı
    //Acceptance Criteria:
    //Kullanici dogru email ve yanlis sifre girildiginde, hata mesajini alınmalı
    //Hata Mesaji:
    //Bad credentials
    //Test Data:
    //Customer email: jack@gmail.com
    //Customer password: fakepass


    BlueRentalHomePage blueRentalHomePage=new BlueRentalHomePage();
    BlueRentalLoginPage blueRentalLoginPage=new BlueRentalLoginPage();

    @Test
    public void test01() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        blueRentalHomePage.loginLink.click();
        blueRentalLoginPage.email.sendKeys(ConfigReader.getProperty("admin_email"));
        blueRentalLoginPage.password.sendKeys(ConfigReader.getProperty("fake_pass"));
        blueRentalLoginPage.submitButon.click();
        Thread.sleep(3000);
        assert blueRentalLoginPage.error_message_1.isDisplayed();
        Driver.closeDriver();

    }
}
