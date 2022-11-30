package MessagePassingJava;

import java.util.LinkedList;
import java.util.concurrent.SynchronousQueue;

public class PairCollector implements Runnable {
    
    SynchronousQueue<Integer> numberPairerChannel1;
    // SynchronousQueue<Integer> numberPairerChannel2;
    SynchronousQueue<LinkedList> pairCollector; 

    LinkedList tempQueue1;
    // LinkedList tempQueue2;
    int linkedListSize;

    public PairCollector(SynchronousQueue numberPairerChannel1, SynchronousQueue pairCollection){
        
        this.numberPairerChannel1 = numberPairerChannel1;
        // this.numberPairerChannel2 = numberPairerChannel2;
        this.pairCollector = pairCollector;
        tempQueue1 = new LinkedList<>();
        // tempQueue2 = new LinkedList<>();
        linkedListSize = 0; 
    }

    @Override
    public void run() {
        while (true){
            while (linkedListSize<11){
                // try {
                //     tempQueue1.addLast(numberPairerChannel1.take());
                // } catch (InterruptedException e) {
                //     e.printStackTrace();
                // }
                // try {
                //     tempQueue2.addLast(numberPairerChannel2.take());
                // } catch (InterruptedException e) {
                //     e.printStackTrace();
                // }

                try {
                    tempQueue1.addLast(numberPairerChannel1.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }    

                linkedListSize++; 
            }

            try {
                pairCollector.put(tempQueue1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }

}
