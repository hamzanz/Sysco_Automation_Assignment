package com.sysco.hamza_onboarding_assignment.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartProductItem {
    private WebElement product;
    private By lblProductTitleLocator = By.xpath("//tr/td[contains(@class, 'item')]/div/strong[@class='name']/a");
    private By lblProductPriceLocator = By.xpath("//tr/td[contains(@class, 'price')]//span[@class='price']");
    private By btnRemoveLocator = By.cssSelector("tr.item-info td.item div.item-details a.action-delete");

    public CartProductItem(WebElement product) {
        this.product = product;
    }

    public String getProductTitle(){
        return product.findElement(lblProductTitleLocator).getText();
    }

    public String getProductPrice() {
        return product.findElement(lblProductPriceLocator).getText();
    }

    public void removeCartItem(){
        WebElement btnDelete = product.findElement(btnRemoveLocator);
        btnDelete.click();
    }
}
