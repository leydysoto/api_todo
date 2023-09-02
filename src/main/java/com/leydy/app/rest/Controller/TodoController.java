package com.leydy.app.rest.Controller;

import com.leydy.app.rest.Model.Task;
import com.leydy.app.rest.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping(value="/")
    public String holaMundo(){
        return "hola mundo";

    }
    @GetMapping(path="/tasks")
    public List<Task> getTasks(){
        return todoRepository.findAll();

    }
    @PostMapping(value="/savetask")
    public String saveTask(@RequestBody Task task){
        todoRepository.save(task);
        return "saved task";
    }
    @PutMapping(value="/update/{id}")
    public String updateTask(@PathVariable long id,@RequestBody Task task){
        Task updatedTask=todoRepository.findById(id).get();
        updatedTask.setTitle(task.getTitle());
        updatedTask.setDescription(task.getDescription());
        todoRepository.save(updatedTask);
        return "Updated task";
    }
    @DeleteMapping(value="/delete/{id}")
    public String deleteTask(@PathVariable long id){
        Task deleteTask=todoRepository.findById(id).get();
        todoRepository.delete(deleteTask);
        return "deleted task";

    }


}
