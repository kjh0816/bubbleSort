/*
== 프로그램 시작 ==
숫자(띄워쓰기로 구분) : 3 0 1 8 7 2 5 4 6 9
오름차순 정렬 결과 : 0 1 2 3 4 5 6 7 8 9
내림차순 정렬 결과 : 9 8 7 6 5 4 3 2 1 0
== 프로그램 끝 ==
*/

fun main() {
    println("== 프로그램 시작 ==")
    print("숫자(띄워쓰기로 구분) : ")
    val numbers = readLine()!!.trim().split(" ").map { it.toInt() }.toMutableList()

    bubbleSort(numbers)

    print("오름차순 정렬 결과 : ")
    printNumbers(numbers)

    print("내림차순 정렬 결과 : ")
    printNumbersReversed(numbers)

    println("== 프로그램 끝 ==")
}

fun bubbleSort(numbers: MutableList<Int>) {
    val lastIndex = numbers.size - 1
    var raiseCount = 0

    var depth = lastIndex
    while (depth >= 1) {
        println("raiseCount : ${++raiseCount}, depth : $depth")

        for (i in 0 until depth) {
            println("numbers[$i] vs numbers[${i + 1}]")

            if (i == depth - 1 && numbers[i] < numbers[i + 1]) {
                // 위 조건이 depth를 1 깍고 부합되면 for문을 종료한다.
                // for 문 밑에서 depth-- 를 한번 더 만나게 되기 때문에
                // 결과적으로는 depth -= 2 가 된다.
                depth--
                break
            }

            if (numbers[i] > numbers[i + 1]) {
                numbers[i] = numbers[i + 1].also { numbers[i + 1] = numbers[i] }
            }
        }

        depth--
    }
}

fun printNumbers(numbers: List<Int>) {
    numbers.forEach {
        print("$it ")
    }
    println()
}

fun printNumbersReversed(numbers: List<Int>) {
    numbers.withIndex().reversed().forEach {
        print("${it.value} ")
    }
    println()
}