import java.util.*;

public class PriorityRR implements Algorithm{
    List<Task> tasks;
    int timeQuantum;
    public PriorityRR(List<Task> queue){
        tasks = queue; 
    }
    public void schedule(){
        
        while (!tasks.isEmpty()){
            tasks.sort((d1, d2) -> {
                return d2.getPriority() - d1.getPriority();
            });
        pickNextTask();
        if (tasks.size() > 1){
        if (tasks.get(0).getPriority() == tasks.get(1).getPriority() && tasks.get(0).getBurst() > 0){
            tasks.add(tasks.get(0));
            tasks.remove(0);
        }else if (tasks.get(0).getBurst() == 0){
            tasks.remove(0);
        }else{
        }
    }else{
        if (tasks.get(0).getBurst() == 0){
            tasks.remove(0);
        }
    }
        }
    }
    public Task pickNextTask(){
        CPU.run(tasks.get(0), tasks.get(0).getBurst());
        if (tasks.get(0).getBurst() < 10){
            timeQuantum = tasks.get(0).getBurst();
        }
        else {
            timeQuantum = 10;
        }
        tasks.get(0).setBurst(tasks.get(0).getBurst() - timeQuantum);
        if (tasks.get(0).getBurst() == 0){
            System.out.println("Task " + tasks.get(0).getName() + " finished\n");
            
        } 
        return tasks.get(0);
    }
}
  