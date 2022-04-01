package com.sysco.hamza_onboarding_assignment.functions;

import com.sysco.hamza_onboarding_assignment.pages.ProductPage;
import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class Product {
    private SyscoLabUI syscoWebUI;
    private ProductPage productPage;

    public Product(SyscoLabUI webUI) {
        syscoWebUI = webUI;
        productPage = new ProductPage(webUI);
    }

    public void waitForPageTitleLoad(){
        productPage.verifyProductTitleIsDisplayed();
    }

    public void selectProductSizeRandom() {
        List<WebElement> productSizes = productPage.getActiveSizes();
        Random rand = new Random();
        WebElement randomProductSize = productSizes.get(rand.nextInt(productSizes.size() - 1));
        productPage.selectProductSize(randomProductSize);
    }

    public MiniCartPopup addToCart() {
        productPage.clickAddToCart();
        MiniCartPopup miniCartPopup = new MiniCartPopup(syscoWebUI);
        miniCartPopup.waitForMiniCartPopupToDisplay();
        return miniCartPopup;
    }

    public String getProductTitle() {
        return productPage.getProductTitle();
    }

    public String getProductPrice() {
        return productPage.getProductPrice();
    }

}
