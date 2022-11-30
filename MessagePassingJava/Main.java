package MessagePassingJava;
import java.util.LinkedList;
import java.util.concurrent.SynchronousQueue;


public class Main{


    public static void main(String[] args) {    
        
        SynchronousQueue<Integer> numberGenerators1 = new SynchronousQueue<>();
        SynchronousQueue<Integer> numberGenerators2 = new SynchronousQueue<>();
        SynchronousQueue<LinkedList> numberPairerChannel1 = new SynchronousQueue<>();
        SynchronousQueue<Integer> numberPairerChannel2 = new SynchronousQueue<>();
        SynchronousQueue<LinkedList> pairCollecton = new SynchronousQueue<>();

        RandomNumberGenerators randomNumberGenerators1 = new RandomNumberGenerators(numberGenerators1);
        RandomNumberGenerators randomNumberGenerators2 = new RandomNumberGenerators(numberGenerators2);
        NumberPairer numberPairer = new NumberPairer(numberPairerChannel1, numberPairerChannel2, numberGenerators1, numberGenerators2);
        PairCollector pairCollector = new PairCollector(numberPairerChannel1, pairCollecton);

        Thread thread1 = new Thread(randomNumberGenerators1);
        Thread thread2 = new Thread(randomNumberGenerators2);
        Thread thread3 = new Thread(numberPairer);
        
        thread1.start();
        thread2.start();
        thread3.start();

    }

}

    