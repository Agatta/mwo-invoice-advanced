package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	Map<Product, Integer> productsMap = new HashMap<Product, Integer>();		
	private int invoiceNumber;
	private static int invoiceAmount = 0;
	public String toPrint;
	
	
	public int getInvoiceNumber() {		
		return invoiceNumber;
	}	
	
	public Invoice() {
		this.invoiceNumber =  ++invoiceAmount;
	}
	
	public static void resetInvoiceNumber() {
		invoiceAmount = 0;
	}		
	
	public void addProduct(Product product) {
		addProduct(product,1);
		
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
	
	public String printedVersion() {		
	toPrint = String.valueOf(invoiceNumber);	
	for (Product product : productsMap.keySet()) {
		toPrint = toPrint+product.getName();
		toPrint = toPrint+BigDecimal.valueOf(productsMap.get(product));
		toPrint = toPrint+product.getNettoPrice();
		toPrint = toPrint+product.getClass();
		
		
	}
	return toPrint;
	}
}
