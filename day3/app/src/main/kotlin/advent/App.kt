/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package advent

import java.io.File
import kotlin.collections.mutableListOf

class Ruck() {

    fun getLines(file: String): List<String> {
        return File(file).useLines { it.toList() }
    }

    fun getValue(lines: List<String>): Int {
        var value = 0
        var dupes = 0
        lines.forEach { line -> run {
            val half = line.length/2

            val left = line.substring(0, half)
            val right = line.substring(half, line.length)


            var leftHs = HashSet<Char>(half)
            var rightHs = HashSet<Char>(half)

            left.forEach { x -> leftHs.add(x) }
            right.forEach { x -> rightHs.add(x) }

            leftHs.forEach { x -> run {
                if (rightHs.contains(x)) {
                    dupes = 1
                    value += x.code.toPriority()
                }
            }}
            if (dupes == 0) {
                println(line.length.toString() + "|" + left.length.toString() + "|" + right.length.toString())
                println(line + "|" + left + "|" + right)
            }
            dupes = 0
        }}
        println(dupes)
        println(value)
        return value
    }

    fun getGroupValue(lines: List<String>): Int {
        var badgeValues = 0
        lines.forEachIndexed { k,v -> run {
            if (k % 3 != 0)
                return@forEachIndexed
            var first = HashSet<Char>(lines[k].length)
            var second = HashSet<Char>(lines[k+1].length)
            var third = HashSet<Char>(lines[k+2].length)

            lines[k].forEach { x -> first.add(x) }
            lines[k+1].forEach { x -> second.add(x) }
            lines[k+2].forEach { x -> third.add(x) }

            first.forEach{ x -> run {
                if(second.contains(x) && third.contains(x)) {
                    println("Badge found: " + x)
                    badgeValues += x.code.toPriority()
                }
            }}
        }}
        return badgeValues
    }
}

fun Int.toPriority(): Int {
    if (this >= 97)
        return this-97+1
    return this-65+27
}

fun main() {
    val file = "/home/sean/src/kotlin/advent/day3/input.txt"
    val ruck = Ruck()
    val lines = ruck.getLines(file)
    val value = ruck.getGroupValue(lines)
    println(value)
    //val value = ruck.getValue(lines)

    // manage supplies for elves:
    // contents = string: left and right are equal (so halve it)
    // find the priority value of the letter that is the same
    // pop it onto the stack

    //println("Hello world")
}