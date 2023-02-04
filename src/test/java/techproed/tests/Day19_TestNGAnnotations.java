package techproed.tests;

import org.testng.annotations.*;

public class Day19_TestNGAnnotations {
    /*

    @Test : Test case olusturmak icin kullanilir
    @Before ve @After : 5 Before 5 After anotations var
    suite>tests>grup>class>method
    -------------------------------------------------------------------------------------
    @BeforeSuite: Her bir test suite den once 1 sefer calisir
    @AfterSuite:  Her bir test suite den sonra 1 sefer calisir
    @BeforeTest: Her bir testten once (testcase ile karistirilmamali) 1 sefer calisir
    @AfterTest: Her bir testten sonra (testcase ile karistirilmamali) 1 sefer calisir
    @BeforeClass: Her bir classdan once 1 sefer calisir
    @AfterClass: Her bir classdan sonra 1 sefer calisir
    @BeforeMethod: Her bir @Test annotationdan once tek sefer calisir
    @AfterMethod: Her bir @Test annotationdan sonra tek sefer calisir
    --------------------------------------------------------------------------------------
    @Ignore :@Test caseleri atlamak (skip,ignore) icin kullanilir
    @Test (enabled = false) : @Test caseleri kullanima kapatmak icin kullanilir
    testNG de testcaseler isim sirasina gore calisir(natural order)
    @Test(priority= 1) : Testcaseleri oncelemek icin kullanilir
    NOT: Default priority nin degeri "0" a esittir.
    @Test (priority = 0)

     */
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }
    @BeforeGroups
    public void beforeGroups(){
        System.out.println("Before Groups");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("After Class");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }


    @Test(priority = 1,groups = "regression-tests")
    public void test7(){
        System.out.println("Test 7");
    }
    @Test @Ignore
    public void test2(){
        System.out.println("Test 2");
    }
    @Test (enabled = false,groups = "regression-tests")
    public void test3(){
        System.out.println("Test 3");
    }
    @Test(priority = 4)
    public void test4(){
        System.out.println("Test 4");
    }
    @Test(priority = -5)
    public void test5(){
        System.out.println("Test 5");
    }
    @Test(priority = 2)
    public void test6(){
        System.out.println("Test 6");
    }

}
