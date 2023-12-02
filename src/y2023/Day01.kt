package y2023

import println
import readInput

fun main() {
    fun part1(input: List<String>): Int {
        return input.sumOf { extractDigits(it) }
    }

    fun part2(input: List<String>): Int {
        return input.map { convertLettersIntoDigits(it) }.sumOf { extractDigits(it) }
    }

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}

private fun extractDigits(str: String): Int {
    return str.filter { char -> char.isDigit() }.let { "${it.first()}${it.last()}".toInt() }
}

private fun convertLettersIntoDigits(str: String): String {
    return str.replace("oneight", "18")
            .replace("twone", "21")
            .replace("eightwo", "82")
            .replace("one", "1")
            .replace("two", "2")
            .replace("three", "3")
            .replace("four", "4")
            .replace("five", "5")
            .replace("six", "6")
            .replace("seven", "7")
            .replace("eight", "8")
            .replace("nine", "9")
}
