package com.example.demo.repository
//
//import nu.studer.sample.Tables.USERS
//import nu.studer.sample.tables.pojos.Users
//import org.jooq.DSLContext
//import org.springframework.stereotype.Repository
//
//@Repository
//class UserRepository constructor(private val context : DSLContext) {
//    fun add(user: Users) = context.newRecord(USERS, user).insert()
//    fun getByEmail(email : String) = context.selectFrom(USERS).where(USERS.NAME.eq(email)).fetchOne()
//    fun delete(id: Int) = context.deleteFrom(USERS).where(USERS.ID.eq(id)).execute()
//}