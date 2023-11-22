package collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class LinkedHashMapApp {

	public static void main(String[] args) {

		Map<String, Double> productPriceHashMap = new HashMap<>();
		productPriceHashMap.put("Chocolate Bar", 1.5);
		productPriceHashMap.put("Pasta", 1.1);
		productPriceHashMap.put("cereals", 1.7);
		productPriceHashMap.put("Apple", 1.2);

		System.out.println("HashMap:");
		for (String product : productPriceHashMap.keySet()) {
			System.out.println(product + " $" + productPriceHashMap.get(product));
		}
		System.out.println("---------------------------------------------------------------");

		System.out.println("LinkedHashMap:");
		Map<String, Double> productPriceLinkedHashMap = new LinkedHashMap<>();
		productPriceLinkedHashMap.put("Chocolate Bar", 1.5);
		productPriceLinkedHashMap.put("Pasta", 1.1);
		productPriceLinkedHashMap.put("cereals", 1.7);
		productPriceLinkedHashMap.put("Apple", 1.2);

		for (String product : productPriceLinkedHashMap.keySet()) {
			System.out.println(product + " $" + productPriceLinkedHashMap.get(product));
		}

		System.out.println("---------------------------------------------------------------");

		System.out.println("TreeMap:");
		Map<String, Double> productPriceTreeMap = new TreeMap<>();
		productPriceTreeMap.put("Chocolate Bar", 1.5);
		productPriceTreeMap.put("Pasta", 1.1);
		productPriceTreeMap.put("cereals", 1.7);
		productPriceTreeMap.put("Apple", 1.2);

		for (String product : productPriceTreeMap.keySet()) {
			System.out.println(product + " $" + productPriceTreeMap.get(product));
		}
	}

}
