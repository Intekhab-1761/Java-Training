package collection;

import java.util.ArrayList;
import java.util.Collections;

public class ToDoListApp {

	public static void main(String[] args) {

		ArrayList<String> urgentTasks = new ArrayList<>();
		ArrayList<String> allTasks = new ArrayList<>();

		urgentTasks.add("Repair the car");
		urgentTasks.add("Paying the checks");
		
		
		//urgentTasks.clear();
		
		allTasks.add("clean the bathroom");
		allTasks.add("Mow the lawn");
		allTasks.add("Go to the grocery store");
		
		System.out.println("Urgent tasks:");
		for(String task: urgentTasks) {
			System.out.println(task);
		}
		
		allTasks.addAll(urgentTasks);
		Collections.sort(allTasks, Collections.reverseOrder());
		
		
		System.out.println("All tasks:");
		for(String task: allTasks) {
			System.out.println(task);
		}
		
		System.out.println("---------------------------------");
		if(allTasks.contains("clean the bathroom")){
		System.out.println("I haven't cleaned the bathroom");
		}
		
		System.out.println("---------------------------------");
		System.out.println("The first three important tasks:");
		for(String task: allTasks.subList(0, 3)) {
			System.out.println(task);
		}
	}

}
