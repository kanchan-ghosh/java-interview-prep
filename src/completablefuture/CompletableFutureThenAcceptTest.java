package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureThenAcceptTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            return "Kanchan here";
        }).thenAccept(name -> {
            System.out.println("Job done " + name);
        });

        System.out.println(future.complete(null));
    }
}
