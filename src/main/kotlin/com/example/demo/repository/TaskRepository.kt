package com.example.demo.repository

import nu.studer.jooq.tables.daos.TasksDao
import org.jooq.Configuration
import org.springframework.stereotype.Repository

@Repository
class TaskRepository(configuration: Configuration) : TasksDao(configuration) {
}