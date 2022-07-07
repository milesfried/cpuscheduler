import java.util.*;

public class FCFS implements Algorithm {
    List<Task> tasks;
   public FCFS(List<Task> queue){
        tasks = queue; 
   }
    public void schedule(){
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
