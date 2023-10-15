package core_functionality;
import TaskManager.TaskManager;
import java.util.*;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
public class Task {

	private static int nextTaskId=1;
	private int taskId;
	private String taskName;
    private String description;
	private LocalDate taskDate;
	public String status;
	private boolean active;
	
	public Task(String taskName, String description,LocalDate taskDate)
	{
		this.taskId = nextTaskId++;
        this.taskName = taskName;
        this.description = description;
        this.taskDate = taskDate;
        this.status = "PENDING";  // Default status
        this.active = true;
	}

	public int getTaskId() { return taskId; }

	public String getTaskName() { return taskName; }

	public String getDescription() { return description; }

	public LocalDate getTaskDate() { return taskDate; }

	public String getStatus() { return status; }

	public boolean isActive() { return active; }
	
	public void markInProgress() { status = "IN PROGRESS"; }

    public void markCompleted() { status = "COMPLETED"; }

    public void markInactive() { active = false; }
    
    @Override
    public String toString() {
        return "Task ID: " + taskId + "\nTask Name: " + taskName + "\nDescription: " + description
                + "\nTask Date: " + taskDate + "\nStatus: " + status + "\nActive: " + active;
    }  
}
 

