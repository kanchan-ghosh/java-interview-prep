package trywithresource;

public class TryWithResourceTester {
    public static void main(String[] args) {
        try(CustomResource cr = new CustomResource()) {
            cr.accessResource();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
