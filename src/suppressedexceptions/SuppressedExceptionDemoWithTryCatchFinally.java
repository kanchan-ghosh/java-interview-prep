package suppressedexceptions;

import static java.lang.System.err;

public class SuppressedExceptionDemoWithTryCatchFinally {
    public static void memberFunction() throws Exception {
            Throwable th = null;
            DirtyResource resource = new DirtyResource();
            try {
                resource.accessResource();
            }
            catch (Exception e) {
                th = e;
            }
            finally {
                try {
                    resource.close();
                }
                catch (Exception e) {
                    if(th != null) {
                        e.addSuppressed(th);
                        throw e;
                    }
                }
            }
    }

    public static void main(String[] args) {
        try {
            memberFunction();
        }
        catch (Exception e) {
            err.println("Exception occured " + e.toString());
            final Throwable[] suppressed = e.getSuppressed();
            final int numSuppressed = suppressed.length;
            if(numSuppressed > 0) {
                err.println("There are " + numSuppressed + " suppressed exceptions.");
                for(final Throwable throwable : suppressed) {
                    err.println("suppressed exceeptions ... " + throwable.toString());
                }
            }
        }
    }
}
