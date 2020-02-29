package blake.threads;
/*******************************************************************
 *  ThreadManager class
 *  Description: This class manages the executor thread pool and
 *  calls all of the threads, waits for them to finish and then
 *  shuts down the pool.
 *******************************************************************/

// Imported Libraries
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadManager {

    public static void main(String[] args) {
        // Start the executor thread pool
        ExecutorService myExecutor = Executors.newFixedThreadPool(5);
        // Create the thread instances
        ThreadWorker tw1 = new ThreadWorker("vVv", "\u001B[31m",25, 1000);
        ThreadWorker tw2 = new ThreadWorker("wWw", "\u001B[32m", 10, 500);
        ThreadWorker tw3 = new ThreadWorker("xXx", "\u001B[33m", 5, 250);
        ThreadWorker tw4 = new ThreadWorker("yYy", "\u001B[34m", 2, 100);
        ThreadWorker tw5 = new ThreadWorker("zZz", "\u001B[35m", 1, 50);
        // Start the thread instances
        myExecutor.execute(tw1);
        myExecutor.execute(tw2);
        myExecutor.execute(tw3);
        myExecutor.execute(tw4);
        myExecutor.execute(tw5);
        // Shutdown the executor thread pool after all threads have terminated
        myExecutor.shutdown();

    }

}