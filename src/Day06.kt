private const val DAY = "06"
private const val PART_1_CHECK = 7
private const val PART_2_CHECK = 19

fun main() {
    fun part1(input: List<String>): Int? {
        input[0].windowed(4).map { it.toSet() }.forEachIndexed { index, window -> if (window.size == 4) return index + 4 }
        return null
    }

    fun part2(input: List<String>): Int? {
        input[0].windowed(14).map { it.toSet() }.forEachIndexed { index, window -> if (window.size == 14) return index + 14 }
        return null
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day${DAY}_test")
    check(part1(testInput).also { println("Part 1 check: $it") } == PART_1_CHECK)
    check(part2(testInput).also { println("Part 2 check: $it") } == PART_2_CHECK)


    val input = readInput("Day${DAY}")
    println("Part 1 solution: ${part1(input)}")
    println("Part 2 solution: ${part2(input)}")
}
