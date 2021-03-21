package com.example.demo.controllers
//
//import com.example.demo.models.Message
//import com.example.demo.repository.UserRepository
//import nu.studer.sample.tables.pojos.Users
//import org.springframework.http.ResponseEntity
//import org.springframework.web.bind.annotation.*
//
//@RestController
//@RequestMapping("api")
//class UserController constructor(private val repository: UserRepository) {
//    @PostMapping("login")
//    fun login(@RequestBody userBody: Users): ResponseEntity<Any> {
//        val user = repository.getByEmail(userBody.name)
//            ?: return ResponseEntity.notFound().build()
//
//    }
//
//    @PostMapping("register")
//    fun register(@RequestBody userBody: Users): ResponseEntity<Any> {
//
////    }
//}