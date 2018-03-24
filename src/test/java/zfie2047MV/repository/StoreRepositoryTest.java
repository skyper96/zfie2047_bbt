package zfie2047MV.repository;

import zfie2047MV.model.Product;

import static org.junit.Assert.*;

public class StoreRepositoryTest {

    @org.junit.Test
    public void addNewProduct() {
        Product p = new Product();
        p.setName("lapte");
        p.setCode(8);
        p.setCategory("alimente");
        p.setQuantity(10);
    }
}