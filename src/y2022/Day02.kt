package y2022

import readInput

fun main() {
    val input = readInput("Day2")
    // val testInput = listOf("A Y", "B X", "C Z")

    val rounds = input.map { it.split(' ').first() to it.split(' ').last() }
    val score1 = rounds.sumOf { part1(it) }
    val score2 = rounds.sumOf { part2(it) }
    println("$score1, $score2")
}

fun part1(round: Pair<String, String>): Int {
    val p1 = round.first.toMove()
    val p2 = round.second.toMove()
    return p2.toScore() + getWinBonus(p1, p2)
}

fun part2(round: Pair<String, String>): Int {
    val p1 = round.first.toMove()
    val p2 = when(round.second.toResult()) {
        "Lose" -> if (p1 == "Scissors") "Paper" else if (p1 == "Rock") "Scissors" else "Rock"
        "Draw" -> p1
        "Win" -> if (p1 == "Rock") "Paper" else if (p1 == "Paper") "Scissors" else "Rock"
        else -> throw Exception()
    }
    return p2.toScore() + getWinBonus(p1, p2)
}

fun getWinBonus(p1: String, p2: String): Int {
    if (p1 == p2) return 3

    return when(p2) {
        "Rock" -> if (p1 == "Scissors") 6 else 0
        "Scissors" -> if (p1 == "Paper") 6 else 0
        "Paper" -> if (p1 == "Rock") 6 else 0
        else -> 0
    }
}

fun String.toMove(): String = when(this) {
    "A", "X" -> "Rock"
    "B", "Y" -> "Paper"
    "C", "Z" -> "Scissors"
    else -> throw Exception()
}

fun String.toResult(): String = when(this) {
    "X" -> "Lose"
    "Y" -> "Draw"
    "Z" -> "Win"
    else -> throw Exception()
}

fun String.toScore(): Int = when(this) {
    "Rock" -> 1
    "Paper" -> 2
    "Scissors" -> 3
    else -> throw Exception()
}
