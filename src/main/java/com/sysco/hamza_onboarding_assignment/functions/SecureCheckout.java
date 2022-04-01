package com.sysco.hamza_onboarding_assignment.functions;

import com.sysco.hamza_onboarding_assignment.pages.SecureCheckoutPage;
import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SecureCheckout {
    private SecureCheckoutPage secureCheckoutPage;

    public SecureCheckout(SyscoLabUI webUI) {
        secureCheckoutPage = new SecureCheckoutPage(webUI);
    }

    public void waitForPageLoad() {
        secureCheckoutPage.verifyPageIsDisplayed();
    }

    public void clickContinueWithoutRequiredFields() {
        secureCheckoutPage.clickContinueButton();
        secureCheckoutPage.waitForRequiredFieldsError();
    }

    public void clickContinue(){
        secureCheckoutPage.clickContinueButton();
        secureCheckoutPage.waitForPaymentFormLoad();
    }

    public boolean isRequiredFieldsErrorDisplayed() {
        return secureCheckoutPage.verifyRequiredFieldsErrorDisplayed();
    }

    public void fillAllMandatoryFields(String address, String phoneNumber, String postalCode) {
        secureCheckoutPage.enterStreetAddress(address);
        secureCheckoutPage.enterPhoneNumber(phoneNumber);
        secureCheckoutPage.enterPostalCodeAndSelectFirstOption(postalCode);
    }

    public List<String> getAllDeliveryOptions() {
        List<WebElement> deliveryOptions = secureCheckoutPage.getAllDeliveryOptions();
        List<String> deliveryOptionsList = new ArrayList<>();

        for (WebElement option: deliveryOptions) {
            String value = option.getText();
            if(value.trim().length() > 0) {
                deliveryOptionsList.add(value);
            }
        }

        return deliveryOptionsList;
    }

    public void selectCreditCardPayment(){
        secureCheckoutPage.selectCreditCardPayment();
    }

    public void verifyCreditCardFieldsDisplayed() {
        secureCheckoutPage.verifyCreditCardNumberVisibility();
        secureCheckoutPage.verifyCreditCardExpiryFieldVisibility();
        secureCheckoutPage.verifyCreditCardCVVVisibility();
    }
}
