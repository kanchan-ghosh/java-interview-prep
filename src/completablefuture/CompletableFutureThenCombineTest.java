package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureThenCombineTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("Retrieving weight");
        CompletableFuture<Double> weightInKGFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 65.0;
        });

        System.out.println("Retrieving height");
        CompletableFuture<Double> heightInCMFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(8);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 177.8;
        });

        System.out.println("Calculating BMI");
        CompletableFuture<Double> bmiFuture =
                weightInKGFuture.thenCombine(heightInCMFuture, (weightInKg, heightInCM) -> {
                    Double heightInMeter = heightInCM / 100;
                    return weightInKg / (heightInMeter * heightInMeter);
                }).exceptionally( ex -> {
                    System.out.println("Exception occured " + ex.getMessage());
                    return null;
                });

        System.out.println("Calculated BMI  = " + bmiFuture.get());
    }
}
