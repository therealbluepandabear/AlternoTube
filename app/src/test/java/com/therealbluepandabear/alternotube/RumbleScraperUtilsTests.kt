package com.therealbluepandabear.alternotube

import com.therealbluepandabear.alternotube.models.RumbleScraperUtils
import org.junit.Test

import org.junit.Assert.*

class RumbleScraperUtilsTests {

    @Test
    fun intIsCorrectForShorthandNumber_1() {
        assertEquals(
            RumbleScraperUtils.convertShorthandNumberToInt("15.5M"),
            15_500_000
        )
    }

    @Test
    fun intIsCorrectForShorthandNumber_2() {
        assertEquals(
            RumbleScraperUtils.convertShorthandNumberToInt("2.59M"),
            2_590_000
        )
    }

    @Test
    fun intIsCorrectForShorthandNumber_3() {
        assertEquals(
            RumbleScraperUtils.convertShorthandNumberToInt("9M"),
            9_000_000
        )
    }

    @Test
    fun intIsCorrectForShorthandNumber_4() {
        assertEquals(
            RumbleScraperUtils.convertShorthandNumberToInt("0.5M"),
            500_000
        )
    }

    @Test
    fun intIsCorrectForShorthandNumber_5() {
        assertEquals(
            RumbleScraperUtils.convertShorthandNumberToInt("100.24M"),
            100_240_000
        )
    }

    @Test
    fun intIsCorrectForShorthandNumber_6() {
        assertEquals(
            RumbleScraperUtils.convertShorthandNumberToInt("5K"),
            5_000
        )
    }

    @Test
    fun intIsCorrectForShorthandNumber_7() {
        assertEquals(
            RumbleScraperUtils.convertShorthandNumberToInt("3.89M"),
            3_890_000
        )
    }

    @Test
    fun intIsCorrectForShorthandNumber_8() {
        assertEquals(
            RumbleScraperUtils.convertShorthandNumberToInt("6.27K"),
            6_270
        )
    }

    @Test
    fun intIsCorrectForShorthandNumber_9() {
        assertEquals(
            RumbleScraperUtils.convertShorthandNumberToInt("999.9M"),
            999_900_000
        )
    }

    @Test
    fun intIsCorrectForShorthandNumber_10() {
        assertEquals(
            RumbleScraperUtils.convertShorthandNumberToInt("1K"),
            1_000
        )
    }
}