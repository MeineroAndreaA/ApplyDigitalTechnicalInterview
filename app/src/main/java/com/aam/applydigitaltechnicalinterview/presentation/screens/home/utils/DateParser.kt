package com.aam.applydigitaltechnicalinterview.presentation.screens.home.utils

import org.threeten.bp.Duration
import org.threeten.bp.Instant
import org.threeten.bp.ZoneId
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter

fun formatDate(unformattedDate: String): String {

    val formatter = DateTimeFormatter.ISO_INSTANT
    val parsedDate = Instant.from(formatter.parse(unformattedDate))

    val currentDate = Instant.now().atZone(ZoneId.of("America/Argentina/Buenos_Aires"))

    val startZonedDateTime = ZonedDateTime.ofInstant(parsedDate, ZoneId.of("UTC"))
    val endZonedDateTime = ZonedDateTime.ofInstant(
        currentDate.toInstant(),
        ZoneId.of("America/Argentina/Buenos_Aires")
    )

    val startDate = startZonedDateTime.toLocalDate()
    val endDate = endZonedDateTime.toLocalDate()

    val duration = Duration.between(startZonedDateTime, endZonedDateTime)

    return if (startDate.plusDays(1) == endDate)
        "Yesterday"
    else if (duration.toHours() == 0L) "${duration.toMinutes()}m"
    else "${duration.toHours()}h"

}