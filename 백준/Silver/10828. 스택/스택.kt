import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val n = br.readLine().toInt()
    val stack = ArrayDeque<Int>()

    repeat(n) {
        val command = br.readLine().split(" ")
        when (command[0]) {
            "push" -> {
                stack.addLast(command[1].toInt())
            }
            "pop" -> {
                sb.append(stack.removeLastOrNull() ?: -1).append('\n')
            }
            "size" -> {
                sb.append(stack.size).append('\n')
            }
            "empty" -> {
                sb.append(if (stack.isEmpty()) 1 else 0).append('\n')
            }
            "top" -> {
                sb.append(stack.lastOrNull() ?: -1).append('\n')
            }
        }
    }
    print(sb)
}