package com.sysco.hamza_onboarding_assignment.pages;

import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuPage {
    private SyscoLabUI syscoWebUI;
    private By lnkMyAccount = By.xpath("//div[contains(@class, \"authorization-link\")]/a");
    private By btnCart = By.className("minicart-wrapper");

    public TopMenuPage(SyscoLabUI driver) {
        syscoWebUI = driver;
    }

    public void clickMyAccountLink() {
        syscoWebUI.waitTillElementLoaded(lnkMyAccount);
        syscoWebUI.click(lnkMyAccount);
    }

    public void clickCart() {
        syscoWebUI.waitTillElementLoaded(btnCart);
        syscoWebUI.click(btnCart);
    }

    public void clickSubMenuItem(String parentMenu, String subMenu) {
        By parentMenuItem = By.xpath("//header[@class='page-header']//nav[@data-testid='navigation-menu-container']/ul/li/span[text()='"+ parentMenu +"']/parent::li");

        WebElement parentMenuItemElement = syscoWebUI.findElement(parentMenuItem);
        syscoWebUI.click(parentMenuItemElement);

        WebElement subMenuItemElement = parentMenuItemElement.findElement(By.xpath("//div[contains(@class,'sub-menu')]//ul[@class = 'menu']/li/a[@title='"+ subMenu +"']"));
        syscoWebUI.click(subMenuItemElement);
    }
}
