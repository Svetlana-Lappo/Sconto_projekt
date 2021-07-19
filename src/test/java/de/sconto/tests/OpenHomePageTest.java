package de.sconto.tests;

import de.sconto.pages.MainPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OpenHomePageTest extends TestBase {


    MainPage mainPage;

   @BeforeClass
    public void setUp(){
        init();
        mainPage = new MainPage(driver);
    }

    @Test
    public void openMainPageTest(){

        mainPage.acceptCookie();

    }

    @AfterClass
    public void tearDown(){
        after();
    }




}
