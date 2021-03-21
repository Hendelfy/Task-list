package com.example.demo.controllers

import com.example.demo.models.Message
import com.example.demo.repository.TaskRepository
import nu.studer.sample.tables.pojos.Tasks
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("api/tasks")
class TaskController constructor(private val taskRepository: TaskRepository) {
    @GetMapping
    fun getAllTasks() = ResponseEntity.ok(taskRepository.getAll())

    @PostMapping
    fun addTask(@RequestBody task: Tasks): ResponseEntity<Any> {
        val location = URI.create("api/${task.id}")
        if (taskRepository.add(task) == 1)
            return ResponseEntity.created(location).build()
        return ResponseEntity.badRequest().body(Message("Something went wrong"))
    }

    @GetMapping("{id}")
    fun getById(@PathVariable(value = "id") id: Int) : ResponseEntity<Tasks> {
        val task = taskRepository.getById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(task)
    }

    @DeleteMapping("{id}")
    fun deleteById(@PathVariable(value = "id") id: Int) : ResponseEntity<Any> {
        if(taskRepository.delete(id) == 1)
            return ResponseEntity.ok().build()
        return ResponseEntity.notFound().build()
    }


    @PutMapping("{id}")
    fun updateById(@RequestBody task: Tasks, @PathVariable id: String)  : ResponseEntity<Any> {
        if(taskRepository.update(task) == 1)
            return ResponseEntity.ok().build()
        return ResponseEntity.notFound().build()
    }

}