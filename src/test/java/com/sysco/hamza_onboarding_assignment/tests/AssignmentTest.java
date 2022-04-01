package com.sysco.hamza_onboarding_assignment.tests;

import com.sysco.hamza_onboarding_assignment.common.Constants;
import com.sysco.hamza_onboarding_assignment.data.ProductData;
import com.sysco.hamza_onboarding_assignment.data.UserData;
import com.sysco.hamza_onboarding_assignment.functions.*;
import com.sysco.hamza_onboarding_assignment.utils.ExcelUtil;
import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssignmentTest {
    private SyscoLabUI syscoLabWebUI = new SyscoLabWUI("chrome");

    @BeforeClass
    public void init() {
        syscoLabWebUI.navigateTo(Constants.APP_URL);
        syscoLabWebUI.maximizeWindow();
    }

    @Test
    public void assignmentTest() throws Exception {

        List<String> expectedDeliveryOptions = new ArrayList<>(Arrays.asList(
                "Leave near front door",
                "Leave near letterbox",
                "Leave just out of weather",
                "Leave at reception",
                "Send to the Post Office"
        ));

        UserData userData = ExcelUtil.getData("user1", "UserTestData.xls", UserData.class);
        TopMenu topMenu = new TopMenu(syscoLabWebUI);

        Login login = topMenu.navigateToLoginPage();
        MyAccount myAccount = login.loginUser(userData.email, userData.password);
        myAccount.verifyUsername(userData.username);

        Cart cart = topMenu.navigateToCart();
        if(cart != null) {
            cart.removeItemsInCartIfAvailable();
        }

        ProductsList productsList = topMenu.clickProductsSubMenuItem("Men", "New Arrivals");
        Product product = productsList.selectFirstProductFromList();

        String productTitle = product.getProductTitle();
        String productPrice = product.getProductPrice();
        product.selectProductSizeRandom();

        MiniCartPopup miniCartPopup = product.addToCart();
        miniCartPopup.closeMiniCartPopup();

        cart = topMenu.navigateToCart();
        ProductData productInCart = cart.getProductsFromCart().get(0);

        Assert.assertNotNull(productInCart);
        Assert.assertEquals(productTitle.toLowerCase(), productInCart.title.toLowerCase());
        Assert.assertEquals(productPrice.toLowerCase(), productInCart.price);

        SecureCheckout secureCheckout = cart.clickSecureCheckout();
        secureCheckout.clickContinueWithoutRequiredFields();
        Assert.assertTrue(secureCheckout.isRequiredFieldsErrorDisplayed());

        secureCheckout.fillAllMandatoryFields("50 John Street", "0746588293", "2000");
        List<String> actualDeliveryOptions = secureCheckout.getAllDeliveryOptions();
        Assert.assertEquals(expectedDeliveryOptions, actualDeliveryOptions);

        secureCheckout.clickContinue();
        secureCheckout.selectCreditCardPayment();
        secureCheckout.verifyCreditCardFieldsDisplayed();
    }

    @AfterClass
    public void teardown() {
        syscoLabWebUI.quit();
    }

}
