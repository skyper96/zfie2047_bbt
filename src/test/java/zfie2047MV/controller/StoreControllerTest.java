package zfie2047MV.controller;

import org.junit.Assert;
import org.junit.Test;
import zfie2047MV.model.Product;

import static org.junit.Assert.*;

public class StoreControllerTest {

    @Test
    public void readProducts() {
        StoreController controller = new StoreController();
        controller.readProducts("products.txt");

        Assert.assertTrue(controller.stockSituation().size() > 0);
    }

    @Test
    public void readProductsInvalid(){
        StoreController controller = new StoreController();
        controller.readProducts("");

        Assert.assertEquals(0,controller.stockSituation().size());
    }

    @Test
    public void addProduct() {
        StoreController controller = new StoreController();
        controller.readProducts("products.txt");
        int tempSize = controller.stockSituation().size();
        Product tempProduct = new Product();
        int maxCode = 1;
        for (Product product : controller.stockSituation()) {
            if (product.getCode() > maxCode) maxCode = product.getCode();
        }
        maxCode++;
        tempProduct.setCode(maxCode);
        tempProduct.setName("lapte");
        tempProduct.setCategory("aliment");
        tempProduct.setQuantity(25);
        controller.addProduct(tempProduct);

        Assert.assertEquals(tempSize+1, controller.stockSituation().size());
    }

    @Test
    public void addProductInvalid() {
        StoreController controller = new StoreController();
        controller.readProducts("products.txt");
        int tempSize = controller.stockSituation().size();
        controller.addProduct((Product)null);

        Assert.assertEquals(tempSize, controller.stockSituation().size());
    }

    @Test
    public void getProductsCategory(){
        StoreController controller = new StoreController();
        controller.readProducts("products.txt");

        Assert.assertTrue(controller.getProductsCategory("aliment").size() > 0);
    }

    @Test
    public void getProductsCategoryInvalid(){
        StoreController controller = new StoreController();
        controller.readProducts("products.txt");

        Assert.assertTrue(controller.getProductsCategory(null).size() == 0);
    }

    @Test
    public void stockSituationProduct(){
        StoreController controller = new StoreController();
        controller.readProducts("products.txt");

        Assert.assertTrue(controller.stockSituationProduct("lapte").size() > 0);
    }

    @Test
    public void stockSituationProductInvalid(){
        StoreController controller = new StoreController();
        controller.readProducts("products.txt");

        Assert.assertTrue(controller.stockSituationProduct(null).size() == 0);
    }

    @Test
    public void stockSituation(){
        StoreController controller = new StoreController();
        controller.readProducts("products.txt");

        Assert.assertNotEquals(0, controller.stockSituation().size());
    }

    @Test
    public void bigBang(){
        addProduct();
        getProductsCategory();
        stockSituationProduct();
    }

    @Test
    public void incrementalSecond(){
        addProduct();
        getProductsCategory();
    }

    @Test
    public void incrementalThird(){
        addProduct();
        getProductsCategory();
        stockSituationProduct();
    }
}