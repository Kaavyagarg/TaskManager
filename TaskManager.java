package TaskManager;

import core_functionality.*;
import java.util.*;
import java.time.LocalDate;

public class TaskManager {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Task> tasks = new ArrayList<>();
		TaskManager taskManager = new TaskManager();
		//taskManager.run();
		boolean exit = false;
		while (!exit) {
			System.out.println("Choose an option");
			System.out.println("1.Add a task" + "2.Delete a task" + "3.Update task status"
					+ "4.Display all pending task" + "5.Display all pending task for today"
					+ "6.Display all task sorted by Taskdate" + "7.To exit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the task name");
				String taskName = sc.next();
				System.out.println("Enter task description");
				String description = sc.next();
				System.out.println("Enter task date");
				String datestring = sc.next();
				LocalDate taskDate = LocalDate.parse(datestring);
				Task task = new Task(taskName, description, taskDate);
				tasks.add(task);
				break;

			case 2:
				System.out.println("Enter the task id of task to be deleted");
				int taskId = sc.nextInt();
				for (Task task1 : tasks)
					if (task1.getTaskId() == taskId) {
						task1.markInactive();
						System.out.println("Task with ID " + taskId + " deleted.");
						return;
					}
				System.out.println("Task with ID " + taskId + " not found");
				break;

			case 3:
				System.out.print("Enter Task ID to update status: ");
				int taskId1 = sc.nextInt();

				for (Task task1 : tasks) {
					if (task1.getTaskId() == taskId1) {
						System.out.println("Current Status: " + task1.getStatus());
						System.out.println("Select New Status (PENDING, IN PROGRESS, COMPLETED): ");
						String newStatus = sc.nextLine().toUpperCase();

						if (newStatus.equals("PENDING")) {
							task1.status = "PENDING";
						} else if (newStatus.equals("IN PROGRESS")) {
							task1.markInProgress();
						} else if (newStatus.equals("COMPLETED")) {
							task1.markCompleted();
						} else {
							System.out.println("Invalid status. Task status remains unchanged.");
						}

						System.out.println("Task status updated successfully.");
						return;
					}
				}

				System.out.println("Task with ID " + taskId1 + " not found.");

				break;
			case 4:
				System.out.println("Pending Tasks:");
				for (Task task1 : tasks) {
					if (task1.isActive() && "PENDING".equals(task1.getStatus())) {
						System.out.println(task1);
						System.out.println("---------------");
					}
				}
				break;
			case 5:
				System.out.println("Pending Tasks for Today:");
				LocalDate today = LocalDate.now();
				for (Task task1 : tasks) {
					if (task1.isActive() && "PENDING".equals(task1.getStatus()) && task1.getTaskDate().isEqual(today)) {
						System.out.println(task1);
						System.out.println("---------------");
					}
				}
				break;
			case 6:
				System.out.println("All Tasks Sorted by TaskDate:");
				ArrayList<Task> sortedTasks = new ArrayList<>(tasks);
				Collections.sort(sortedTasks, Comparator.comparing(Task::getTaskDate));
				for (Task task1 : sortedTasks) {
					if (task1.isActive()) {
						System.out.println(task1);
						System.out.println("---------------");
					}
				}
				break;
			case 7:
				System.out.println("Exiting TaskManager. Goodbye!");
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}
