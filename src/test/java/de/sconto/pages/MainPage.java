package de.sconto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MainPage extends Base{

    @FindBy(xpath = "//*[@data-accept-action='all']")
    private WebElement cookieAcceptBtn;
    @FindBy(css = ".consentForm__root")
    private WebElement acceptBanner;
    @FindBy(css = "a.menu__linkHref--default[href='/kuechen']")
    private WebElement kitchenTab;
    @FindBy(css="a.flyoutSubCategory__link[href='/kueche-2']")
    private WebElement kitchenModel;



    public MainPage(WebDriver driver) {
        super(driver);
        visit("https://www.sconto.de/");
    }

    public void acceptCookie(){
        click(cookieAcceptBtn,2);
        Assert.assertFalse(isElementVisible(acceptBanner,2));

    }



    public void clickOnKitchenTab(){
        click(kitchenTab,2);
    }
    public void clickOnKitchenModel(){
        click(kitchenModel,2);
    }





}
