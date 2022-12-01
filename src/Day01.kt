fun main() {
    fun part1(input: List<String>): Int {
        var maxCalories = 0
        var currentCalories = 0
        input.forEach {
            if (it.isBlank()) {
                if(currentCalories > maxCalories) maxCalories = currentCalories
                currentCalories = 0
            } else {
                currentCalories += it.toInt()
            }
        }
        if(currentCalories > maxCalories) maxCalories = currentCalories
        return maxCalories
    }

    fun part2(input: List<String>): Int {
        var elfCalories = mutableListOf<Int>()
        var currentCalories = 0

        input.forEach {
            if (it.isBlank()) {
                elfCalories.add(currentCalories)
                currentCalories = 0
            } else {
                currentCalories += it.toInt()
            }
        }

        elfCalories.add(currentCalories)

        elfCalories.sortDescending()

        return elfCalories.take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)


    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
