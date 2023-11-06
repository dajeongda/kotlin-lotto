package lotto

class Lotto {
    constructor() {
        numbers = LOTTO_NUMBER_POOL.shuffled().subList(0, 6)
    }

    constructor(numbers: List<Int>) {
        require(numbers.count() == NUMBER_OF_LOTTO_NUMBER)
        require(numbers.distinct().count() == NUMBER_OF_LOTTO_NUMBER)
        require(numbers.all { it in (MIN_LOTTO_NUMBER) until MAX_LOTTO_NUMBER + 1 })

        this.numbers = numbers
    }

    var numbers: List<Int>
        private set

    companion object {
        private const val NUMBER_OF_LOTTO_NUMBER = 6
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
        private val LOTTO_NUMBER_POOL = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).toList()
    }
}