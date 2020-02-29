package blake.threads;
/*******************************************************************
 *  ThreadWorker class
 *  Description: This class does all of the thread work, and is
 *  called from the Executor manager.
 *******************************************************************/

// Imported Libraries
import java.util.Random;

public class ThreadWorker extends Thread implements Runnable {
    // Local class variables
    private String task;
    private String color;
    private int loop;
    private int sleep;
    private int rand;

    public ThreadWorker(String task, String color, int loop, int sleep){
        this.task = task;
        this.color = color;
        this.loop = loop;
        this.sleep = sleep;
        Random random = new Random();
        this.rand = random.nextInt(1000);
    }

    @Override
    public void run() {
        // Thread start
        System.out.print("< New thread started! Task: " + task + " Sleep: " + sleep + " Loop: " + loop + " Random: " + rand + " >\n");
        // Atomic variable setter call
        AtomicCounter.decrement();
        // Random worker loop
        for (int loop = 1; loop< rand; loop++) {
            if (loop % loop == 0) {
                AtomicCounter.increment();
                // Limit the atomic variable to 100 to stay on the screen
                if (AtomicCounter.getValue() > 100) {
                    System.out.print("\n");
                    AtomicCounter.resetValue();
                }
                // Show worker loop progress to display
                System.out.print(color + "█" + "\u001B[0m");
                //System.out.print(AtomicCounter.getValue());
                // Sleep for some time
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    System.err.println(e.toString());
                }
            }
        }
        // Display to screen when worker loop is complete
        System.out.print("< Stopped at " + AtomicCounter.getValue() + " >");
        System.out.print("\n");
        System.out.println("< Task " + task + " is done >");
        System.out.print(color + "█" + "\u001B[0m");
        // Start the atomic variable over
        AtomicCounter.resetValue();
    }
}
