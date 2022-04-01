package com.sysco.hamza_onboarding_assignment.functions;

import com.sysco.hamza_onboarding_assignment.pages.TopMenuPage;
import com.sysco.hamza_onboarding_assignment.pages.components.ChatPopup;
import com.sysco.hamza_onboarding_assignment.pages.components.MiniCartOffCanvasPage;
import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

public class TopMenu {
    SyscoLabUI syscoWebUI;
    TopMenuPage topMenuPage;

    public TopMenu(SyscoLabUI webui) {
        syscoWebUI = webui;
        topMenuPage = new TopMenuPage(webui);
    }

    public Login navigateToLoginPage() throws Exception {
        topMenuPage.clickMyAccountLink();
        Login login = new Login(syscoWebUI);
        login.waitForPageLoad();
        return login;
    }

    public Cart navigateToCart() {
        topMenuPage.clickCart();

        MiniCartOffCanvasPage miniCartOffCanvasPage = new MiniCartOffCanvasPage(syscoWebUI);
        miniCartOffCanvasPage.verifyCartCanvasIsDisplayed();
        if(miniCartOffCanvasPage.isCartEmpty()) {
            miniCartOffCanvasPage.close();
            return null;
        }

        miniCartOffCanvasPage.clickViewCart();

        Cart cart = new Cart(syscoWebUI);
        cart.waitForPageLoad();

        try {
            ChatPopup chatPopup = new ChatPopup(syscoWebUI);
            chatPopup.isPopupDisplayed();
            chatPopup.close();
        }
        catch (NoSuchElementException ex) {}
        catch (TimeoutException ex) {}

        return cart;
    }

    public ProductsList clickProductsSubMenuItem(String parentMenu, String subMenu) {
        topMenuPage.clickSubMenuItem(parentMenu, subMenu);
        ProductsList productsList = new ProductsList(syscoWebUI);
        productsList.waitForProductsToLoad();
        return productsList;
    }
}
