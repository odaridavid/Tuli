package com.github.odaridavid.tuli.commons

fun requireNotBlank(text: String): String = if (text.isBlank()) "Untitled Task" else text