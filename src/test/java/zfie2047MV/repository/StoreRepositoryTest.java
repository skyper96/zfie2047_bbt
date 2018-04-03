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
    public void tryAddNewProductInvalidCode() throws IOException {
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

    @org.junit.Test
    public void tryAddNewProductInvalidName() throws IOException {
        Product p = new Product();
        p.setName("");
        p.setCode(1);
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

    @org.junit.Test
    public void tryAddNewProductInvalidCategory() throws IOException {
        Product p = new Product();
        p.setName("lapte");
        p.setCode(1);
        p.setCategory("");
        p.setQuantity(10);

        StoreRepository repo = new StoreRepository();
        String response = repo.addNewProduct(p);
        if (response == "code q") {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @org.junit.Test
    public void tryAddNewProductInvalidQuantity() throws IOException {
        Product p = new Product();
        p.setName("lapte");
        p.setCode(1);
        p.setCategory("aliment");
        p.setQuantity(-1);

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
        try {
            repo.readFile("products.txt");
        } catch (IOException e) {
            Assert.assertTrue(false);
        }

        ArrayList<Product> products = repo.getAllProducts();

        Assert.assertTrue(products.size() > 1);
    }

    @Test
    public void getProductsCategory(){
        StoreRepository repo = new StoreRepository();
        try {
            repo.readFile("products.txt");
        } catch (IOException e) {
            Assert.assertTrue(false);
        }

        ArrayList<Product> products = repo.getProductsCategory("aliment");

        Assert.assertTrue(products.size() > 1);
    }

    @Test
    public void getProductsInvalidCategory(){
        StoreRepository repo = new StoreRepository();
        try {
            repo.readFile("products.txt");
        } catch (IOException e) {
            Assert.assertTrue(false);
        }

        ArrayList<Product> products = repo.getProductsCategory("test123");

        Assert.assertTrue(products.size() == 0);
    }

    @Test
    public void getStockSituation(){
        StoreRepository repo = new StoreRepository();
        try {
            repo.readFile("products.txt");
        } catch (IOException e) {
            Assert.assertTrue(false);
        }

        ArrayList<Product> products = repo.stockSituation();

        Assert.assertTrue(products.size() > 1);
    }

    @Test
    public void getProductStockSituation(){
        StoreRepository repo = new StoreRepository();
        try {
            repo.readFile("products.txt");
        } catch (IOException e) {
            Assert.assertTrue(false);
        }

        ArrayList<Product> products = repo.stockSituationProduct("lapte");

        Assert.assertTrue(products.size() > 0);
    }

    @Test
    public void getInvalidProductStockSituation(){
        StoreRepository repo = new StoreRepository();
        try {
            repo.readFile("products.txt");
        } catch (IOException e) {
            Assert.assertTrue(false);
        }

        ArrayList<Product> products = repo.stockSituationProduct("test123");

        Assert.assertTrue(products.size() == 0);
    }
}