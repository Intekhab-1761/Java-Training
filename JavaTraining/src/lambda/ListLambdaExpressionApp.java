package lambda;

import java.util.List;

public class ListLambdaExpressionApp {

	public static void main(String[] args) {

		List<Integer> inputNumbers = List.of(1,2,3,4,5);
		
		NumberOperationService numberOperationService = new NumberOperationService();
		Operation operation = number -> number * 2;
		List<Integer> outputNumbers = numberOperationService.executeOperation(inputNumbers, operation);
		System.out.println(outputNumbers);
	}

}
