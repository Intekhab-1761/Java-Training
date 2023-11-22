package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class LambdaConsumerApp {

	public static void main(String[] args) {

		BiConsumer<String,Integer> printAttribute = (text,number) -> System.out.println(text+" "+number);

		printAttribute.accept("Points",10);

		Consumer<List<Integer>> multiplyNumbers = list -> {
			for (int i = 0; i < list.size(); i++) {
				list.set(i, list.get(i) * 3);
			}
		};

		List<Integer> numbers = Arrays.asList(5, 4, 3, 2, 1);
		multiplyNumbers.accept(numbers);
		System.out.println(numbers);
	}

}
