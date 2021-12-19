fun main() {
    fun part1(input: List<String>): Int {
        val grouped = input.map { it.split(" ") }.groupBy { it.first() }
        val sums = grouped.map { it.value.sumOf { it.last().toInt() } }
        return sums[0] * (sums[1] - sums[2])
    }

    fun part2(input: List<String>): Int {
        var horizontal = 0
        var depth = 0
        var aim = 0

        for (command in input) {
            val (operation, value) = command.split(" ")
            when (operation) {
                "forward" -> {
                    horizontal += value.toInt()
                    depth += aim * value.toInt()
                }
                "down" -> aim += value.toInt()
                "up" -> aim -= value.toInt()
            }
        }
        return horizontal * depth
    }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
