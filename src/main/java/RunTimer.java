import java.util.*;
public class RunTimer {
    public int count;
    public boolean isTrue;
    public RunTimer(boolean isTrue, int count){
        this.isTrue=isTrue;
        this.count = count;
    }
    public void timeRun(int count) {
        TimerTask task = new TimerTask() {
            public void run() {}
        };
        Timer timer = new Timer();
        timer.schedule(task, 3000);
        if(4-count == 3) {
        }
        else if(4-count == 2){
            int time = 30;
            System.out.println("You have been blocked for 30 seconds:");
            for (int i = 0; i < time; ++i) {
                System.out.printf("\r%s", time - i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                }
            }
            System.out.print("\b");
        }
        else if(4-count == 1){
            System.out.println("You have been blocked for 60 seconds:");
            int time = 60;
            for (int i = 0; i < time; ++i) {
                System.out.printf("\r%s", time - i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                }
            }
            System.out.print("\b,\b");
        }
        else if(4-count == 0){
            System.out.println("You have been blocked for 300 seconds:");
            int time = 300;
            for (int i = 0; i < time; ++i) {
                System.out.printf("\r%s", time - i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                }
            }
            System.out.print("\b");
            System.out.println("All attempts have been used, please try again.");
            System.exit(0);
        }
        if (count <= 3) {
            System.out.printf("%s attempts left\n", (4 - count));

        }
        System.out.print("\b");
        if (count == 4) {
            isTrue = true;
        }
        System.out.print("\b,\b,\b");
    }
}