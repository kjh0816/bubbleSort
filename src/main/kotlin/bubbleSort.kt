import sun.security.ec.point.ProjectivePoint

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
    var maxDepth = numbers.size - 1

    var raiseCount = 0

    for (depth in maxDepth downTo 1) {
        println("raiseCount : ${++raiseCount}")

        for (i in 0 until depth) {
            println("numbers[$i] vs numbers[${i + 1}]")

            if (numbers[i] > numbers[i + 1]) {
                numbers[i] = numbers[i + 1].also { numbers[i + 1] = numbers[i] } // numbers[i+1]이 더 크면, numbers[i]와 numbers[i+1]을 서로 교체
            }
        }

    }

    println()
}

fun bubbleSortTest(numbers: MutableList<Int>){

    var raiseCount = 0

    for(count in (numbers.size - 1) downTo 1){
        println("raiseCount : ${++raiseCount}")
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