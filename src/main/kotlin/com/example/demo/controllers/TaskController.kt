package com.example.demo.controllers

import com.example.demo.repository.TaskRepository
import nu.studer.jooq.tables.pojos.Tasks
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("api/tasks")
class TaskController(private val taskRepository: TaskRepository) {

    @GetMapping
    fun getAllTasks() = ResponseEntity.ok(taskRepository.findAll())

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    fun addTask(@RequestBody task: Tasks): ResponseEntity<Any> {
        taskRepository.insert(task)
        val location = URI.create("api/${task.id}")
        return ResponseEntity.created(location).build()
    }

    @GetMapping("{id}")
    fun getById(@PathVariable(value = "id") id: Int): ResponseEntity<Tasks> {
        val task = taskRepository.findById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(task)
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('USER')")
    fun deleteById(@PathVariable(value = "id") id: Int): ResponseEntity<Any> {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id)
            return ResponseEntity.ok().build()
        }
        return ResponseEntity.notFound().build()
    }


    @PutMapping
    @PreAuthorize("hasRole('USER')")
    fun updateById(@RequestBody newTask: Tasks): ResponseEntity<Any> {
        val task = taskRepository.findById(newTask.id) ?: return ResponseEntity.notFound().build()
        task.description = newTask.description
        task.createdAt = newTask.createdAt
        task.difficulty = newTask.difficulty
        task.expiredAt = newTask.expiredAt
        taskRepository.update(task)
        return ResponseEntity.ok().build()
    }

}