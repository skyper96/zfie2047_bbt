package zfie2047MV.controller;

import java.io.IOException;
import java.util.ArrayList;
import zfie2047MV.model.Product;
import zfie2047MV.repository.StoreRepository;

public class StoreController { 
	StoreRepository io =new StoreRepository();
	public void readProducts(String f){
		try {
			if(f == null || f == "") return;
			io.readFile(f);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void addProduct(Product p){
		try {
			if (p == null) return;
			io.addNewProduct(p);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public ArrayList<Product> getProductsCategory(String cat){
		if (cat == null || cat == "") return new ArrayList<Product>();
		return io.getProductsCategory(cat);
	}
	
	public ArrayList<Product> stockSituationProduct(String pname){
		if (pname == null || pname == "") return new ArrayList<Product>();
		return io.stockSituationProduct(pname);
	}
	public ArrayList<Product> stockSituation(){
		return io.stockSituation();
	}
}
