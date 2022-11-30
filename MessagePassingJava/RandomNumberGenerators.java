package MessagePassingJava;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;

public class RandomNumberGenerators implements Runnable{

    Random randomNumberGenerator; 
    int randomUpperLimit, randomNumber;  
    SynchronousQueue<Integer> numberGenerator;

    public RandomNumberGenerators(SynchronousQueue numberGenerator){
        this.numberGenerator = numberGenerator; 
    }

    @Override
    public void run() {
        while(true){
            randomUpperLimit = 100; 
            randomNumberGenerator = new Random();
            randomNumber = randomNumberGenerator.nextInt(randomUpperLimit) + 10;
            
            try {
                numberGenerator.put(randomNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
        }
    }
}
