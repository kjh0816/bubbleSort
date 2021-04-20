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

    bubbleSort2(numbers)

    print("오름차순 정렬 결과 : ")
    printNumbers2(numbers)

    print("내림차순 정렬 결과 : ")
    printNumbersReversed2(numbers)

    println("== 프로그램 끝 ==")
}

fun bubbleSort2(numbers: MutableList<Int>) {
    val lastIndex = numbers.size - 1
    var raiseCount = 0

    var depth = lastIndex
    // loop1@ while 와 같이 반복문에 이름을 지정할 수 있다.
    loop1@ while (depth >= 1) {
        println("raiseCount : ${++raiseCount}, depth : $depth")

        for (i in 0 until depth) {
            println("numbers[$i] vs numbers[${i + 1}]")

            if (i == depth - 1 && numbers[i] < numbers[i + 1]) {
                // 위 조건이 부합되면 한번에 2칸씩 depth 를 깍는다.
                // 그리고 while 문을 다시 시작한다.(while 문의 이번 턴을 바로 끝내고 다음 턴으로 넘어간다.)
                depth -= 2
                continue@loop1
            }

            if (numbers[i] > numbers[i + 1]) {
                numbers[i] = numbers[i + 1].also { numbers[i + 1] = numbers[i] }
            }
        }

        depth--
    }
}

fun printNumbers2(numbers: List<Int>) {
    numbers.forEach {
        print("$it ")
    }
    println()
}

fun printNumbersReversed2(numbers: List<Int>) {
    numbers.withIndex().reversed().forEach {
        print("${it.value} ")
    }
    println()
} 