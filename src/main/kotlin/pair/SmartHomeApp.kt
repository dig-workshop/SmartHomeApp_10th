package pair

/**
 * Smart Home Example
 */
interface OnOffThing {
    fun turnOn()
    fun turnOff()
}

interface Switch {
    fun isOn(): Boolean
}

class B9000: OnOffThing {
    override fun turnOn() {
        println("turnOn")
    }
    override fun turnOff() {
        println("turnOff")
    }
}

class S9000: Switch {
    override fun isOn(): Boolean {
        return true
    }
}

//TVを追加する場合、on/offの制御はrun関数でそのまま対応可能であること
class TV9000 : OnOffThing {
    var isOn = false

    override fun turnOn() {
        isOn = true
    }

    override fun turnOff() {
        isOn = false
    }
}

fun run(thing: OnOffThing, switch: Switch) {
    if (switch.isOn()) {
        thing.turnOn()
    } else {
        thing.turnOff()
    }
}

fun main() {
    val thing = B9000()  // SpyBulb, TV9000, ...
    val switch = S9000() // StubSwitch, BlueToothSwitch, ...
    while (true) {
        run(thing, switch)
    }
}

