package com.sysco.hamza_onboarding_assignment.pages;

import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProductsListPage {
    private SyscoLabUI syscoWebUI;

    private By lstProductsLocator = By.xpath("//div[contains(@class, 'products-grid')]/ol[contains(@class, 'product-items')]/li");
    private By lstProductsTitleLocator = By.xpath("//div[contains(@class, 'products-grid')]/ol[contains(@class, 'product-items')]/li//a[@class='product-item-link']");

    public ProductsListPage(SyscoLabUI webUI) {
        syscoWebUI = webUI;
    }

    public void verifyProductsDisplayed(){
        syscoWebUI.waitTillElementLoaded(lstProductsLocator);
    }

    public List<WebElement> getProductsList() {
        List<WebElement> products = syscoWebUI.findElements(lstProductsTitleLocator);
        return products;
    }

    public void clickProduct(WebElement product) {
        syscoWebUI.click(product);
    }

}
