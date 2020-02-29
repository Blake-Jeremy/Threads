package blake.threads;
/*******************************************************************
 *  AtomicVariable class
 *  Description: This class handles all of the atomic variable
 *  calls and operations.
 *******************************************************************/

// Imported Libraries
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    // Create the public static atomic variable
    public static AtomicInteger count = new AtomicInteger(1);
    // Getter
    public static int getValue() {
        return count.get();
    }
    // Reset the value
    public static void resetValue() {
        count.set(1);
    }
    // Setter
    public static void increment() {
        while(true) {
            int existingValue = getValue();
            int newValue = existingValue + 1;
            if(count.compareAndSet(existingValue, newValue)) {
                return;
            }
        }
    }
    // Setter
    public static void decrement() {
        while(true) {
            int existingValue = getValue();
            int newValue = existingValue - 1;
            if(count.compareAndSet(existingValue, newValue)) {
                return;
            }
        }
    }

}
