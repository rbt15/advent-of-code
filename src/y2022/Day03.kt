package y2022

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        val rucksacks = input.map { it.chunked(it.length / 2) }
        val failedItems = rucksacks.map { findFailureItem(it) }
        return failedItems.sumOf { it.toPriority() }
    }

    fun part2(input: List<String>): Int {
        val groups = input.chunked(3)

        return groups.sumOf {
            val (first, second, third) = it
            val commonChar = first.toSet().intersect(second.toSet()).intersect(third.toSet()).first()
            commonChar.toPriority()
        }
    }

    val input = readInput("Day3")
    println(part1(input))
    println(part2(input))
}

fun Char.toPriority(): Int {
    val lowerChars = "abcdefghijklmnopqrstuvwxyz"
    val alphabet = lowerChars.plus(lowerChars.uppercase())

    return alphabet.indexOf(this) + 1
}

fun findFailureItem(rucksack: List<String>): Char {
    val (firstCompartment, secondCompartment) = rucksack
    return firstCompartment.toSet().intersect(secondCompartment.toSet()).first()
}