package org.example.pair

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
import kotlin.test.Test
import pair.OnOffThing
import pair.Switch
import pair.run
import pair.TV9000

class SmartHomeAppTests {
    @Test
    fun `スイッチがオンなら電球をオンにする`() {
        val bulb = SpyBulb()
        val switch = StubSwitch(true)

        run(bulb, switch)

        assertEquals(1, bulb.turnOnCount)
        assertEquals(0, bulb.turnOffCount)
    }
    
    @Test
    fun `スイッチがオフなら電球をオフにする`() {
        val bulb = SpyBulb()
        val switch = StubSwitch(false)

        run(bulb, switch)

        assertEquals(0, bulb.turnOnCount)
        assertEquals(1, bulb.turnOffCount)
    }

    // TV9000を追加してテストする
    @Test
    fun `スイッチがオンならTVをオンにする`() {
        val tv = TV9000()
        val switch = StubSwitch(true)

        run(tv, switch)

        assertTrue(tv.isOn)
    }

    @Test
    fun `スイッチがオフならTVをオフにする`() {
        val tv = TV9000()
        tv.turnOn()
        val switch = StubSwitch(false)

        run(tv, switch)

        assertFalse(tv.isOn)
    }

    private class StubSwitch(
        private val on: Boolean
    ) : Switch {
        override fun isOn(): Boolean {
            return on
        }
    }

    private class SpyBulb : OnOffThing {
        var turnOnCount = 0
            private set

        var turnOffCount = 0
            private set

        override fun turnOn() {
            turnOnCount++
        }

        override fun turnOff() {
            turnOffCount++
        }
    }
}
