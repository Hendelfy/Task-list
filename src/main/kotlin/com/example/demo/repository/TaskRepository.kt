package com.example.demo.repository

import nu.studer.jooq.tables.daos.TasksDao
import nu.studer.jooq.tables.pojos.Tasks
import org.jooq.Configuration
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class TaskRepository constructor(private val context: DSLContext, private val configuration: Configuration) {
    private val dao : TasksDao = TasksDao(configuration)
    fun getAll(): List<Tasks> = dao.findAll()

    fun getById(id: Int): Tasks? {
        return dao.fetchOneById(id)
            ?: return null
    }

    fun add(task: Tasks) = dao.insert(task)
    fun update(task: Tasks) = dao.update(task)
    fun delete(id: Int) = dao.deleteById(id)
}