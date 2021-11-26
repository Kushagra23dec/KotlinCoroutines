import kotlin.concurrent.thread

fun main(){

    println("Main Thread Starts: ${Thread.currentThread().name}")

    thread{     // Creating a background Thread...
        println("Fake worker thread: ${Thread.currentThread().name}")
        Thread.sleep(1000)
        println("Fake work finished: ${Thread.currentThread().name}")

    }

    println("Main Thread Ends: ${Thread.currentThread().name}")


}