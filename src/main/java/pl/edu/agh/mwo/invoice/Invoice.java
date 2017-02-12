package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	HashMap<Product, Integer> productsMap = new HashMap<Product, Integer>();		
	
	public void addProduct(Product product) {
		// TODO: implement
		
	}

	public void addProduct(Product product, Integer quantity) {
		// TODO: implement
	}

	public BigDecimal getSubtotal() {
		return null;
	}

	public BigDecimal getTax() {
		return null;
	}

	public BigDecimal getTotal() {
		return null;
	}
}
