import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class TaskManagerTest {

    private TaskManager taskManager;

    @Before
    public void setUp() {
        taskManager = new TaskManager();
    }

    @Test
    public void testAddTask() {
        taskManager.addTask("Test Task", "Test Category", 3, false);
        List<Tasks> tasks = taskManager.getAllTasks();
        assertEquals(1, tasks.size());
        assertEquals("Test Task", tasks.get(0).getDescription());
        assertEquals("Test Category", tasks.get(0).getCategory());
        assertEquals(3, tasks.get(0).getPriority());
        assertFalse(tasks.get(0).isComplete());
    }

    @Test
    public void testMarkTaskComplete() {
        taskManager.addTask("Test Task", "Test Category", 3, false);
        taskManager.markTaskComplete(1);
        assertTrue(taskManager.getAllTasks().get(0).isComplete());
    }

    @Test
    public void testDeleteTask() {
        taskManager.addTask("Test Task", "Test Category", 3, false);
        taskManager.deleteTask(1);
        assertEquals(0, taskManager.getAllTasks().size());
    }

    @Test
    public void testGetTasksByCategory() {
        taskManager.addTask("Task 1", "Category 1", 1, false);
        taskManager.addTask("Task 2", "Category 2", 2, false);
        List<Tasks> tasks = taskManager.getTasksByCategory("Category 1");
        assertEquals(1, tasks.size());
        assertEquals("Task 1", tasks.get(0).getDescription());
    }

    @Test
    public void testGetTasksByPriority() {
        taskManager.addTask("Task 1", "Category 1", 1, false);
        taskManager.addTask("Task 2", "Category 2", 1, false);
        taskManager.addTask("Task 3", "Category 3", 2, false);
        List<Tasks> tasks = taskManager.getTasksByPriority(1);
        assertEquals(2, tasks.size());
    }
}
