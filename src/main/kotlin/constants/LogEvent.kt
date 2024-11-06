package org.bashout.switchboardk.constants

enum class LogEvent() {
    GET_SWITCH,
    GET_SWITCH_COMPLETE;

    companion object {
        const val EVENT: String = "log_event"
    }
}