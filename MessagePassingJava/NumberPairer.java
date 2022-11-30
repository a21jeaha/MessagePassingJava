package MessagePassingJava;

import java.util.LinkedList;
import java.util.concurrent.SynchronousQueue;

import javax.sql.rowset.spi.SyncFactory;

public class NumberPairer implements Runnable{
    
    SynchronousQueue<Integer> numberGenerators1;
    SynchronousQueue<Integer> numberGenerators2;
    SynchronousQueue<LinkedList> numberPairerChannel1;
    LinkedList numberPair; 
    SynchronousQueue<Integer> numberPairerChannel2;

    public NumberPairer(SynchronousQueue numberPairerChannel1, SynchronousQueue numberPairerChannel2, SynchronousQueue numberGenerator1, SynchronousQueue numberGenerator2 ){
        this.numberPairerChannel1 = numberPairerChannel1;
        this.numberPairerChannel2 = numberPairerChannel2;
        this.numberGenerators1 = numberGenerator1;
        numberPair = new LinkedList<>();
        this.numberGenerators2 = numberGenerator2;
    }

    @Override
    public void run() {
        
        while(true){
            try {
                numberPair.add(numberGenerators1.take());
                numberPair.add(numberGenerators2.take());

                numberPairerChannel1.put(numberPair);
                //numberPairerChannel1.put(numberGenerators2.take());
                //numberPairerChannel2.put(numberGenerators2.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }   
        
    }
}
