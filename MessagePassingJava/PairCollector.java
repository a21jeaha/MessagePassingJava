package MessagePassingJava;

import java.util.LinkedList;
import java.util.concurrent.SynchronousQueue;

public class PairCollector implements Runnable {
    
    SynchronousQueue<Integer> numberPairerChannel1;
    SynchronousQueue<Integer> numberPairerChannel2;
    
    LinkedList tempQueue;

    public PairCollector(SynchronousQueue numberPairerChannel1, SynchronousQueue numberPairerChannel2){
        
        this.numberPairerChannel1 = numberPairerChannel1;
        this.numberPairerChannel2 = numberPairerChannel2;
        tempQueue = new LinkedList<>();    
    }

    @Override
    public void run() {
        while (true){
            
        }
        
    }

}
