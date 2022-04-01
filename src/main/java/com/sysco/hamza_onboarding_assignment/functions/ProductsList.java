package com.sysco.hamza_onboarding_assignment.functions;

import com.sysco.hamza_onboarding_assignment.pages.ProductsListPage;
import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProductsList {
    private SyscoLabUI syscoWebUI;
    private ProductsListPage productsListPage;

    public ProductsList(SyscoLabUI webUI) {
        syscoWebUI = webUI;
        productsListPage = new ProductsListPage(webUI);
    }

    public void waitForProductsToLoad(){
        productsListPage.verifyProductsDisplayed();
    }

    public Product selectRandomProductFromList() {
        List<WebElement> products = productsListPage.getProductsList();
        Random rand = new Random();
        WebElement randomProduct = products.get(rand.nextInt(products.size()));
        productsListPage.clickProduct(randomProduct);

        Product product = new Product(syscoWebUI);
        product.waitForPageTitleLoad();
        return product;
    }

    public Product selectFirstProductFromList() {
        List<WebElement> products = productsListPage.getProductsList();
        productsListPage.clickProduct(products.get(0));

        Product product = new Product(syscoWebUI);
        product.waitForPageTitleLoad();
        return product;
    }
}
