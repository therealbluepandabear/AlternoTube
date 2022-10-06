package com.therealbluepandabear.alternotube.models


object RumbleScraperUtils {
    /**
     * Converts shorthand numbers such as 15.5K or
     * 3.5K to their integer forms, which are 15500 or 3500.
     *
     * The implementation isn't the best or most concise, so it
     * could do with some improvements, but it gets the job done.
     */
    fun convertShorthandNumberToInt(shorthandNumber: String): Int {
        val mul = when(shorthandNumber.last()) {
            'K' -> 1_000
            'M' -> 1_000_000
            'B' -> 1_000_000_000
            else -> return shorthandNumber.toInt()
        }

        val chunk1 = shorthandNumber.substring(0, shorthandNumber.indexOf('.'))
        val chunk2 = shorthandNumber.substring(shorthandNumber.indexOf('.') + 1, shorthandNumber.length - 1)

        val fracInc = "1" + "0".repeat(chunk2.length)

        return (chunk1.toInt() * mul) + ((chunk2.toInt() * mul) / fracInc.toInt())
    }
}