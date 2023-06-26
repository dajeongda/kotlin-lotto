## 1단계 - 문자열 덧셈 계산기

###  기능 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

###  기능 목록
- [x] 입력받은 개수만큼 1-45 사이의 무작위 수를 생성해서 반환한다. - LottoNumberGenerator, LottoMachine
- [x] 구입 금액을 입력하면 구입 금액에 해당하는 로또 개수를 반환한다. - LottoMachine
- [x] 당첨 번호와 일치하는 로또의 숫자 개수를 반환한다. - LottoMatcher
- [x] 결과에 대한 수익률을 계산해 반환한다. - LottoResult
- [x] 로또 1장의 가격(1000)보다 구입 금액이 적다면 RuntimeException 예외가 발생해야 한다. - LottoMachine
- [x] 당첨 번호를 저장할 수 있다. - WinningNumbers
- [x] 2등을 위해 추가 번호를 하나 더 추첨한다. - LottoMatcher