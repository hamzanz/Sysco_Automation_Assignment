package com.sysco.hamza_onboarding_assignment.pages.components;

import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import java.util.List;

public class MiniCartOffCanvasPage {
    private SyscoLabUI syscoWebUI;
    private By cartCanvasLocator = By.xpath("//div[@id='minicartOffcanvas' and contains(@class, '-active')]");
    private By btnViewCartLocator = By.xpath("//div[@class='minicart-bottom']/div[@class='actions']/a");
    private By cartItemsLocator = By.cssSelector("div#minicartOffcanvas div.minicart-items div.minicart-product");
    private By btnCartCanvasCloseLocator = By.cssSelector("div#minicartOffcanvas div.block-title div.close");

    public MiniCartOffCanvasPage(SyscoLabUI webUI) {
        syscoWebUI = webUI;
    }

    public void verifyCartCanvasIsDisplayed(){
        syscoWebUI.waitTillElementLoaded(cartCanvasLocator);
    }

    public void moveToViewCartButton(){
        syscoWebUI.move(btnViewCartLocator);
    }

    public void clickViewCart(){
        WebElement cartCanvas = syscoWebUI.findElement(cartCanvasLocator);
        moveToViewCartButton();
        cartCanvas.findElement(btnViewCartLocator).click();
    }

    public void close() {
        syscoWebUI.click(btnCartCanvasCloseLocator);
    }

    public boolean isCartEmpty() {
        try {
            List<WebElement> productsList = syscoWebUI.findElements(cartItemsLocator);
            if(productsList.size() > 0) {
                return false;
            }
        } catch (NoSuchElementException ex) {
            return true;
        }

        return true;
    }
}
