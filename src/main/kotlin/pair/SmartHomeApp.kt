package example

/** turnOn後はisOnがtrue、turnOff後はfalseになる。同じ操作を繰り返してもよい。 */
interface Bulb {
    val isOn: Boolean
    fun turnOn()
    fun turnOff()
}

interface Switch {
    fun isOn(): Boolean
}

class B9000 : Bulb {
    override var isOn = false
        private set

    override fun turnOn() {
        isOn = true
        println("turnOn")
    }
    override fun turnOff() {
        isOn = false
        println("turnOff")
    }
}

class LedBulb : Bulb {
    override var isOn = false
        private set

    override fun turnOn() {
        isOn = true
    }
    override fun turnOff() {
        isOn = false
    }
}

class S9000 : Switch {
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
