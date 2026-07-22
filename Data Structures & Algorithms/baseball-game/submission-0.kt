class Solution {
    fun calPoints(operations: Array<String>): Int {
        val record = mutableListOf<Int>()
        for(op in operations) {
            when(op) {
                "+" -> {
                    val new = record[record.size - 1] + record[record.size - 2]
                    record.add(new)
                }
                "D" -> {
                    val new = record[record.size - 1] * 2
                    record.add(new)
                }
                "C" -> {
                    record.removeLast()
                }
                else -> {
                    record.add(op.toInt())
                }
            }
        }

        return record.sum()
    }
}
