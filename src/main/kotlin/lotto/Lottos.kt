package lotto

import lotto.prize.Prize
import lotto.vo.WinningNumbers

data class Lottos(
    val manualLottos: List<Lotto>,
    val autoGeneratedLottos: List<Lotto>,
) {
    private val lottos = manualLottos + autoGeneratedLottos
    private val totalPrice = Lotto.PRICE * lottos.count()

    val size: Int = lottos.size

    fun playWith(winningNumbers: WinningNumbers): GameResult {
        val prizes = aggregatePrizeWith(winningNumbers)

        return GameResult(
            prizes = prizes,
            paidPrice = totalPrice,
        )
    }

    private fun aggregatePrizeWith(winningNumbers: WinningNumbers): List<Pair<Prize, Int>> {
        val defaultMap = Prize
            .values()
            .associateWith { 0 }
            .toMutableMap()

        return lottos
            .map { it.matchPrizeFrom(winningNumbers) }
            .groupBy { it }
            .mapValuesTo(defaultMap) { (_, value) -> value.size }
            .filter { it.key != Prize.NONE }
            .toList()
    }

    operator fun plus(lottos: Lottos): Lottos {
        return Lottos(
            manualLottos = manualLottos + lottos.manualLottos,
            autoGeneratedLottos = autoGeneratedLottos + lottos.autoGeneratedLottos,
        )
    }
}
