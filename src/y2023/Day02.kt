package y2023

import println
import readInput

// --- Day 2: Cube Conundrum ---
fun main() {
    fun part1(input: List<String>): Int {
        return input.withIndex().sumOf { (id, game) ->
            val hands = game.substringAfter(": ").split("; ")
            if (hands.all { it.possible() }) id + 1 else 0
        }
    }

    fun part2(input: List<String>): Int {
        return input.sumOf {
            val hands = it.substringAfter(": ").split("; ")
            calculatePower(hands)
        }
    }

//    val testInput = readInput("Day02_test")
//    check(part2(testInput) == 2286)

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}

private fun String.possible(): Boolean {
    return split(", ").all {
        val (count, color) = it.split(" ").let { it[0].toInt() to it[1] }
        when (color) {
            "red" -> count <= 12
            "green" -> count <= 13
            "blue" -> count <= 14
            else -> false
        }
    }
}

private fun calculatePower(hands: List<String>): Int {
    val colors = listOf("red", "green", "blue")
    return colors.map { color ->
        hands.maxOf { it.split(", ").firstOrNull { it.endsWith(color) }?.split(" ")?.first()?.toInt() ?: 0 }
    }.reduce(Int::times)
}
