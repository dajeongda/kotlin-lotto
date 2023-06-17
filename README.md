# kotlin-lotto

---
# 문자열 계산기
## 기능 요구사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환  
(예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 
- 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.  
예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다. 
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.
## 기능 명세서
- [x] 기본 구분자는 ','와 ':' 이다 - Delimiter 
- [x] 커스텀 구분자를 지정 (//와 \n 사이에 위치하는 문자를 구분자로 사용) - ExpressionParser 
- [x] ',', ':' 구분자를 기준으로 분리 - ExpressionParser
- [x] 숫자 이외의 값 or 음수 전달하는 경우 RunTimeException 발생 - ExpressionParser
- [x] 분리한 숫자를 합을 반환 - Calculator
---
# 로또 (자동)
## 기능 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다. 
- 로또 1장의 가격은 1000원이다.
```
구입금액을 입력해 주세요.
14000
14개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
```
## 기능 명세서
- [x] 로또 구입 금액을 입력 - InputView
- [x] 로또 번호는 6자리 - Lottery
- [x] 1이상 45이하의 정수 - Lottery
- [x] 다른 로또와 겹치는 갯수를 구한다 - Lottery
- [x] 로또는 중복된 숫자가 있으면 안된다 - Lottery
- [x] 구입 금액에 해당하는 로또 발급 - LottoMachine
- [x] 로또 생성 - LottoMachine 
- [x] 지난 주 당첨 번호 입력 - InputView
- [x] 구매한 로또 출력 - OutputView
- [x] 통계 기능 - ProfitAnalyzer
- [x] 수익률 구하기 - ProfitAnalyzer
  - [x] 총 상금의 합을 구한다 - PrizeStatics
  - [x] 각 등수의 갯수를 저장 - PrizeStatics
- [x] 통계 출력 및 수익률 출력 - OutputView


