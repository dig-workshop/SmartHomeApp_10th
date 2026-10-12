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

//電源をオン・オフできる
class B9000: OnOffThing {
    override fun turnOn() {
        println("turnOn")
    }
    override fun turnOff() {
        println("turnOff")
    }
}

//スイッチの状態を読み取る方法
class S9000: Switch {
    override fun isOn(): Boolean {
        return true
    }
}

//スイッチと電球を連動させるルール
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

