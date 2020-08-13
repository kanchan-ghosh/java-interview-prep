public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println("Number of processors available " + Runtime.getRuntime().availableProcessors());
        System.out.println("Total Memory " + Runtime.getRuntime().totalMemory()
                + " , Available Memory " + Runtime.getRuntime().freeMemory()
                + " , max memory " + Runtime.getRuntime().maxMemory());
    }
}
