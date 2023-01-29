package techproed.tests.smoketests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

public class Day22_NegativeLoginTest3 {

    //Description:
    //Geçerli giriş yapmadan rezervasyon yapamamalı
    //Acceptance Criteria:
    //Kullanici arac bilgilerini girip CONTINUE RESERVATION butonuna tikladiginda
    //Ve giris yapilmadiginda
    //Hata mesaji almali : Please first login
    //Giris yapildiginda hata mesaji alınmamalı

    BlueRentalHomePage blueRentalHomePage=new BlueRentalHomePage();
    BlueRentalLoginPage blueRentalLoginPage=new BlueRentalLoginPage();

    @Test
    public void test01() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        Select select=new Select(blueRentalHomePage.selectCar);
        select.selectByValue("8");
        blueRentalHomePage.pickUpLocation.sendKeys(Faker.instance(Locale.CANADA).address().cityName());
        blueRentalHomePage.dropOffLocation.sendKeys(Faker.instance(Locale.CANADA).address().cityName());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hhmmaa");
        Calendar calendar = Calendar.getInstance();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = dtf.format(currentDate);
        blueRentalHomePage.pickUpDate.sendKeys(formattedDate);
        blueRentalHomePage.pickUpTime.sendKeys(simpleDateFormat.format(calendar.getTime()));
        blueRentalHomePage.dropOffDate.sendKeys("05.02.2023");
        blueRentalHomePage.dropOffTime.sendKeys(simpleDateFormat.format(calendar.getTime()));
        blueRentalHomePage.continueReservation.click();
        Thread.sleep(3000);
        assert blueRentalHomePage.pleaseFirstLogin.isDisplayed();
        Driver.closeDriver();


    }
}


