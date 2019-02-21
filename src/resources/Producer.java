
package resources;


import static resources.Storage.producedItemBuffer;

/**
 *
 * @author Sahil Puri
 */
public class Producer extends Storage implements Runnable{
    
    private boolean running = true;
    int value=1;
    
    @Override
    public void run() {
        while(running){
        synchronized(this){
            try {
                while(producedItemBuffer.size() == 20)
                    wait();
                
                System.out.println("Producer produced Item: "+ value);
                
                producedItemBuffer.add(value);
                value++;
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
    
