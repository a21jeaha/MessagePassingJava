package MessagePassingJava;

import java.util.concurrent.SynchronousQueue;

import javax.sql.rowset.spi.SyncFactory;

public class NumberPairer implements Runnable{
    
    SynchronousQueue<Integer> numberGenerators1;
    SynchronousQueue<Integer> numberGenerators2;
    SynchronousQueue<Integer> numberPairerChannel1;
    SynchronousQueue<Integer> numberPairerChannel2;

    public NumberPairer(SynchronousQueue numberPairerChannel1, SynchronousQueue numberPairerChannel2, SynchronousQueue numberGenerator1, SynchronousQueue numberGenerator2 ){
        this.numberPairerChannel1 = numberPairerChannel1;
        this.numberPairerChannel2 = numberPairerChannel2;
        this.numberGenerators1 = numberGenerator1;
        this.numberGenerators2 = numberGenerator2;
    }

    @Override
    public void run() {
        
        while(true){
            try {
                System.out.println(numberGenerators1.take());
                System.out.println(numberGenerators2.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }   
        
    }
}
