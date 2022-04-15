package com.mirz.gameapp.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun String.convertStringDate(): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd", Locale("id", "ID"))
    val convertedDate: Date?
    var formattedDate: String? = null
    try {
        convertedDate = sdf.parse(this)
        formattedDate =
            SimpleDateFormat("MMM dd, yyyy", Locale("id", "ID")).format(convertedDate!!)
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    if (!formattedDate.isNullOrEmpty()) return formattedDate
    return ""
}