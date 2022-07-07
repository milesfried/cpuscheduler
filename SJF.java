import java.util.*;
public class SJF implements Algorithm {
    List<Task> tasks;
    public SJF(List<Task> queue){
        tasks = queue; 
    }
    public void schedule(){
        tasks.sort((d1, d2) -> {
            return d1.getBurst() - d2.getBurst();
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
