package collection;

import java.util.LinkedList;

public class LinkedListApp {

	public static void main(String[] args) {

		LinkedList<String> morningRoutine = new LinkedList<>();

		if (!morningRoutine.isEmpty())
			System.out.println("The first element of the list:" + morningRoutine.getFirst());

		if (morningRoutine.isEmpty() && morningRoutine.peekFirst() != null) {
			System.out.println("The first element of the list: " + morningRoutine.peekFirst().toUpperCase());
		}

//		morningRoutine.add("Brushing my teeth");
//		morningRoutine.add("Taking the dog for the walk");
//		morningRoutine.add("Doing 32 push-ups");
		
		morningRoutine.add("Brushing my teeth");
		morningRoutine.addFirst("Taking the dog for the walk");
		morningRoutine.push("Doing 32 push-ups");
		morningRoutine.add("Reading one chapter of a book");
		System.out.println(morningRoutine);
		System.out.println("--------------------------------------------------");
		System.out.println("Using pop function: "+ morningRoutine.pop());

		System.out.println(morningRoutine);
		
		System.out.println("-----------------------------------------------");
		System.out.println("I completed the first element on my list:" + morningRoutine.pollFirst());
		System.out.println("I completed the last element on my list:" + morningRoutine.pollLast());

	}

}
