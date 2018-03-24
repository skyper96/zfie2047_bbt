package zfie2047MV.repository;

import org.junit.Assert;
import org.junit.Test;
import zfie2047MV.model.Product;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class StoreRepositoryTest {

    @org.junit.Test
    public void addNewProduct() throws IOException {
        Product p = new Product();
        p.setName("lapte");
        p.setCode(8);
        p.setCategory("alimente");
        p.setQuantity(10);

        StoreRepository repo = new StoreRepository();

        int initialCount = repo.getAllProducts().size();

        repo.addNewProduct(p);

        Assert.assertEquals(initialCount+1, repo.getAllProducts().size());
    }

    @org.junit.Test
    public void tryAddNewInvalidProduct() throws IOException {
        Product p = new Product();
        p.setName("lapte");
        p.setCode(-1);
        p.setCategory("alimente");
        p.setQuantity(10);

        StoreRepository repo = new StoreRepository();
        String response = repo.addNewProduct(p);
        if (response == "code q") {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void getAllProducts() {
        StoreRepository repo = new StoreRepository();

        ArrayList<Product> products = repo.getAllProducts();

        Assert.assertTrue(products.size() > 1);
    }
}