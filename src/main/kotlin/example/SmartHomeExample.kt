package example

/**
 * Smart Home Example
 */
class B9000: Bulb {
    fun turnOn() {
        println("turnOn")
    }
    fun turnOff() {
        println("turnOff")
    }
}

class S9000: Switch {
    fun isOn(): Boolean {
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
