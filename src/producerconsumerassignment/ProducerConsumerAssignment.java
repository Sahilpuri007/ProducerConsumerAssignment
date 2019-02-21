
package producerconsumerassignment;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import resources.Producer;
import resources.Consumer;
/**
 *
 * @author Sahil Puri
 */
public class ProducerConsumerAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        
        Producer p = new Producer();
        Consumer c =new Consumer();
        Thread producer = new Thread(new Producer());
        Thread consumer = new Thread(new Consumer());
        
     
        System.out.println("Press Return to stop.....");
        
        producer.start();
        consumer.start();
        
        producer.join();
        consumer.join();
        
        
        
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        {
        p.shutdown();
        c.shutdown();
        }
        
        
    }
    
}
