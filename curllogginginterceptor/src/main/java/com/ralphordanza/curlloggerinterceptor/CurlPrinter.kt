package com.ralphordanza.curlloggerinterceptor

import android.util.Log

object CurlPrinter {
    /**
     * Drawing toolbox
     */
    private val SINGLE_DIVIDER = "────────────────────────────────────────────"

    private var sTag = "CURL"

    fun print(tag: String?, url: String, msg: String) {
        // setting tag if not null
        if (tag != null)
            sTag = tag

        val logMsg = StringBuilder("\n")
        logMsg.append("\n")
        logMsg.append(SINGLE_DIVIDER)
        logMsg.append("\n")
        logMsg.append(msg)
        logMsg.append(" ")
        logMsg.append(" \n")
        logMsg.append(SINGLE_DIVIDER)
        logMsg.append(" \n ")
        log(logMsg.toString())
    }

    private fun log(msg: String) {
        Log.d(sTag, msg)
    }
}