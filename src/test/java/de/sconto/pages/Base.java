package de.sconto.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Base {
    private WebDriver driver;

    public Base(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void visit(String url){
        try{
            driver.get(url);
        }catch (WebDriverException wde){
            System.out.println(wde);
            Assert.fail();
        }
    }

    public void click(WebElement element, int timeout){
        try{
            new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(element)).click();
        }catch (WebDriverException wde){
            System.out.println(wde);

        }
    }

    public void waitForElementToBeVisible(WebElement element, int timeout){
        try{
            new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(element));
        }catch (WebDriverException wde){
            System.out.println(wde);

        }
    }

    public boolean isElementVisible(WebElement element, int timeout){
        try{
            new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(element));
        }catch (WebDriverException wde){
            System.out.println(wde);
            return false;

        }
        return true;
    }

    public boolean isElementPresent(By locator, int timeout){
        try{
            new WebDriverWait(driver,timeout).until(ExpectedConditions.presenceOfElementLocated(locator));
            driver.findElement(locator);
            return true;
        }catch (WebDriverException wde){
            System.out.println(wde);
            return false;


        }
    }


    public void moveSliderToLeft(WebElement sliderElement,int timeout){
        try{
            new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(sliderElement));
        }catch (WebDriverException wde){
            System.out.println(wde);
        }
        int elementWidth = sliderElement.getSize().width;

     Actions action = new Actions(driver);
     action.dragAndDropBy(sliderElement,-elementWidth*3,0).build().perform();

    }

    public void moveSliderToRight(WebElement sliderElement,int timeout){
        int elementWidth;
        try{
            new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(sliderElement));
        }catch (WebDriverException wde){
            System.out.println(wde);
        }
        elementWidth = sliderElement.getSize().width;
        System.out.println(elementWidth);

        Actions action = new Actions(driver);
        action.dragAndDropBy(sliderElement,elementWidth*3,0).build().perform();

    }

    public void type(WebElement element, int timeout, String inputText){
        try{
            new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(element));
            element.clear();
            element.sendKeys(inputText);
        }catch (WebDriverException wde){
            System.out.println(wde);
        }
    }

    public void clickOnKitchenCabinet(WebElement element){
        click(element,3);

    }

    public String getElementText(WebElement element){
        waitForElementToBeVisible(element,4);
        return element.getText();
    }
    public boolean atPage(String pageTitle){
        if(driver.getTitle().equals(pageTitle)){
            return true;
        }
        return false;
    }


    public boolean retryingFindClick(WebElement element) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                element.click();
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
    }

}
