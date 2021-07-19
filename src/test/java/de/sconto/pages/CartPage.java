package de.sconto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends Base{

    @FindBy(xpath="//div[@class='cartOverview__summaryContainer cartOverview__summaryContainer--desktop']/div[1]/div[1]/div[1]//span[@class='articlePrice articlePrice--price articlePrice--summaryLinePrice']")
    private WebElement itemsAmount;

    @FindBy(xpath="//div[@class='cartOverview__summaryContainer cartOverview__summaryContainer--desktop']/div[1]/div[1]/div[2]//span[@class='articlePrice__integer']")
    private WebElement shippingCosts;

    public CartPage(WebDriver driver) {
        super(driver);
    }





public double totalAmount(){
        double totalAmount;
        String x =removeLastChar(getElementText(itemsAmount));
        System.out.println(x);
        try {
            x= x.replace(',','.');
            double amountAllItems = Double.parseDouble(x);
            double deliveryCost =Double.parseDouble(getElementText(shippingCosts));
            totalAmount = amountAllItems+deliveryCost;
            return totalAmount;
        }catch (Exception e){
          System.out.println("Exception: " + e);

        }

      return -1.00;

    }

public String removeLastChar(String str){
    if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == 'x') {
        str = str.substring(0, str.length() - 1);
    }
    return str;
}

    public boolean atCartPage(){
        return atPage("Sconto-Warenkorb");
    }

}