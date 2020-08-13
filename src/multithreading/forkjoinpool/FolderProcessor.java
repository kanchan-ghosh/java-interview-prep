package multithreading.forkjoinpool;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderProcessor extends RecursiveTask<List<String>> {

    private static final long serialVersionUID = 1L;

    // This attribute will store the full path of the folder, this task is going to process.
    private final String path;

    // This attribute will store the name of the file extension that this task will process.
    private final String extension;

    public FolderProcessor(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }


    @Override
    protected List<String> compute() {

        List<String> list = new ArrayList<>();
        List<FolderProcessor> tasks = new ArrayList<>();

        File file = new File(path);
        File[] contents = file.listFiles();

        if(contents != null) {
            for(File content : contents) {
                if(content.isDirectory()) {
                    FolderProcessor task = new FolderProcessor(content.getAbsolutePath(), extension);
                    task.fork();
                    tasks.add(task);
                }
                else {
                    if(checkFile(content.getName())) {
                        list.add(content.getAbsolutePath());
                    }
                }
            }
        }

        // if in the list there are more than 50 subtask elements
        // write a message to he console to indicate the circumstance
        if(tasks.size() > 50) {
            System.out.printf("%s : %d tasks run \n", file.getAbsolutePath(), tasks.size());
        }

        addResultsFromTasks(list, tasks);
        return list;
    }

    // For each task stored in the list of tasks, call the join() method that will wait for its finalization and
    // then will return the result of the task. Add that result to the list of strings using the addAll() method.
    private void addResultsFromTasks(List<String> list, List<FolderProcessor> tasks) {
        for (FolderProcessor item : tasks) {
            list.addAll(item.join());
        }
    }

    private boolean checkFile(String name) {
        return name.endsWith(extension);
    }
}
