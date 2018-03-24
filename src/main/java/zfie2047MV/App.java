package zfie2047MV;

import java.io.IOException;

import zfie2047MV.controller.StoreController;
import zfie2047MV.ui.StoreUI;

public class App {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		StoreController c=new StoreController();
		c.readProducts("products.txt");

		StoreUI u = new StoreUI(c);
		u.run();
	}
}
