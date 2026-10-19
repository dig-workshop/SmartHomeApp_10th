package org.example.pair

import example.Bulb
import example.SmartHomeApp
import example.Switch
import kotlin.test.Test
import kotlin.test.assertEquals

class SmartHomeAppTests {
    @Test
    fun `スイッチがオンなら電球を一度だけオンにする`() {
        val bulb = RecordingBulb()
        val app = SmartHomeApp(bulb, MutableSwitch(true))

        app.runOnce()

        assertEquals(listOf("on"), bulb.commands)
    }

    @Test
    fun `スイッチがオフなら電球を一度だけオフにする`() {
        val bulb = RecordingBulb()
        val app = SmartHomeApp(bulb, MutableSwitch(false))

        app.runOnce()

        assertEquals(listOf("off"), bulb.commands)
    }

    @Test
    fun `制御するたびにスイッチの現在の状態を読み取る`() {
        val bulb = RecordingBulb()
        val switch = MutableSwitch(false)
        val app = SmartHomeApp(bulb, switch)

        app.runOnce()
        switch.on = true
        app.runOnce()
        switch.on = false
        app.runOnce()
        app.runOnce()

        assertEquals(listOf("off", "on", "off", "off"), bulb.commands)
        assertEquals(4, switch.readCount)
    }

    private class RecordingBulb : Bulb {
        val commands = mutableListOf<String>()

        override fun turnOn() {
            commands.add("on")
        }

        override fun turnOff() {
            commands.add("off")
        }
    }

    private class MutableSwitch(var on: Boolean) : Switch {
        var readCount = 0
            private set

        override fun isOn(): Boolean {
            readCount++
            return on
        }
    }
}
