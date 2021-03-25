package com.example.demo.controllers

import com.example.demo.models.ErrorMessage
import org.springframework.dao.DuplicateKeyException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(DuplicateKeyException::class)
    fun handleDuplicateKey() =
        ResponseEntity.badRequest().body(
            ErrorMessage("Bad request", "Id is already exists")
        )
}