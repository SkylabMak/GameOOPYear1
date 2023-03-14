import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class TestMethod {
    int delay = 1000; // milliseconds
    Timer time;

    public TestMethod() {
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("test");
            }
        };
        time = new Timer(delay, taskPerformer);
        time.start();

        try {
            wait(1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("test out method");
    }

    public static void main(String[] args) {
        new TestMethod();
    }
}
