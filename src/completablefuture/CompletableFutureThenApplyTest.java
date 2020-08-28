package completablefuture;

import java.util.concurrent.*;

public class CompletableFutureThenApplyTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Returning from first future " + Thread.currentThread().getName());
            return "Kanchan";
        }, executorService);

        CompletableFuture<String> future1 = future.thenApplyAsync(name -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Returning from second future " + Thread.currentThread().getName());
            return  "Hello " + name;
        }).thenApply(name -> {
            return "Again " + name;
        });

        System.out.println(future1.get());
        executorService.shutdown();
    }
}
