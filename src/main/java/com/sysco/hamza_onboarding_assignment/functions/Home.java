package com.sysco.hamza_onboarding_assignment.functions;

import com.sysco.hamza_onboarding_assignment.pages.HomePage;
import com.syscolab.qe.core.ui.SyscoLabUI;

public class Home {
    private HomePage homePage;
    private SyscoLabUI syscoWebUI;

    public Home(SyscoLabUI driver) {
        syscoWebUI = driver;
        homePage = new HomePage(driver);
    }

}
