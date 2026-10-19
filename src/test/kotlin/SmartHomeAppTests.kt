package org.example.pair

import example.B9000
import example.Bulb
import example.LedBulb
import example.Switch
import example.run
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class SmartHomeAppTests {
    @Test
    fun example() {
        assertEquals(1+1, 2)
    }

    private val onSwitch = object : Switch {
        override fun isOn() = true
    }

    private val offSwitch = object : Switch {
        override fun isOn() = false
    }

    @Test
    fun `B9000はスイッチがオンなら点灯する`() {
        val bulb: Bulb = B9000()

        run(bulb, onSwitch)

        assertEquals(true, bulb.isOn)
    }

    @Test
    fun `LedBulbはスイッチがオンなら点灯する`() {
        val bulb: Bulb = LedBulb()

        run(bulb, onSwitch)

        assertEquals(true, bulb.isOn)
    }

    @Test
    fun `B9000はスイッチがオフなら消灯する`() {
        val bulb: Bulb = B9000()
        run(bulb, onSwitch)

        run(bulb, offSwitch)

        assertEquals(false, bulb.isOn)
    }

    @Test
    fun `LedBulbはスイッチがオフなら消灯する`() {
        val bulb: Bulb = LedBulb()
        run(bulb, onSwitch)

        run(bulb, offSwitch)

        assertEquals(false, bulb.isOn)
    }

    @Test
    fun `B9000は消灯後に再び点灯できる`() {
        val bulb: Bulb = B9000()
        run(bulb, onSwitch)
        run(bulb, offSwitch)

        run(bulb, onSwitch)

        assertEquals(true, bulb.isOn)
    }

    @Test
    fun `LedBulbは消灯後に再び点灯できる`() {
        val bulb: Bulb = LedBulb()
        run(bulb, onSwitch)
        run(bulb, offSwitch)

        run(bulb, onSwitch)

        assertEquals(true, bulb.isOn)
    }

    @Test
    fun `B9000はオンを繰り返しても点灯したまま`() {
        val bulb: Bulb = B9000()
        run(bulb, onSwitch)

        run(bulb, onSwitch)

        assertEquals(true, bulb.isOn)
    }

    @Test
    fun `LedBulbはオンを繰り返しても点灯したまま`() {
        val bulb: Bulb = LedBulb()
        run(bulb, onSwitch)

        run(bulb, onSwitch)

        assertEquals(true, bulb.isOn)
    }

    @Test
    fun `B9000はオフを繰り返しても消灯したまま`() {
        val bulb: Bulb = B9000()
        run(bulb, offSwitch)

        run(bulb, offSwitch)

        assertEquals(false, bulb.isOn)
    }

    @Test
    fun `LedBulbはオフを繰り返しても消灯したまま`() {
        val bulb: Bulb = LedBulb()
        run(bulb, offSwitch)

        run(bulb, offSwitch)

        assertEquals(false, bulb.isOn)
    }
}
