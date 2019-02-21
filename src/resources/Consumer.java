
package resources;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sahil Puri
 */
public class Consumer extends Storage implements Runnable{

     private boolean running = true;
    @Override
    public void run() {
        while(running)
        {
             synchronized(this)
             {
                 try {
                     int value=0;
                     while(producedItemBuffer.isEmpty())
                         wait();
                     Iterator listItr = producedItemBuffer.iterator();
                     while(listItr.hasNext()){
                         value = (Integer) listItr.next();
                         listItr.remove();
                     }
                     System.out.println("Consumer consumed Item: "+ value);
                     
                     notify();
                     
                     Thread.sleep(1000);
                 } catch (InterruptedException ex) {
                      ex.printStackTrace();
                 }
             }
        }
    }
     public void shutdown(){
         running = false;
    }
}
