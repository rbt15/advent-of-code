package y2022

import readInput

fun main() {
    val input = readInput("input")

    val totals = mutableListOf<Int>()
    var acc = 0
    input.forEachIndexed { i, it ->
        if (it.isNotEmpty()) {
            acc += it.toInt()
            if (input.lastIndex == i) totals.add(acc) // last line
        }
        else {
            totals.add(acc)
            acc = 0
        }
    }
    // -------  PART 1 --------
    println(totals.maxOrNull()) // 67658

    // -------  PART 2 --------
    println(totals.sortedBy { it }.takeLast(3).sum()) // 200158
}