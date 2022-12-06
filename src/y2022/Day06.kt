package y2022

import readText

fun main() {
    fun part1(input: String) = 4 + input.windowed(4).indexOfFirst { it.length == it.toSet().size }

    fun part2(input: String) = 14 + input.windowed(14).indexOfFirst { it.length == it.toSet().size }

    val input = readText("Day6")
    println(part1(input))
    println(part2(input))
}
