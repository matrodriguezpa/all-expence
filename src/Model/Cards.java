package Model;

import View.Cards.Recip;
import View.Cards.Task;
import java.util.ArrayList;

public class Cards {
    ArrayList <Task> taskColection;
    ArrayList <Recip> recipColection;
    //ArrayList <Prompt> promptColection;

    public Cards() {
        taskColection = new ArrayList();
        recipColection = new ArrayList();
        //promptColection = new ArrayList();
    }

    public void addTask(Task task) {
        this.taskColection.add(task);
    }

    public void setRecip(ArrayList<Recip> recip) {
        this.recipColection = recip;
    }
/*
    public void setPrompt(ArrayList<Prompt> prompt) {
        this.promptColection = prompt;
    }
*/
    public ArrayList<Task> getTask() {
        return taskColection;
    }

    public ArrayList<Recip> getRecip() {
        return recipColection;
    }
/*
    public ArrayList<Prompt> getPrompt() {
        return promptColection;
    }
    */
    
}
