package org.example.pair

import example.Bulb
import example.SmartHomeApp
import example.Switch
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class SmartHomeAppTests {
    @Test
    fun `スイッチがオンなら電球を点灯する`() {
        val bulb = RecordingBulb()
        val switch = MutableSwitch(on = true)
        val app = SmartHomeApp(bulb, switch)

        app.update()

        assertEquals(listOf("on"), bulb.operations)
    }

    @Test
    fun `スイッチがオフなら電球を消灯する`() {
        val bulb = RecordingBulb()
        val switch = MutableSwitch(on = false)
        val app = SmartHomeApp(bulb, switch)

        app.update()

        assertEquals(listOf("off"), bulb.operations)
    }

    @Test
    fun `更新のたびにスイッチの現在の状態を反映する`() {
        val bulb = RecordingBulb()
        val switch = MutableSwitch(on = false)
        val app = SmartHomeApp(bulb, switch)

        app.update()
        switch.on = true
        app.update()
        switch.on = false
        app.update()

        assertEquals(listOf("off", "on", "off"), bulb.operations)
    }

    private class RecordingBulb : Bulb {
        val operations = mutableListOf<String>()

        override fun turnOn() {
            operations.add("on")
        }

        override fun turnOff() {
            operations.add("off")
        }
    }

    private class MutableSwitch(var on: Boolean) : Switch {
        override fun isOn(): Boolean = on
    }
}
