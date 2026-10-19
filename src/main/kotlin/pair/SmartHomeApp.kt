package example

interface Bulb {
    fun turnOn()
    fun turnOff()
}

interface Switch {
    fun isOn(): Boolean
}

class B9000 : Bulb {
    override fun turnOn() {
        println("turnOn")
    }

    override fun turnOff() {
        println("turnOff")
    }
}

class S9000 : Switch {
    override fun isOn(): Boolean {
        return true
    }
}

class SmartHomeApp(private val bulb: Bulb, private val switch: Switch) {
    fun update() {
        if (switch.isOn()) {
            bulb.turnOn()
        } else {
            bulb.turnOff()
        }
    }
}

fun main() {
    val app = SmartHomeApp(B9000(), S9000())
    while (true) {
        app.update()
    }
}
