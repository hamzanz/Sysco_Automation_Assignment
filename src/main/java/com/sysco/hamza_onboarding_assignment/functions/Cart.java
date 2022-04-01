package com.sysco.hamza_onboarding_assignment.functions;

import com.sysco.hamza_onboarding_assignment.data.ProductData;
import com.sysco.hamza_onboarding_assignment.pages.CartPage;
import com.sysco.hamza_onboarding_assignment.pages.components.CartProductItem;
import com.syscolab.qe.core.ui.SyscoLabUI;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private SyscoLabUI syscoWebUI;
    private CartPage cartPage;

    public Cart(SyscoLabUI webUI) {
        syscoWebUI = webUI;
        cartPage = new CartPage(webUI);
    }

    public void waitForPageLoad(){
        cartPage.verifyCartPageIsDisplayed();
    }

    public void removeItemsInCartIfAvailable() {
        while(true) {
            waitForPageLoad();
            List<CartProductItem> cartItems = cartPage.getCartItems();
            if (cartItems == null || cartItems.size() == 0) {
                break;
            }
            removeItemFromCart(cartItems.get(0));
        }
    }

    public void removeItemFromCart(CartProductItem cartItem) {
        cartItem.removeCartItem();
    }

    public SecureCheckout clickSecureCheckout(){
        cartPage.clickSecureCheckout();

        SecureCheckout secureCheckout = new SecureCheckout(syscoWebUI);
        secureCheckout.waitForPageLoad();
        return secureCheckout;
    }

    public List<ProductData> getProductsFromCart() {
        List<ProductData> productsData = new ArrayList<>();
        List<CartProductItem> productsList = cartPage.getCartItems();

        if(productsList == null || productsList.size() == 0) {
            return productsData;
        }

        for (CartProductItem product: productsList) {
            ProductData data = new ProductData();
            data.title = product.getProductTitle();
            data.price = product.getProductPrice();
            productsData.add(data);
        }

        return productsData;
    }
}
