package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.HashMap;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	HashMap<Product, Integer> productsMap = new HashMap<Product, Integer>();		
	
	public void addProduct(Product product) {
		productsMap.put(product,1);
		
	}

	public void addProduct(Product product, Integer quantity) {
		if (quantity < 1) {
			throw new IllegalArgumentException();
		}
		
		productsMap.put(product,quantity);
	}

	public BigDecimal getTotalNet() {
		BigDecimal totalNet = BigDecimal.ZERO;
		for (Product key : productsMap.keySet()) {
		totalNet=totalNet.add((key.getNettoPrice()).multiply(BigDecimal.valueOf(productsMap.get(key))));
		}
		return totalNet;

	}

	public BigDecimal getTax() {
		BigDecimal tax = BigDecimal.ZERO;
		tax = (this.getTotalGross()).subtract(this.getTotalNet());
		return tax;
	}

	public BigDecimal getTotalGross() {
		BigDecimal totalGross = BigDecimal.ZERO;
		for (Product key : productsMap.keySet()) {
		totalGross=totalGross.add((key.getPriceWithTax()).multiply(BigDecimal.valueOf(productsMap.get(key))));
		}
		return totalGross;
	}
}
