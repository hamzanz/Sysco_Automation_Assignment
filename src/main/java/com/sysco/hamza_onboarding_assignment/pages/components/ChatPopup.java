package com.sysco.hamza_onboarding_assignment.pages.components;

import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.By;

public class ChatPopup {
    private SyscoLabUI syscoWebUI;
    private By chatPopupLocator = By.cssSelector("div.chat-popup.active");
    private By btnChatPopupCloseLocator = By.cssSelector("div.chat-popup.active div.header button.action-close");

    public ChatPopup(SyscoLabUI webUI){
        syscoWebUI = webUI;
    }

    public void isPopupDisplayed() {
        syscoWebUI.waitTillElementLoaded(chatPopupLocator);
    }

    public void close() {
        syscoWebUI.click(btnChatPopupCloseLocator);
    }
}
