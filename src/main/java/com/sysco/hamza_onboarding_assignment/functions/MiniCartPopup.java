package com.sysco.hamza_onboarding_assignment.functions;

import com.sysco.hamza_onboarding_assignment.pages.MiniCartPopupPage;
import com.syscolab.qe.core.ui.SyscoLabUI;

public class MiniCartPopup {
    private SyscoLabUI syscoWebUI;
    private MiniCartPopupPage miniCartPopupPage;

    public MiniCartPopup(SyscoLabUI webUI) {
        syscoWebUI = webUI;
        miniCartPopupPage = new MiniCartPopupPage(webUI);
    }

    public void waitForMiniCartPopupToDisplay(){
        miniCartPopupPage.verifyMiniCartIsDisplayed();
    }

    public void closeMiniCartPopup() {
        miniCartPopupPage.closeMiniCartPopup();
    }
}
