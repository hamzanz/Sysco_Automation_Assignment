package com.sysco.hamza_onboarding_assignment.functions;

import com.sysco.hamza_onboarding_assignment.common.Constants;
import com.sysco.hamza_onboarding_assignment.pages.LoginPage;
import com.sysco.hamza_onboarding_assignment.utils.DriverSetUpUtil;
import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Rifad on 5/21/18.
 */
public class Login  {
    private SyscoLabUI syscoWebUI;
    private LoginPage loginPage;

    public Login(SyscoLabUI driver) {
        syscoWebUI = driver;
        loginPage = new LoginPage(driver);
    }

    public void waitForPageLoad() throws Exception {
        loginPage.verifyPageTitle();
    }

    public MyAccount loginUser(String email, String password) throws Exception {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        MyAccount myAccount = new MyAccount(syscoWebUI);
        myAccount.waitForPageLoad();
        return myAccount;
    }
}
