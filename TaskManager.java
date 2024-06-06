
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class TaskManager {

    private List<Tasks> tasks;
    private int nextId;

    public TaskManager(){
        tasks = new ArrayList<>();
        nextId = 1;
    }

    public void addTask(String description, String category, int priority, boolean isComplete){
        tasks.add(new Tasks(nextId++, description, category, priority, isComplete));
    }

    public void markTaskComplete(int id){
        for (Tasks task : tasks){
            if (task.getId() == id){
                task.markComplete();
                break;
            }
        }
    }
    public boolean isTaskExist(int id) {
        for (Tasks task : tasks) {
            if (task.getId() == id) {
                return true;
            }
        }
        return false;
    }
    

    public void deleteTask(int id){
        tasks.removeIf(task -> task.getId() == id);
    }

    public List<Tasks> getAllTasks(){
        return tasks;
    }

    public List<Tasks> getTasksByCategory(String category){
        return tasks.stream()
                    .filter(task -> task.getCategory().equalsIgnoreCase(category))
                    .collect(Collectors.toList());

    }

    public List<Tasks> getTasksByPriority(int priority){
        return tasks.stream()
                    .filter(task -> task.getPriority() == priority)
                    .collect(Collectors.toList());
    }

    
    
}



