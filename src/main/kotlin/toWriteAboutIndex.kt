fun main() {

    var ascendingArr = arrayOf(3, 0, 1, 8, 7, 2, 5, 4, 6, 9)
    val maxDepth = ascendingArr.size - 1
    for (depth in maxDepth downTo 1) {

        for (i in 0 until depth) {

            if (ascendingArr[i]  > ascendingArr[i + 1]) {
                ascendingArr[i] = ascendingArr[i + 1].also { ascendingArr[i + 1] = ascendingArr[i] } // numbers[i+1]이 더 크면, numbers[i]와 numbers[i+1]을 서로 교체
            }
        }

    }




}