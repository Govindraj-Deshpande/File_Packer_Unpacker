import java.text.SimpleDateFormat;
import java.util.*;
import java.awt.Frame;


public class ClockThread extends Thread {
    LoginFrame login;
    MainFrame main;
    PackFrame pack;
    UnpackFrame unpack;
    public String time, date, day;

    public ClockThread(Frame ref) {
        if (ref instanceof LoginFrame)
            login = (LoginFrame) ref;
        if (ref instanceof MainFrame)
            main = (MainFrame) ref;
        if (ref instanceof PackFrame)
            pack = (PackFrame) ref;
        if (ref instanceof UnpackFrame)
            unpack = (UnpackFrame) ref;
    }

    public void run() {
        while (true) {
            Calendar cal = Calendar.getInstance();
            time = new SimpleDateFormat("hh:mm:ss a").format(cal.getTime());
            date = new SimpleDateFormat("MMMM dd yyyy").format(cal.getTime());
            day = new SimpleDateFormat("EEEE").format(cal.getTime());

            if (login != null)
                login.repaint();
            if (main != null)
                main.repaint();
            if (pack != null)
                pack.repaint();
            if (unpack != null)
                unpack.repaint();

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}
