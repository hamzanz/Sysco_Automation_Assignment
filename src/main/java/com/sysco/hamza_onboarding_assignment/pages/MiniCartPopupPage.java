package com.sysco.hamza_onboarding_assignment.pages;

import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.By;

public class MiniCartPopupPage {
    private SyscoLabUI syscoWebUI;

    private By miniCartPopupLocator = By.xpath("//div[@id='minicart_popup' and contains(@class, '-active')]");
    private By btnMiniCartPopupCloseLocator = By.xpath("//div[@id='minicart_popup']//div[@class='close']");

    public MiniCartPopupPage(SyscoLabUI webUI) {
        syscoWebUI = webUI;
    }

    public void verifyMiniCartIsDisplayed(){
        syscoWebUI.waitTillElementLoaded(miniCartPopupLocator);
    }

    public void closeMiniCartPopup(){
        syscoWebUI.click(btnMiniCartPopupCloseLocator);
    }
}
