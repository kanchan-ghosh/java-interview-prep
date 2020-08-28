package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class CompletableFutureTestTwo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try{
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "Hello Kanchan";
            }
        });

        String val = future.get();
        System.out.println("Future returned  = " + val);


        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            return "Lambda Hello Kanchan";
        });

        System.out.println("Future lambda code returned = " + future1.get());
    }
}
