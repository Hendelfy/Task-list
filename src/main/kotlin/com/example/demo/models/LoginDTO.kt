package com.example.demo.models

import org.springframework.util.LinkedMultiValueMap

class LoginDTO(private val username: String, private val password: String) {

    fun getMap(): LinkedMultiValueMap<String, String> {
        val clientId = "public"
        val grantType = "password"
        val map = LinkedMultiValueMap<String, String>()
        map.add("username", username)
        map.add("password", password)
        map.add("client_id", clientId)
        map.add("grant_type", grantType)
        return map
    }
}
