package App;

public class Main {
    public static void main(String[] args) {
        NuPogodi nuPogodi = new NuPogodi();

        nuPogodi.init();

        while(true) {
            delay(20);
            nuPogodi.update();
            nuPogodi.render();
        }

    }

    private static void delay(final int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
