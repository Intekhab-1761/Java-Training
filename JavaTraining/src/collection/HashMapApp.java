package collection;

import java.util.HashMap;

public class HashMapApp {

	public static void main(String[] args) {

		HashMap<String,String> capitals = new HashMap<>();
		
		capitals.put("India", "New Delhi");
		capitals.put("Russia", "Moscow");
		capitals.put("England", "London");
		capitals.put("Nepal", "Kathmandu");
		
		capitals.putIfAbsent("Germany", "Berlin");
		
		System.out.println(capitals);
		
		for(String key: capitals.keySet()) {
		System.out.println(key);
		}
		
		for(String value:capitals.values()) {
			System.out.println(value);
		}
		
		String str = capitals.getOrDefault("Denmark", "The Capital for the given input not available.");
		System.out.println(str);
	}

}
