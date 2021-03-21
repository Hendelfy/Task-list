package com.example.demo.controllers

import com.example.demo.models.Message
import com.example.demo.repository.TaskRepository
import nu.studer.jooq.tables.pojos.Tasks
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("api/tasks")
class TaskController constructor(private val taskRepository: TaskRepository) {
    @GetMapping
    fun getAllTasks() : ResponseEntity<Any> {
        var tasks : List<Tasks>? = null
        runCatching {
            tasks = taskRepository.getAll()
        }.onFailure {
            return ResponseEntity.badRequest().body(Message("Something went wrong"))
        }
        return ResponseEntity.ok(tasks)
    }

    @PostMapping
    fun addTask(@RequestBody task: Tasks): ResponseEntity<Any> {
        val location = URI.create("api/${task.id}")
        runCatching {
            taskRepository.add(task)
        }.onFailure {
            return ResponseEntity.badRequest().body(Message("Something went wrong"))
        }
        return ResponseEntity.created(location).build()
    }

    @GetMapping("{id}")
    fun getById(@PathVariable(value = "id") id: Int): ResponseEntity<Tasks> {
        val task = taskRepository.getById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(task)
    }

    @DeleteMapping("{id}")
    fun deleteById(@PathVariable(value = "id") id: Int): ResponseEntity<Any> {
        runCatching {
            taskRepository.delete(id)
        }.onFailure {
            return ResponseEntity.notFound().build()
        }
        return ResponseEntity.ok().build()
    }


    @PutMapping("{id}")
    fun updateById(@RequestBody task: Tasks, @PathVariable id: String): ResponseEntity<Any> {
        runCatching {
            taskRepository.update(task)
        }.onFailure {
            return ResponseEntity.notFound().build()
        }
        return ResponseEntity.ok().build()
    }

}