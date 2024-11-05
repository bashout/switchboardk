package org.bashout.switchboardk.endpoints

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/api")
class SwitchEndpoint {
    @GetMapping("/switch")
    fun test(): String {
        return "True"
    }
}