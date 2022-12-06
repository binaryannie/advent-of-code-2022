private const val DAY = "06"
private const val PART_1_CHECK = 7
private const val PART_2_CHECK = 19

fun messageSeeker(input: String, windowSize: Int): Int {
    return input.windowed(windowSize).map { it.toSet() }.indexOfFirst { it.size == windowSize } + windowSize
}

fun main() {
    fun part1(input: List<String>): Int {
        return messageSeeker(input[0], 4)
    }

    fun part2(input: List<String>): Int {
        return messageSeeker(input[0], 14)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day${DAY}_test")
    check(part1(testInput).also { println("Part 1 check: $it") } == PART_1_CHECK)
    check(part2(testInput).also { println("Part 2 check: $it") } == PART_2_CHECK)


    val input = readInput("Day${DAY}")
    println("Part 1 solution: ${part1(input)}")
    println("Part 2 solution: ${part2(input)}")
}
