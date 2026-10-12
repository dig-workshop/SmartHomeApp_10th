package example

/**
 * Smart Home Example
 */
interface Bulb {
    fun turnOn()
    fun turnOff()
}

interface Switch {
    fun isOn(): Boolean
}

class B9000: Bulb {
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

fun run(bulb: Bulb, switch: Switch) {
    if (switch.isOn()) {
        bulb.turnOn()
    } else {
        bulb.turnOff()
    }
}

fun main() {
    val bulb = B9000()
    val switch = S9000()
    while (true) {
        run(bulb, switch)
    }
}
