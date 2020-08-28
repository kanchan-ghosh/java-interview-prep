package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * ThenCompose is used to link two or more dependent CompletableFuture
 * where output of one future is passed as input for next future, to form a chain.
 */
public class CompletableFutureThenComposeTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFutureThenComposeTest test = new CompletableFutureThenComposeTest();
        CompletableFuture<CreditRating> kanchan =
                test.getUserDetails("kanchan").thenCompose(user -> test.getCreditRating(user));
        System.out.println(kanchan.get().rating);

    }

    public CompletableFuture<User> getUserDetails(String name) {
        return CompletableFuture.supplyAsync(() -> new User(name, String.valueOf(name.hashCode())));
    }

    public CompletableFuture<CreditRating> getCreditRating(User user) {
        return CompletableFuture.supplyAsync(() -> new CreditRating(user, 8.8f));
    }
}

class CreditRating {
    User user;
    Float rating;

    public CreditRating(User user, Float rating) {
        this.user = user;
        this.rating = rating;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }
}

class User {
    private String name;
    private String age;

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
