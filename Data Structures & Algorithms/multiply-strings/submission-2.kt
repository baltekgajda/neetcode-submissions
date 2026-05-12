class Solution {
    fun multiply(num1: String, num2: String): String {
        if(num1 == "0" || num2 == "0") {
            return "0"
        }

        val result = IntArray(num1.length + num2.length) {0}

        for(i in 0 until num1.length) {
            val num1No = num1[num1.length - i - 1].digitToInt()

            for(j in 0 until num2.length) {
                val num2No = num2[num2.length - j - 1].digitToInt()
                val multi = num1No * num2No
                result[i+j] += multi % 10   //kazde moze byc wieksze niz 10
                result[i+j+1] += multi / 10
            }
        }

        for(i in 0 until result.size - 1) {
            val temp = result[i]
            result[i] = temp % 10
            result[i+1] += temp / 10
        }

        result.reverse()

        var i = 0
        while(i < result.size) {
            if(result[i] != 0) {
                break
            }
            i++
        }

        return result.toList().subList(i, result.size).joinToString("")
    }
}
