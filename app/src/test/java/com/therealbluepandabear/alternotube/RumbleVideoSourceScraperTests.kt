package com.therealbluepandabear.alternotube

import com.therealbluepandabear.alternotube.models.VideoSourceScraper
import com.therealbluepandabear.alternotube.models.rumblescraper.RumbleVideoSourceScraper
import org.junit.Test

import org.junit.Assert.*

class RumbleVideoSourceScraperTests {

    private val rumbleVideoSourceScraper: VideoSourceScraper = RumbleVideoSourceScraper.createInstance()

    @Test
    fun videoSrcIsCorrectForUrl_1() {
        val jsoupResponse = rumbleVideoSourceScraper.scrape("v1ieskt")
        val videoSource = jsoupResponse.data
        assertEquals("https://sp.rmbl.ws/s8/2/T/4/N/C/T4NCf.caa.rec.mp4", videoSource)
    }

    @Test
    fun videoSrcIsCorrectForUrl_2() {
        val jsoupResponse = rumbleVideoSourceScraper.scrape("v1mh9nz")
        val videoSource = jsoupResponse.data
        assertEquals("https://sp.rmbl.ws/s8/2/V/u/S/2/VuS2f.caa.mp4", videoSource)
    }

    @Test
    fun videoSrcIsCorrectForUrl_3() {
        val jsoupResponse = rumbleVideoSourceScraper.scrape("v1mll2a")
        val videoSource = jsoupResponse.data
        assertEquals("https://sp.rmbl.ws/s8/2/I/F/D/3/IFD3f.caa.rec.mp4", videoSource)
    }

    @Test
    fun videoSrcIsCorrectForUrl_4() {
        val jsoupResponse = rumbleVideoSourceScraper.scrape("v1mtkq9")
        val videoSource = jsoupResponse.data
        assertEquals("https://sp.rmbl.ws/s8/2/X/G/4/4/XG44f.caa.mp4", videoSource)
    }

    @Test
    fun videoSrcIsCorrectForUrl_5() {
        val jsoupResponse = rumbleVideoSourceScraper.scrape("v1mll2a")
        val videoSource = jsoupResponse.data
        assertEquals("https://sp.rmbl.ws/s8/2/I/F/D/3/IFD3f.caa.rec.mp4", videoSource)
    }

    @Test
    fun videoSrcIsCorrectForUrl_6() {
        val jsoupResponse = rumbleVideoSourceScraper.scrape("v1m37tu")
        val videoSource = jsoupResponse.data
        assertEquals("https://sp.rmbl.ws/s8/2/I/r/m/0/Irm0f.caa.rec.mp4", videoSource)
    }

    @Test
    fun videoSrcIsCorrectForUrl_7() {
        val jsoupResponse = rumbleVideoSourceScraper.scrape("v1luvsi")
        val videoSource = jsoupResponse.data
        assertEquals("https://sp.rmbl.ws/s8/2/Y/v/T/Y/YvTYf.caa.rec.mp4", videoSource)
    }

    @Test
    fun videoSrcIsCorrectForUrl_8() {
        val jsoupResponse = rumbleVideoSourceScraper.scrape("v1muz8p")
        val videoSource = jsoupResponse.data
        assertEquals("https://sp.rmbl.ws/s8/2/P/F/i/5/PFi5f.caa.rec.mp4", videoSource)
    }

    @Test
    fun videoSrcIsCorrectForUrl_9() {
        val jsoupResponse = rumbleVideoSourceScraper.scrape("v1mob06")
        val videoSource = jsoupResponse.data
        assertEquals("https://sp.rmbl.ws/s8/2/2/E/8/3/2E83f.caa.mp4", videoSource)
    }

    @Test
    fun videoSrcIsCorrectForUrl_10() {
        val jsoupResponse = rumbleVideoSourceScraper.scrape("v1mv1kb")
        val videoSource = jsoupResponse.data
        assertEquals("https://sp.rmbl.ws/s8/2/R/o/j/5/Roj5f.caa.mp4", videoSource)
    }
}