package lotto.domain

data class LottoTicket(
    val lottoNumbers: List<Int>
) {
    init {
        require(lottoNumbers.size == LOTTO_SIZE) { "로또 번호는 6개로 구성되어야 해요" }
    }

    fun matchCount(winningNumber: WinningNumber): Int {
        return lottoNumbers.count { lottoNumber -> winningNumber.hasNumber(lottoNumber) }
    }

    companion object {
        const val LOTTO_SIZE = 6
    }
}