package suppressedexceptions;

public class DirtyResource implements AutoCloseable {

    public void accessResource() {
        throw new RuntimeException("I wanted to access this resource, but it throws RuntimeException ");
    }

    @Override
    public void close() throws Exception {
        throw new NullPointerException("Null Pointer Exception thrown when trying to close resource");
    }
}
