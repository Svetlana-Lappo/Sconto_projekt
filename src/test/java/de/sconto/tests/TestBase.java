package de.sconto.tests;

import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

    protected WebDriver driver;

    public void init(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    public void after(){
        driver.quit();
    }

//    @Rule
//    public ExternalResource externalResource = new ExternalResource() {
//        @Override
//        protected void before() throws Throwable {
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//        }
//
////        @Override
////        protected void after() {
////            driver.quit();
////
////        }
//    };
}
