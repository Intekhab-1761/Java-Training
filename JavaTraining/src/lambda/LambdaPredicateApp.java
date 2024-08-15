package lambda;

import java.util.function.Predicate;

public class LambdaPredicateApp {

	public static void main(String[] args) {

		Predicate<String> moreThan5Letters = text -> text.length() > 5;
		Predicate<String> startsWithWelcome = text -> text.startsWith("Welcome");
		
		boolean isMoreThan5Letters = moreThan5Letters.test("Welcome");
		System.out.println("The text typed in is longer than 5 letter:" + isMoreThan5Letters);
		
		boolean isStartsWithWelcome = startsWithWelcome.test("Welcome");
		System.out.println("The text starts with \"welcome\": " + isStartsWithWelcome);
	
		boolean isLessThan5Letters = moreThan5Letters.negate().test("Welcome");
		System.out.println("The text typed in is shorter than 5 letters: " + isLessThan5Letters);
	
		boolean isCombinedAnd = moreThan5Letters.and(startsWithWelcome).test("Welcome");
		System.out.println("The text typed in is longer than 5 letter and starts with \"Welcome\":" + isMoreThan5Letters);
		
	}

}
