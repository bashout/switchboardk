package org.bashout.switchboardk.endpoints

import io.github.oshai.kotlinlogging.KotlinLogging
import org.bashout.switchboardk.constants.LogEvent
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/api")
class SwitchEndpoint {
    private val log = KotlinLogging.logger {}

    @GetMapping("/switch")
    fun test(): String {

        // TODO: add a logback encoder
        log.atWarn { message = "test"
            payload = buildMap(capacity = 1) { put(LogEvent.EVENT, LogEvent.GET_SWITCH)}}
        return "True"
    }
}