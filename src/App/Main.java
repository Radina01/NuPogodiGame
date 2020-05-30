package App;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {

        final int FPS = 60;
        final int frameDelay = 1000 / FPS;
        long frameStart;
        long frameTime;

        NuPogodi nuPogodi = new NuPogodi();

        nuPogodi.init();

        while(NuPogodi.GamePlay) {

            frameStart = Calendar.getInstance().getTimeInMillis();

            nuPogodi.update();
            nuPogodi.render();

            frameTime = Calendar.getInstance().getTimeInMillis() - frameStart;
            if(frameDelay > frameTime) {
                delay((int)(frameDelay - frameTime));
            }
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
