import java.util.*;
public class Priority implements Algorithm {
    List<Task> tasks;
    public Priority(List<Task> queue){
        tasks = queue; 
    }
    public void schedule(){
        tasks.sort((d1, d2) -> {
            return d2.getPriority() - d1.getPriority();
        });
        while (!tasks.isEmpty()){
        pickNextTask();
        System.out.println("Task " + tasks.get(0).getName() + " finished\n");
        tasks.remove(0);
        }
    }
    public Task pickNextTask(){
        CPU.run(tasks.get(0), tasks.get(0).getBurst());
        return tasks.get(0);
    }
    
}
