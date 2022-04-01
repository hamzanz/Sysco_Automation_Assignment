package com.sysco.hamza_onboarding_assignment.pages;

import com.sysco.hamza_onboarding_assignment.pages.components.CartProductItem;
import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class CartPage {
    private SyscoLabUI syscoWebUI;
    private By pageTitleLocator = By.xpath("//div[@class='page-title-wrapper']//span");
    private By productItemsLocator = By.xpath("//table[@id='shopping-cart-table']/tbody[@class='cart item']");
    private By btnSecureCheckoutLocator = By.cssSelector("ul.checkout button.action.checkout");

    public CartPage(SyscoLabUI webUI) {
        syscoWebUI = webUI;
    }

    public void verifyCartPageIsDisplayed(){
        syscoWebUI.waitTillElementLoaded(pageTitleLocator);
    }

    public List<CartProductItem> getCartItems() {
        try {
            List<WebElement> productElements = syscoWebUI.findElements(productItemsLocator);
            List<CartProductItem> productItems = new ArrayList<>();
            for (WebElement product: productElements) {
                CartProductItem item = new CartProductItem(product);
                productItems.add(item);
            }

            return productItems;
        } catch(NoSuchElementException ex) {
            return null;
        }
    }

    public void clickSecureCheckout() {
        syscoWebUI.click(btnSecureCheckoutLocator);
    }

}
