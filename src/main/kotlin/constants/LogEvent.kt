package org.bashout.switchboardk.constants

enum class LogEvent(val code: String) {
    GET_SWITCH("GET_SWITCH");

    companion object {
        const val EVENT: String = "LOG_EVENT"
    }
}