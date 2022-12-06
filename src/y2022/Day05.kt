package y2022

import readInput

fun main() {
    fun part1(input: List<String>): CharArray {
        val stacks = parseStack(input.subList(0, input.indexOf("") - 1))
        val moves = input.subList(input.indexOf("") + 1, input.size). map { it.extractMove() }

        moves.forEach { (move, from, to) ->
            stacks[to-1].addAll(stacks[from-1].takeLast(move).reversed())
            repeat(move) { if (stacks[from - 1].isNotEmpty()) stacks[from - 1].removeLast() }
        }

        return stacks.mapNotNull { it.lastOrNull() }.toCharArray()
    }

    fun part2(input: List<String>): CharArray {
        val stacks = parseStack(input.subList(0, input.indexOf("") - 1))
        val moves = input.subList(input.indexOf("") + 1, input.size). map { it.extractMove() }

        moves.forEach { (move, from, to) ->
            stacks[to-1].addAll(stacks[from-1].takeLast(move))
            repeat(move) { if (stacks[from - 1].isNotEmpty()) stacks[from - 1].removeLast() }
        }

        return stacks.mapNotNull { it.lastOrNull() }.toCharArray()
    }

    val input = readInput("Day5")
    println(part1(input))
    println(part2(input))
}

fun parseStack(subList: List<String>): List<ArrayDeque<Char>> {
    val stack = mutableListOf<ArrayDeque<Char>>()

    for (i in 1..33 step 4) {
        val deque = ArrayDeque<Char>()
        subList.reversed().forEach {
            if (it[i].isLetter()) {
                deque.add(it[i])
            }
        }
        stack.add(deque)
    }
    return stack
}

private fun String.extractMove(): Triple<Int, Int, Int> {
    val pattern = "move (\\d+) from (\\d+) to (\\d+)".toRegex()

    return pattern.find(this)?.destructured?.let { (x, y, z) ->
        Triple(x.toInt(), y.toInt(), z.toInt())
    } ?: throw IllegalArgumentException("Invalid move command: $this")
}

