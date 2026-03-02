package org.example

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

fun run(thing: OnOffThing, switch: Switch) {
    // ???
}

fun main() {
    val thing = B9000()  // SpyBulb, TV9000, ...
    val switch = S9000() // StubSwitch, BlueToothSwitch, ...
    while (true) {
        run(thing, switch)
    }
}

