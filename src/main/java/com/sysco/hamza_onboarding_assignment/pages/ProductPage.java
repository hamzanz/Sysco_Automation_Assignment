package com.sysco.hamza_onboarding_assignment.pages;

import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ProductPage {
    private SyscoLabUI syscoWebUI;
    private By lblProductTitleLocator = By.xpath("//div[@class='page-title-wrapper']/h1/span");
    private By lblProductAvailableSizesLocator = By.xpath("//div[starts-with(@id, 'swatch-row-') and contains(@class, '-active')]/div[@class='swatch-option text']");
    private By btnAddToCartLocator = By.xpath("//button[@title='Add to Cart']");
    private By lblProductPriceLocator = By.xpath("//div[@class='right_sidebar']//div[contains(@class, 'price-final_price')]//span[@class='price']");

    public ProductPage(SyscoLabUI webUI){
        syscoWebUI = webUI;
    }

    public void verifyProductTitleIsDisplayed(){
        syscoWebUI.waitTillElementLoaded(lblProductTitleLocator);
    }

    public List<WebElement> getActiveSizes(){
        verifyProductActiveSizesDisplayed();
        return syscoWebUI.findElements(lblProductAvailableSizesLocator);
    }

    public void selectProductSize(WebElement size) {
        syscoWebUI.click(size);
    }

    public void clickAddToCart() {
        syscoWebUI.click(btnAddToCartLocator);
    }

    public String getProductTitle() {
        return syscoWebUI.findElement(lblProductTitleLocator).getText();
    }

    public String getProductPrice() {
        return syscoWebUI.findElement(lblProductPriceLocator).getText();
    }

    public void verifyProductActiveSizesDisplayed(){
        syscoWebUI.waitTillElementLoaded(lblProductAvailableSizesLocator);
    }

}
