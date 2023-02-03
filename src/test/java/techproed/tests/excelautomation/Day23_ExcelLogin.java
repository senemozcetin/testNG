package techproed.tests.excelautomation;

import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.io.ObjectInputFilter;
import java.util.List;
import java.util.Map;

public class Day23_ExcelLogin {

    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;
    ExcelUtils excelUtils;
    List<Map<String, String>> excelDatalari;

    //Bu method login sayfasina gitmek icin kullanilacak
    public void login(){
        //Sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        //home page logine tikla
        blueRentalHomePage=new BlueRentalHomePage();
        blueRentalLoginPage=new BlueRentalLoginPage();

        //-----SADECE ILK GIRIS------
        //loginLink butonu sadece ilk giriste sayfada gorunur
        //ikinci ve ucuncu girislerde sayfada gorunmeyeceginden NOSUCHELEMENTEXCEPTION alinir
        // Biz bu exception u try catch kullanarak yakalariz ve test cases calismaya devam eder

        try {
            blueRentalHomePage.loginLink.click();
            ReusableMethods.waitFor(1); // 1 saniye bekle
            //LOGIN SAYFASINDAYIZ
        }catch (Exception e) {
        }
        //------SONRAKI GIRISLER------
        try{
         //Kullanici ID sine tikla ==> try catch
            blueRentalHomePage.kullaniciId.click();
            ReusableMethods.waitFor(1);
         //logout a tikla          ==> try catch
            blueRentalHomePage.logOutLink.click();
            ReusableMethods.waitFor(1);
         //OK e tikla              ==> try catch
            blueRentalHomePage.OK.click();
            ReusableMethods.waitFor(1);
         //home page logine tikla  ==> try catch
            blueRentalHomePage.loginLink.click();
            ReusableMethods.waitFor(1);
        }catch (Exception e){
        }

        }
    @Test
    public void customerLogin(){
        String path ="./src/test/java/resources/mysmoketestdata.xlsx";
        //  ./ ONCEKI TUM DOSYALARI ICER. RELATIVE PATH
        String sayfa="customer_info";

        //DATALARI EXCEL UTILS METOTLARINI KULLANARAK BURAYA ALACAGIZ
        excelUtils=new ExcelUtils(path,sayfa);

        // EXCEL DATALARINI getDataList METHODU ILE CEKELIM
        excelDatalari= excelUtils.getDataList();
        //LOOP KULLANARAK DATALARI TEK TEK TESTCASEDE KULLANALIM
        for (Map<String,String> data: excelDatalari){
            login();// her loopda Login sayfasina goturecek
        //kullanici adini gir
        blueRentalLoginPage.email.sendKeys(data.get("username"));
        //kullanici sifresini gir
            blueRentalLoginPage.password.sendKeys(data.get("password"));
        // login butonuna tikla
            blueRentalLoginPage.submitButon.click();
        }


    }

}
/*
sam.walker@bluerentalcars.com	c!fas_art
kate.brown@bluerentalcars.com	tad1$Fas
raj.khan@bluerentalcars.com	v7Hg_va^
pam.raymond@bluerentalcars.com	Nga^g6!

-------1.GIRIS--------
HOME PAGE ' DEYIZ
home page logine tikla ==> try catch
LOGIN PAGE' DEYIZ
kullanici adini gir(excelden al)
kullanici sifresini gir(excelden al
login page login butonuna tikla

-------2.GIRIS--------
HOME PAGE DEYIZ
Kullanici ID sine tikla ==> try catch
logout a tikla          ==> try catch
OK e tikla              ==> try catch
home page logine tikla  ==> try catch

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