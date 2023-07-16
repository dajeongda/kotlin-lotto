package lotto.ui

object InputView {
    fun requestMoney(): Int {
        println("구입 금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun requestWinningNumbers(): String {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln()
    }

    fun requestBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readln().toInt()
    }
}