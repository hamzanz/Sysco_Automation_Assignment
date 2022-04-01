package com.sysco.hamza_onboarding_assignment.pages;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

/**
 * Created by Rifad on 5/21/18.
 */
public class LoginPage {
    private final String PAGE_TITLE = "Customer Login";
    private SyscoLabUI syscoWebUI;
    private By txtEmail = By.id("email");
    private By txtPassword = By.id("pass");
    private By btnLogin = By.id("send2");

    public LoginPage(SyscoLabUI driver) {
        syscoWebUI = driver;
    }

    public void verifyPageTitle() throws Exception {
        if(!syscoWebUI.getTitle().toLowerCase().contains(PAGE_TITLE.toLowerCase())){
            throw new Exception("Failed to load Login page.");
        }
    }

    public void enterEmail(String email) {
        syscoWebUI.sendKeys(txtEmail, email);
    }

    public void enterPassword(String password) {
        syscoWebUI.sendKeys(txtPassword, password);
    }

    public void clickLogin(){
        syscoWebUI.click(btnLogin);
    }

}
