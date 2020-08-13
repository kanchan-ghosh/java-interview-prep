package trywithresource;

public class CustomResource implements AutoCloseable {

    public void accessResource() {
        System.out.println("Custom Resource accessed");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Custom Resource closed automatically");
    }
}
