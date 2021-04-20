import java.util.*

fun main() {


    // 회원관리 프로그램 만들기 + bubbleSorting으로 나이에 대한 오름차순/내림차순

//    회원 수 : 2[엔터]
//    = 2명의 회원 정보를 입력합니다. =
//    1번째 회원의 이름 : 홍길동[엔터]
//    1번째 회원의 나이 : 22[엔터]
//    1번째 회원의 성별(M/W) : m[엔터]
//    1번 회원의 정보가 등록되었습니다.
//    2번째 회원의 이름 : 홍길순[엔터]
//    2번째 회원의 나이 : 23[엔터]
//    2번째 회원의 성별(M/W) : w[엔터]
//    2번 회원의 정보가 등록되었습니다.
//    = 입력하신 회원 리스트 =
//        번호 / 이름  / 나이 / 성별
//    1   / 홍길동 / 22  / 남자
//    2   / 홍길순 / 23  / 여자

    // 부가 기능
    // 1) 나이의 오름차순 정렬
    // 2) 나이의 내림차순 정렬
    // >> 이미 저장된 회원의 정보(id순)는 유지하도록,
    //    clone한 다른 하나의 배열에 나이의 오름차순으로 따로 정렬/저장하였음.
    // clone한 배열을 나이의 오름차순으로 정렬된 배열로 만드는 함수(1회만 실행하면 됨), 그대로 호출하는(오름차순) 함수,
    // 내림차순으로 호출하는 함수를 만드는 게 베스트이지만 연습을 위해서 내림차순으로 저장하는 함수도 만듦.

    // ※ bubbleSort 방식으로 오름차순 비교 시, depth = maxDepth = size-1 이지만, 조건절에서
    //    비교를 할 때, i(depth)와 i(depth)+1을 비교하므로, 모든 인덱스를 조건절에서 비교하게 되는 것이다.

    println("=== 프로그램 시작 ===")

    println("회원 수를 입력해주세요.")
    val memberCount: Int = readLine()!!.trim().toInt()
    val members: Array<Member?> = Array<Member?>(memberCount){null}

    println("${memberCount}명의 회원정보를 입력합니다.")

    for(i in 0 until memberCount){

        val id: Int = i + 1

        println("${i + 1}번째 회원의 이름을 입력해주세요.")
        val name: String = readLine()!!.trim()
        println("${i + 1}번째 회원의 나이를 입력해주세요.")
        val age: Int = readLine()!!.trim().toInt()
        println("${i + 1}번째 회원의 성별을 입력해주세요.")
        val sex: Char = readLine()!!.trim()[0]

        val member = Member(id, name, age, sex)
        members[i] = member

        println("${i + 1}번째 회원의 정보가 등록되었습니다.")
    }

    println("입력된 회원 리스트")
    println("번호 / 이름/ 나이 / 성별")

    for(member in members){

        println("${member?.id} / ${member?.name} / ${member?.age} / ${member?.getSexKo()}")

    }

    println("\n나이가 많은 순서로 정렬 - 오름차순")
    println("번호 / 이름/ 나이 / 성별")
    getAscendingSortByAge(members)

    println("\n나이가 많은 순서로 정렬 - 내림차순")
    println("번호 / 이름/ 나이 / 성별")
    getDescendingSortByAge(members)





    println("=== 프로그램 종료 ===")
}

data class Member(
    val id: Int,
    val name: String,
    val age: Int,
    val sex: Char
){
    fun getSexKo(): String = when(sex){
        'f'  -> "여자"
        else -> "남자"
    }





}

fun getAscendingSortByAge(ageOrder: Array<Member?>){

    var ascendingArr = ageOrder.clone()
    val maxDepth = ascendingArr.size - 1
    

    // bubbleSort
    // maxDepth가 비교검사가 필요한 위치를 배열 size에서 내려가면서 찍어준다

    for (depth in maxDepth downTo 1) {

        for (i in 0 until depth) {

            if (ascendingArr[i]!!.age  > ascendingArr[i + 1]!!.age) {
                ascendingArr[i] = ascendingArr[i + 1].also { ascendingArr[i + 1] = ascendingArr[i] } // numbers[i+1]이 더 크면, numbers[i]와 numbers[i+1]을 서로 교체
            }
        }

    }

    

    for(member in ascendingArr){

        println("${member?.id} / ${member?.name} / ${member?.age} / ${member?.getSexKo()}")

    }

}

fun getDescendingSortByAge(ageOrder: Array<Member?>){

    var descendingArr = ageOrder.clone()

    val maxDepth:Int = descendingArr.size - 1

    for (depth in maxDepth downTo 1) {

        for (i in 0 until depth) {

            if (descendingArr[i]!!.age  < descendingArr[i + 1]!!.age) {
                descendingArr[i] = descendingArr[i + 1].also { descendingArr[i + 1] = descendingArr[i] } // numbers[i+1]이 더 크면, numbers[i]와 numbers[i+1]을 서로 교체
            }
        }

    }


        for(member in descendingArr){
            println("${member!!.id} / ${member!!.name} / ${member!!.age} / ${member.getSexKo()}")
        }

}