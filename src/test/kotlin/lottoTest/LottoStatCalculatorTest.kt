package lottoTest

import lotto.Lotto
import lotto.LottoMachine
import lotto.LottoStatCalculator
import lotto.LottoStatResult
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class LottoStatCalculatorTest {

    @ParameterizedTest
    @MethodSource("generateLottoStatArguments")
    fun `당첨 통계 계산`(winningLotto: Lotto, input: List<Lotto>, expected: LottoStatResult) {
        val lottoStatCalculator = LottoStatCalculator(winningLotto)

        assertEquals(expected, lottoStatCalculator.getStat(input))
    }

    companion object {
        @JvmStatic
        fun generateLottoStatArguments(): List<Arguments> {
            return listOf(
                Arguments.of(
                    Lotto(numbers = listOf(1, 2, 3, 4, 5, 6)),
                    listOf(
                        Lotto(numbers = listOf(4, 5, 6, 10, 11, 12)),
                    ),
                    LottoStatResult(
                        firstCount = 0,
                        thirdCount = 0,
                        fourthCount = 0,
                        fifthCount = 1,
                        purchaseAmount = 1 * LottoMachine.LOTTO_PRICE,
                    )
                ),
                Arguments.of(
                    Lotto(numbers = listOf(1, 2, 3, 4, 5, 6)),
                    listOf(
                        Lotto(numbers = listOf(1, 2, 3, 4, 5, 6)),
                        Lotto(numbers = listOf(1, 2, 3, 4, 5, 7)),
                        Lotto(numbers = listOf(1, 2, 3, 4, 7, 8)),
                    ),
                    LottoStatResult(
                        firstCount = 1,
                        thirdCount = 1,
                        fourthCount = 1,
                        fifthCount = 0,
                        purchaseAmount = 3 * LottoMachine.LOTTO_PRICE,
                    )
                ),
            )
        }
    }
}