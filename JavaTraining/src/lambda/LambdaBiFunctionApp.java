package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class LambdaBiFunctionApp {

	public static void main(String[] args) {

		BiFunction<Integer, Integer, Double> getPow = (num1, num2) -> Math.pow(num1, num2);
		System.out.println(getPow.apply(5, 2));
		
		BiFunction<Integer, Integer, List<Integer>> generates = (size, multiply) -> {
			List<Integer> generatedList = new ArrayList<>();
			
			for(int i=0; i<size; i++) {
				generatedList.add(i*multiply);
			}
			return generatedList;
		};
		
		System.out.println(generates.apply(10, 1));
	}

}
