private const val DAY = "01"
private const val PART_1_CHECK = 0
private const val PART_2_CHECK = 0

fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day${DAY}_test")
    check(part1(testInput).also { println("Part 1 check: $it") } == PART_1_CHECK)
    check(part2(testInput).also { println("Part 2 check: $it") } == PART_2_CHECK)


    val input = readInput("Day${DAY}")
    println("Part 1 solution: ${part1(input)}")
    println("Part 2 solution: ${part2(input)}")
}
