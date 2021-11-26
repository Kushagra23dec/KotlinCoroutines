import kotlinx.coroutines.*
import kotlinx.coroutines.launch
import kotlin.concurrent.thread


fun main() = runBlocking {


        println("Main Thread Starts: ${Thread.currentThread().name}")

//    thread{     // Creating a background Thread...
//        println("Fake worker thread: ${Thread.currentThread().name}")
//        Thread.sleep(1000)
//        println("Fake work finished: ${Thread.currentThread().name}")
//
//    }


        GlobalScope.launch {     // Creates a background coroutine that runs on a background thread... // Thread;T1
            println("Fake worker thread: ${Thread.currentThread().name}")
//        Thread.sleep(1000)// instead of sleep use delay
            delay(1000)     // coroutine is suspended but Thread:T1 is free
            println("Fake work finished: ${Thread.currentThread().name}")    // Either Thread;T1 or some other thread.

        }

        // Blocks the current main thread & wait for coroutine to finish (Practically  not a right way to wait)
//    runBlocking {         // creates a coroutine that blocks the current main thread
//        delay(2000) // wait for coroutine to finish (Practically not a right way to wait)
//    }

//        delay(2000) // main thread: wait for coroutine to finish (Practically not a right way to wait)

        mySuspendFun(2000)


        println("Main Thread Ends: ${Thread.currentThread().name}")  // Main thread



}


suspend fun mySuspendFun(time:Long){
    delay(time)
}















/******** GlobalScope.launch() is non-blocking in nature whereas
 *          runBlocking() blocks the thread in which it operates
 */





//fun main() {
//
//
//    runBlocking {           // Creates a coroutine that blocks the current main thread
//
//    println("Main Thread Starts: ${Thread.currentThread().name}")
//
////    thread{     // Creating a background Thread...
////        println("Fake worker thread: ${Thread.currentThread().name}")
////        Thread.sleep(1000)
////        println("Fake work finished: ${Thread.currentThread().name}")
////
////    }
//
//
//    GlobalScope.launch {     // Creates a background coroutine that runs on a background thread... // Thread;T1
//        println("Fake worker thread: ${Thread.currentThread().name}")
////        Thread.sleep(1000)// instead of sleep use delay
//        delay(1000)     // coroutine is suspended but Thread:T1 is free
//        println("Fake work finished: ${Thread.currentThread().name}")    // Either Thread;T1 or some other thread.
//
//    }
//
//    // Blocks the current main thread & wait for coroutine to finish (Practically  not a right way to wait)
////    runBlocking {         // creates a coroutine that blocks the current main thread
////        delay(2000) // wait for coroutine to finish (Practically not a right way to wait)
////    }
//
//        delay(2000) // main thread: wait for coroutine to finish (Practically not a right way to wait)
//
//    println("Main Thread Ends: ${Thread.currentThread().name}")  // Main thread
//
//
//}
//}
//
///******** GlobalScope.launch() is non-blocking in nature whereas
// *          runBlocking() blocks the thread in which it operates
// */