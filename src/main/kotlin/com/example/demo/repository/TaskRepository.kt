package com.example.demo.repository

import nu.studer.sample.Tables.TASKS
import nu.studer.sample.tables.pojos.Tasks
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class TaskRepository constructor(private val context: DSLContext) {
    fun getAll(): List<Tasks> = context.selectFrom(TASKS).fetch().map { Tasks(it.value1(), it.value2()) }
    fun getById(id: Int): Tasks? {
        val taskRecord = context.selectFrom(TASKS).where(TASKS.ID.eq(id)).fetchOne()
            ?: return null
        return Tasks(taskRecord.value1(), taskRecord.value2())
    }

    fun add(task: Tasks) = context.newRecord(TASKS, task).insert()
    fun update(task: Tasks) = context.newRecord(TASKS, task).update()
    fun delete(id: Int) = context.deleteFrom(TASKS).where(TASKS.ID.eq(id)).execute()
}