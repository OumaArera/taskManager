import java.util.List;
import java.util.Scanner;

public class TaskManagementApp {
    private TaskManager taskManager;
    private Scanner scanner;


    public TaskManagementApp(){
        taskManager = new TaskManager();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            showMenu();
    
            try {
                int choice = Integer.parseInt(scanner.nextLine());
    
                switch (choice) {
                    case 1: viewTasks(); break;
                    case 2: addTask(); break;
                    case 3: markTaskComplete(); break;
                    case 4: deleteTask(); break;
                    case 5: viewTaskByCategory(); break;
                    case 6: viewTaskByPriority(); break;
                    case 7: exit(); break;
                    default: System.out.println("Invalid choice, try again. \n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid choice.\n");
            }
        }
    }
    

    private void showMenu(){
        System.out.println("\nTask Management App\n");
        System.out.println("1. View Tasks");
        System.out.println("2. Add Task");
        System.out.println("3. Mark Task as Complete");
        System.out.println("4. Delete Task");
        System.out.println("5. View Tasks by Category");
        System.out.println("6. View Tasks by Priority");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");

    }

    private void viewTasks() {
        List<Tasks> tasks = taskManager.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks available");
        } else {
            System.out.println("+-----+------------------------------------------+-----------------+----------+------------+");
            System.out.println("| ID  | Description                              | Category        | Priority | Status     |");
            System.out.println("+-----+------------------------------------------+-----------------+----------+------------+");
    
            tasks.forEach(task -> System.out.println(task));
    
            System.out.println("+-----+----------------------------------------+-----------------+----------+------------+");
        }
    }
    

    private void addTask(){
        System.out.println("Enter description: ");
        String description = scanner.nextLine();
        System.out.println("Enter category: ");
        String category = scanner.nextLine();
        System.out.println("Enter priority (1-5): ");
        int priority = Integer.parseInt(scanner.nextLine());

        taskManager.addTask(description, category, priority, false);
        System.out.println("Task added successfully.\n\n");
    }


    private void markTaskComplete() {
        System.out.println("Enter task ID to complete: ");
        int id = Integer.parseInt(scanner.nextLine());
    
        if (taskManager.isTaskExist(id)) {
            taskManager.markTaskComplete(id);
            System.out.println("Task completed\n");
        } else {
            System.out.println("Task with ID " + id + " does not exist.\n");
        }
    }
    
    private void deleteTask() {
        System.out.println("Enter the task ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
    
        if (taskManager.isTaskExist(id)) {
            taskManager.deleteTask(id);
            System.out.println("Task deleted successfully.\n\n");
        } else {
            System.out.println("Task with ID " + id + " does not exist.\n");
        }
    }
    

    private void viewTaskByCategory(){
        System.out.println("Enter category: ");
        String category = scanner.nextLine();

        List<Tasks> tasks = taskManager.getTasksByCategory(category);

        if (tasks.isEmpty()){
            System.out.println("No tasks available in this category");
        }else{
            tasks.forEach(System.out::println);
        }

    }

    private void viewTaskByPriority(){
        System.out.println("Enter priority: ");
        int priority = Integer.parseInt(scanner.nextLine());


        List<Tasks> tasks = taskManager.getTasksByPriority(priority);

        if (tasks.isEmpty()){
            System.out.println("There is no task matching this priority");

        }else{
            tasks.forEach(System.out::println);
        }

    }

    private void exit(){
        System.out.println("Exiting the app. Goodbye!");
        System.exit(0);

    }

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("non-interactive")) {
            // Handle non-interactive mode
            System.out.println("Running in non-interactive mode");
            // Perform some default action or read from a file instead
        } else {
            // Existing interactive mode
            new TaskManagementApp().start();
        }
    }
    
}



