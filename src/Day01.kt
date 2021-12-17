fun main() {
    fun part1(input: List<Int>): Int = input.windowed(2).count { it[0] < it[1] }

    fun part2(input: List<Int>): Int {
        val sums = input.windowed(3) { window -> window.sum() }
        return sums.windowed(2).count { it[0] < it[1] }
    }


    val input = readInput("Day01").map { it.toInt() }
    println(part1(input))
    println(part2(input))
}
