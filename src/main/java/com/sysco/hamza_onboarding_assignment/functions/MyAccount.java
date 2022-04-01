package com.sysco.hamza_onboarding_assignment.functions;

import com.sysco.hamza_onboarding_assignment.pages.MyAccountPage;
import com.syscolab.qe.core.ui.SyscoLabUI;

public class MyAccount {
    private MyAccountPage myAccountPage;

    public MyAccount(SyscoLabUI syscoWebUI) {
        myAccountPage = new MyAccountPage(syscoWebUI);
    }

    public void waitForPageLoad() throws Exception {
        myAccountPage.verifyPageHeader();
    }

    public boolean verifyUsername(String username) {
        String actualUsername = myAccountPage.getUsername().toLowerCase();
        return actualUsername.contains(username.toLowerCase());
    }


}
