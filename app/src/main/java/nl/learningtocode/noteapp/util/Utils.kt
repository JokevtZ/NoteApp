package nl.learningtocode.noteapp.util

import java.text.SimpleDateFormat
import java.util.*

fun formatDate(time : Long): String {
    val date = Date(time)
    val format = SimpleDateFormat("EEE, dd MMM yyyy HH:mm",
        Locale.getDefault())
    return format.format(date)
}