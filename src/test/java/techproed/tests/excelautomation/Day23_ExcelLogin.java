package techproed.tests.excelautomation;

import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import java.io.ObjectInputFilter;

public class Day23_ExcelLogin {

    BlueRentalHomePage blueRentalHomePage=new BlueRentalHomePage();
    BlueRentalLoginPage blueRentalLoginPage=new BlueRentalLoginPage();

    //Bu method login sayfasina gitmek icin kullanilacak
    public void login(){
        //Sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        //home page logine tikla
    }

    @Test
    public void customerLogin(){

    }

}
/*
sam.walker@bluerentalcars.com	c!fas_art
kate.brown@bluerentalcars.com	tad1$Fas
raj.khan@bluerentalcars.com	v7Hg_va^
pam.raymond@bluerentalcars.com	Nga^g6!

-------1.GIRIS--------
HOME PAGE ' DEYIZ
home page logine tikla
LOGIN PAGE' DEYIZ
kullanici adini gir(excelden al)
kullanici sifresini gir(excelden al
login page login butonuna tikla

-------2.GIRIS--------
HOME PAGE DEYIZ
Kullanici ID sine tikla
logout a tikla
OK e tikla
home page logine tikla
LOGIN PAGE' DEYIZ
kullanici adini gir(excelden al)
kullanici sifresini gir(excelden al
login page login butonuna tikla

---------3.GIRIS------------
HOME PAGE DEYIZ
Kullanici ID sine tikla
logout a tikla
OK e tikla
home page logine tikla
LOGIN PAGE' DEYIZ
kullanici adini gir(excelden al)
kullanici sifresini gir(excelden al
login page login butonuna tikla

----------4.GIRIS--------------
HOME PAGE DEYIZ
Kullanici ID sine tikla
logout a tikla
OK e tikla
home page logine tikla
LOGIN PAGE' DEYIZ
kullanici adini gir(excelden al)
kullanici sifresini gir(excelden al
login page login butonuna tikla

 */