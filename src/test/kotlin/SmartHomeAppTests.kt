package pair

import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test
import pair.OnOffThing
import pair.Switch
import pair.run

class SmartHomeAppTests {
    //仕様が変わった時、どこを変更すれば済むでしょうか?
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