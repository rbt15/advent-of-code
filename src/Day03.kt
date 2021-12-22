fun main() {
    fun part1(input: List<String>): Int {
        val sb = StringBuilder()
        for (i in 0..11) {
            val freqs = input.groupingBy { it[i] }
                .eachCount()
                .toList()
                .sortedBy { (key, _) -> key }

            if (freqs[0].second > 500) sb.append("0") else sb.append("1")
        }
        val gamma = sb.toString().toInt(2)
        val epsilon = 4096 + gamma.inv()
        return gamma * epsilon
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
