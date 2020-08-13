package multithreading.forkjoinpool;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class ForlJoinPoolMain {

    public static void main(String[] args) {

        // create a ForkJoinPool using default constructor
        ForkJoinPool pool  = new ForkJoinPool();

        // create 3 FolderProcessor tasks, each with different path
        FolderProcessor movies = new FolderProcessor("D:\\video\\pdata", "mp4");
        FolderProcessor music = new FolderProcessor("D:\\Music" , "mp3");
        FolderProcessor pics = new FolderProcessor("D:\\picture", "jpg");

        pool.execute(movies);
        pool.execute(music);
        pool.execute(pics);

        // Write the pool information in console untill all the tasks is complete
        do {
            System.out.print("**************************************************\n");
            System.out.printf("Main : Parallelism: %d \n", pool.getParallelism());
            System.out.printf("Main : Active Threads: %d \n", pool.getActiveThreadCount());
            System.out.printf("Main : Task Count: %d \n", pool.getQueuedTaskCount());
            System.out.printf("Main : Steal Count: %d \n", pool.getStealCount());
            System.out.print("**************************************************\n");

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!movies.isDone() || !music.isDone() || !pics.isDone());

        pool.shutdown();

        List<String> results;

        results = movies.join();
        System.out.printf("Movies : %d files found \n", results.size());

        results = music.join();
        System.out.printf("Music : %d files found \n", results.size());

        results = pics.join();
        System.out.printf("Pictures : %d files found \n", results.size());

    }
}
