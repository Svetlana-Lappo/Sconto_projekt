package de.sconto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class KitchenCategoryPage extends Base {

    @FindBy(css="h1.categoryHeadline")
    private WebElement categoryTitle;

    @FindBy(css = "#prices")
    private WebElement priceFilterBtn;

    @FindBy(xpath = "//div[@class='slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']")
    private WebElement priceSlider;

    @FindBy(xpath = "//div[@class='slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']/a[1]")
    private WebElement  startSliderHandle;


    @FindBy(xpath = "//div[@class='slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']/a[2]")
    private WebElement  endSliderHandle;

    @FindBy(css = ".sliderContainer__startPriceRange")
    private WebElement startPriceRange;

    @FindBy(css = ".sliderContainer__endPriceRange")
    private WebElement endPriceRange;

    @FindBy(css = "a[href='/artikel/342231806'].articleInfo")
    private WebElement articleOne;

    @FindBy(css = "a[href='/artikel/342231824']")
    private WebElement articleTwo;


    public KitchenCategoryPage(WebDriver driver) {
        super(driver);
    }



    public void clickOnPriseFilterButton(){
        click(priceFilterBtn,4);
    }



    public void moveEndSliderHandleToLeft()  {

        moveSliderToLeft(endSliderHandle,3);
    }

    public void moveStartSliderHandleToRight()  {

        moveSliderToRight(startSliderHandle,4);
    }

    public String startPriceRange(){
        return startPriceRange.getText();
    }
    public String endPriceRange(){
        return endPriceRange.getText();
    }

    public void selectKitchenCabinetOne(){

        clickOnKitchenCabinet(articleOne);
    }

    public void selectKitchenCabinetOne1(){
        retryingFindClick(articleOne);
    }


    public void selectKitchenCabinetTwo(){
        clickOnKitchenCabinet(articleTwo);
    }

    public boolean atKitchenCategoryPage(){
      return atPage("Küche Catania bei SCONTO");
    }



}
