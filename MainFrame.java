import java.awt.*;
import java.awt.event.*;

public class MainFrame extends Frame implements ActionListener {
    Button btnPack, btnUnpack;
    Label welcome;
    Font f;
    ClockThread clock;

    public MainFrame(String username) {
        setTitle("Marvellous Infosystems");
        setSize(600, 300);
        setLayout(null);
        setBackground(new Color(0, 102, 102));
        f = new Font("Arial", Font.BOLD, 18);

        welcome = new Label("Welcome: " + username);
        welcome.setBounds(180, 80, 300, 30);
        welcome.setFont(f);
        welcome.setForeground(Color.white);
        add(welcome);

        btnPack = new Button("Pack Files");
        btnPack.setBounds(150, 150, 100, 30);
        btnPack.addActionListener(this);
        add(btnPack);

        btnUnpack = new Button("Unpack Files");
        btnUnpack.setBounds(300, 150, 100, 30);
        btnUnpack.addActionListener(this);
        add(btnUnpack);

        clock = new ClockThread(this);
        clock.start();

        setVisible(true);
    }

    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.drawString("Choose Operation", 230, 60);

        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString(clock.date, 400, 60);
        g.drawString(clock.time, 400, 80);
        g.drawString(clock.day, 400, 100);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnPack) {
            new PackFrame();
            this.dispose();
        } else if (ae.getSource() == btnUnpack) {
            new UnpackFrame();
            this.dispose();
        }
    }
}
