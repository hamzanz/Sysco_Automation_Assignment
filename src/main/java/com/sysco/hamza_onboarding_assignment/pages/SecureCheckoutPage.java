package com.sysco.hamza_onboarding_assignment.pages;

import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SecureCheckoutPage {
    private final SyscoLabUI syscoWebUI;
    private final By lblPageTitleLocator = By.cssSelector("h1.page-title span:first-child");
    private final By requiredFieldErrorLocator = By.xpath("//div[@class='field _required _error']//div[contains(@class,'field-error')]");
    private final By btnContinueLocator = By.xpath("//button[@title='Continue']");
    private final By txtStreetAddressLocator = By.xpath("//div[@name='shippingAddress.street.0']//input[@class='input-text' and @name='street[0]']");
    private final By txtPhoneNumberLocator = By.xpath("//div[@name='shippingAddress.telephone']//input[@class='input-text' and @name='telephone']");
    private final By txtPostalCodeLocator = By.xpath("//div[@name='shippingAddress.postcode']//input[@class='input-text' and @name='postcode']");
    private final By deliveryOptionsLocator = By.xpath("//div[@name='shippingAddress.delivery_notes']//select/option");
    private final By paymentFormLocator = By.xpath("//form[@id='co-payment-form']");
    private final By creditCardPaymentOptionLocator = By.xpath("//strong[text()='Credit Card']//ancestor::div[contains(@class,'payment-method-title')]/input");
    private final By txtCreditCardNumberLocator = By.id("braintree_cc_number");
    private final By txtCreditCardExpirationDateLocator = By.id("braintree_expirationDate");
    private final By txtCreditCardCVVLocator = By.id("braintree_cc_cid");


    public SecureCheckoutPage(SyscoLabUI webUI){
        syscoWebUI = webUI;
    }

    public void verifyPageIsDisplayed(){
        syscoWebUI.waitTillElementLoaded(lblPageTitleLocator);
    }

    public void waitForRequiredFieldsError() {
        syscoWebUI.waitTillElementLoaded(requiredFieldErrorLocator);
    }

    public boolean verifyRequiredFieldsErrorDisplayed() {
        List<WebElement>  elements = syscoWebUI.findElements(requiredFieldErrorLocator);
        return elements.size() > 0;
    }

    public void clickContinueButton() {
        WebElement btnContinue = syscoWebUI.findElement(btnContinueLocator);
        btnContinue.click();
    }

    public void waitForPaymentFormLoad(){
        syscoWebUI.waitTillElementLoaded(paymentFormLocator);
    }

    public void enterStreetAddress(String address) {
        WebElement txtStreetAddress = syscoWebUI.findElement(txtStreetAddressLocator);
        txtStreetAddress.sendKeys(address);
    }

    public void enterPhoneNumber(String phoneNumber) {
        WebElement txtPhoneNumber = syscoWebUI.findElement(txtPhoneNumberLocator);
        txtPhoneNumber.sendKeys(phoneNumber);
    }

    public void enterPostalCodeAndSelectFirstOption(String postalCode){
        By lstPostalCodeFirstOption = By.xpath("//div[@name='shippingAddress.postcode']//ul/li[1]/a");

        WebElement txtPostalCode =syscoWebUI.findElement(txtPostalCodeLocator);
        txtPostalCode.sendKeys(postalCode);

        syscoWebUI.waitTillElementLoaded(lstPostalCodeFirstOption);
        syscoWebUI.click(lstPostalCodeFirstOption);
    }

    public List<WebElement> getAllDeliveryOptions() {
        List<WebElement> deliveryOptions = syscoWebUI.findElements(deliveryOptionsLocator);
        return deliveryOptions;
    }

    public void selectCreditCardPayment() {
        WebElement creditCardPayment = syscoWebUI.findElement(creditCardPaymentOptionLocator);
        syscoWebUI.clickWithJavascript(creditCardPayment);
    }

    public void verifyCreditCardNumberVisibility() {
        syscoWebUI.waitTillElementLoaded(txtCreditCardNumberLocator);
    }

    public void verifyCreditCardExpiryFieldVisibility() {
        syscoWebUI.waitTillElementLoaded(txtCreditCardExpirationDateLocator);
    }

    public void verifyCreditCardCVVVisibility() {
        syscoWebUI.waitTillElementLoaded(txtCreditCardCVVLocator);
    }

}
