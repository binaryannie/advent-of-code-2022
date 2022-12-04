private const val DAY = "04"
private const val PART_1_CHECK = 2
private const val PART_2_CHECK = 4

fun inputToRanges(input:List<String>):List<List<Set<Int>>> {
    return input
        .map {
            it
                .split(',', '-')
                .map { zone -> zone.toInt() }
                .chunked(2)
                .map { pair -> pair[0].rangeTo(pair[1]).toSet() }
        }
}

fun main() {
    fun part1(input: List<String>): Int {
        val ranges = inputToRanges(input)
        val intersects = ranges.map { it[0].intersect(it[1]) }

        return ranges.zip(intersects).filter { (pair, intersect) -> pair[0] == intersect || pair[1] == intersect }.size
    }

    fun part2(input: List<String>): Int {
        val ranges = inputToRanges(input)
        val intersects = ranges.map { it[0].intersect(it[1]) }

        return intersects.filterNot { it.isEmpty() }.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day${DAY}_test")
    check(part1(testInput).also { println("Part 1 check: $it") } == PART_1_CHECK)
    check(part2(testInput).also { println("Part 2 check: $it") } == PART_2_CHECK)


    val input = readInput("Day${DAY}")
    println("Part 1 solution: ${part1(input)}")
    println("Part 2 solution: ${part2(input)}")
}
