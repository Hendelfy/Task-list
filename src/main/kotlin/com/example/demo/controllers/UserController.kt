package com.example.demo.controllers

import com.example.demo.models.ErrorMessage
import com.example.demo.models.LoginDTO
import com.example.demo.models.TokenDTO
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.postForEntity

@RestController
class UserController {
    val restTemplate = RestTemplate()

    @Value("\${keycloak.auth-server-url}")
    lateinit var baseUri: String

    @PostMapping("api/login")
    fun getToken(@RequestBody loginDTO: LoginDTO): ResponseEntity<Any> {
        val uri = baseUri + "realms/example/protocol/openid-connect/token"
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_FORM_URLENCODED
        return try {
            val request = HttpEntity<LinkedMultiValueMap<String, String>>(loginDTO.getMap(), headers)
            val token = restTemplate.postForEntity<TokenDTO>(uri, request, TokenDTO::class)
            ResponseEntity.ok(token.body)
        } catch (e: HttpClientErrorException) {
            ResponseEntity.badRequest().body(ErrorMessage("Bad request", "Wrong credentials!"))
        }
    }
}