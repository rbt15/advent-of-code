package y2022

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        val pairs = input.map { it.split(',') }

        return pairs.count {(elfOne, elfTwo) ->
            val (first, second) = elfOne.split('-').map { it.toInt() }
            val (third, fourth) = elfTwo.split('-').map { it.toInt() }

            (first <= third && second >= fourth) || (first >= third && second <= fourth)
        }
    }

    fun part2(input: List<String>): Int {
        val pairs = input.map { it.split(',') }

        return pairs.count {(elfOne, elfTwo) ->
            val (first, second) = elfOne.split('-').map { it.toInt() }
            val (third, fourth) = elfTwo.split('-').map { it.toInt() }

            IntRange(first, second).intersect(IntRange(third, fourth)).isNotEmpty()
        }
    }

    val input = readInput("Day4")
    println(part1(input))
    println(part2(input))
}
