package de.sconto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KitchenCabinetsPage extends Base {

    @FindBy(css=".articleFullName.articleFullName__articleInformationInfoBlock")
    private WebElement articleInformation;

    @FindBy(css="#zipcode-logistic-input")
    private WebElement zipcode;

    @FindBy(css="#add-to-cart-logistic")
    private WebElement addToCartBtn;

    public KitchenCabinetsPage(WebDriver driver) {
        super(driver);
    }



    public void inputZipCode(String zipCode){
        type(zipcode,3,zipCode);
    }

    public void clickOnAddToCartButton(){

        click(addToCartBtn,2);
        System.out.println("Click to Cart");

    }



    public boolean atKitchenCabinetsPage(){
        return atPage("Oberschrank, 2 türig Catania | Front ohne Glas, 100 cm");
    }
}
