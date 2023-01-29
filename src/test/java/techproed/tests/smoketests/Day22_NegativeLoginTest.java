package techproed.tests.smoketests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day22_NegativeLoginTest {
    //Description: Kullanimda olmayan kullanici adi ve sifre ile giris yapilamamali
    //AC : Customer email:fake@bluerentalcars.com
    //     Customer password: fakepass
    //Error: User with email fake@bluerentalcars.com not found
    @Test
    public void test01() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        BlueRentalHomePage blueRentalHomePage=new BlueRentalHomePage();
        BlueRentalLoginPage blueRentalLoginPage=new BlueRentalLoginPage();
        blueRentalHomePage.loginLink.click();
        blueRentalLoginPage.email.sendKeys(ConfigReader.getProperty("fake_email"));
        blueRentalLoginPage.password.sendKeys(ConfigReader.getProperty("fake_pass"));
        blueRentalLoginPage.submitButon.click();
        Thread.sleep(2000);
        Assert.assertEquals(blueRentalLoginPage.error_message_1.getText(),"User with email fake@bluerentalcars.com not found");
        Driver.closeDriver();

    }
}
