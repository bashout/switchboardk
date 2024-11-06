package org.bashout.switchboardk.endpoints

import io.github.oshai.kotlinlogging.KotlinLogging
import org.bashout.switchboardk.constants.LogEvent
import org.bashout.switchboardk.models.Switch
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api")
@Tag(name = "Switch API", description = "Operations related to switch management")
class SwitchEndpoint {
    private val log = KotlinLogging.logger {}

    @Operation(
        summary = "Get switch by key",
        description = "Retrieves a switch based on the provided key."
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successful retrieval of switch",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = Switch::class))]),
            ApiResponse(responseCode = "404", description = "Switch not found"),
            ApiResponse(responseCode = "500", description = "Server error")
        ]
    )
    @GetMapping("/switch/{key}")
    fun getSwitch(
        @Parameter(description = "Unique key of the switch to retrieve") @PathVariable key: String
    ): Switch {
        log.atDebug {
            message = "Initiating GET switch request"
            payload = buildMap(capacity = 2) {
                put(LogEvent.EVENT, LogEvent.GET_SWITCH)
                put("switchKey", key)
            }
        }

        if (key == "test") {
            val switch = Switch("Example Switch", true)

            log.atInfo {
                message = "Completed GET switch request"
                payload = buildMap(capacity = 1) {
                    put(LogEvent.EVENT, LogEvent.GET_SWITCH_COMPLETE)
                }
            }
            return switch
        }
        throw ResponseStatusException(HttpStatus.NOT_FOUND, "Switch not found")
    }
}