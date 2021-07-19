package de.sconto.tests;

import de.sconto.pages.*;
import org.testng.Assert;
import org.testng.annotations.*;


public class AddKitchenToCartTest extends TestBase {

    MainPage mainPage;
    KitchenCategoryPage kitchenCategoryPage;
    KitchenCabinetsPage kitchenCabinetsPage;
    CartPage cartPage;
    KitchenCabinetsPage_AddedToCartDialog kitchenCabinetsPage_addedToCartDialog;

    @BeforeClass
    public void setUp() {
        init();
        mainPage = new MainPage(driver);
        kitchenCategoryPage = new KitchenCategoryPage(driver);
        kitchenCabinetsPage = new KitchenCabinetsPage(driver);
        cartPage = new CartPage(driver);
        kitchenCabinetsPage_addedToCartDialog = new KitchenCabinetsPage_AddedToCartDialog(driver);
    }

    @Test
    public void addKitchenToTheCartTest() throws InterruptedException {
        mainPage.acceptCookie();
        mainPage.clickOnKitchenTab();
        mainPage.clickOnKitchenModel();
        Assert.assertTrue(kitchenCategoryPage.atKitchenCategoryPage());
        kitchenCategoryPage.clickOnPriseFilterButton();
        kitchenCategoryPage.moveEndSliderHandleToLeft();
        //Assert.assertEquals("405 €",kitchenCategoryPage.endPriceRange());
        // kitchenCategoryPage.moveStartSliderHandleToRight();
        // Assert.assertEquals("113 €",kitchenCategoryPage.startPriceRange());
        kitchenCategoryPage.selectKitchenCabinetOne1();
        Assert.assertTrue(kitchenCabinetsPage.atKitchenCabinetsPage());
        kitchenCabinetsPage.inputZipCode("90763");
        Thread.sleep(4000);
        kitchenCabinetsPage.clickOnAddToCartButton();
        Assert.assertEquals(kitchenCabinetsPage_addedToCartDialog.addedToCartDialogPageText(), "Ihr Artikel befindet sich nun im Warenkorb");
        kitchenCabinetsPage_addedToCartDialog.clickOnAddToCart();
        Assert.assertEquals(cartPage.totalAmount(), 161.2);


    }

    @AfterClass
    public void tearDown() {
       after();
    }

}
