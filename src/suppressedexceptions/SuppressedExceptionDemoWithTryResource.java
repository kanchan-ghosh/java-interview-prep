package suppressedexceptions;

public class SuppressedExceptionDemoWithTryResource {

    public static void main(String[] args) throws Exception {
        try(DirtyResource resource = new DirtyResource()) {
            resource.accessResource();
        }
    }
}
