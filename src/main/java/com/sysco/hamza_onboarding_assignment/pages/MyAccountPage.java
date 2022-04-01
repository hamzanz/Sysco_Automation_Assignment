package com.sysco.hamza_onboarding_assignment.pages;

import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
    private final String PAGE_TITLE = "My Account";
    private SyscoLabUI syscoWebUI;
    private By usernameTitle = By.xpath("//li[contains(@class,'rewards-block')]/div[@class='title']");
    private By lblPageHeader = By.xpath("//h1[@class='page-title']");

    public void verifyPageHeader() throws Exception {
        WebElement pageHeader = syscoWebUI.findElement(lblPageHeader);
        String pageTitle = pageHeader.getText();

        if(!pageTitle.toLowerCase().contains(PAGE_TITLE.toLowerCase())){
            throw new Exception("Failed to load " + PAGE_TITLE + " page.");
        }
    }

    public MyAccountPage(SyscoLabUI syscoWebUI) {
        this.syscoWebUI = syscoWebUI;
    }

    public String getUsername() {
        return syscoWebUI.getText(usernameTitle);
    }
}
