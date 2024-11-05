package org.bashout.switchboardk

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class SwitchboardKApplication

fun main(args: Array<String>) {
    runApplication<SwitchboardKApplication>(*args)
}