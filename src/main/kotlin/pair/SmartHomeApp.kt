package example

/**
 * Smart Home Example
 */
class B9000 {
    fun turnOn() {
        println("turnOn")
    }
    fun turnOff() {
        println("turnOff")
    }
}

class S9000 {
    fun isOn(): Boolean {
        return true
    }
}


fun main() {
    val bulb = B9000()
    val switch = S9000()
    while (true) {
        if (switch.isOn()) {
            bulb.turnOn()
        } else {
            bulb.turnOff()
        }
    }
}
