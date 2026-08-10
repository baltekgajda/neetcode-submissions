class Solution {
    fun simplifyPath(path: String): String {
        val dirs = path.split("/").filter { it.length != 0  && it != "." }
        val stack = ArrayDeque<String>()
        for(dir in dirs) {
            if(dir == "..") {
                if(stack.isNotEmpty()) {
                    stack.removeLast()
                }
            } else {
                stack.addLast(dir)
            }
        }

        return "/" + stack.toList().joinToString("/")
    }
}
