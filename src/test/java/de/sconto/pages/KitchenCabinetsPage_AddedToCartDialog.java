package de.sconto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KitchenCabinetsPage_AddedToCartDialog extends KitchenCabinetsPage{

    @FindBy(xpath="//div[@id='overlayRight']//button[@class='button button--addToCart']")
    private WebElement addToCartOverlay;

    @FindBy(xpath="//div[@id='overlayRight']//button[@name='addToCartCloseBox']")
    private WebElement addToCartCloseBox;
    @FindBy(xpath = "//*[@id='overlayRight']//div[@class='addToCartOverlay__headerConfirm']")
    private WebElement overlayDialogText;
    public KitchenCabinetsPage_AddedToCartDialog(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddToCart(){
        click(addToCartOverlay,2);
    }
    public void clickOnAddToCart1(){
        retryingFindClick(addToCartOverlay);
    }

    public String addedToCartDialogPageText(){
        return getElementText(overlayDialogText);
    }


}
