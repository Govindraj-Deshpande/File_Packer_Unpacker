import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends Frame implements ActionListener {
    Label lblUser, lblPass;
    TextField txtUser, txtPass;
    Button btnSubmit;
    Font f;
    ClockThread clock;

    public LoginFrame() {
        setTitle("Marvellous Packer-Unpacker");
        setSize(600, 300);
        setLayout(null);
        setBackground(new Color(0, 51, 102));
        f = new Font("Arial", Font.BOLD, 16);

        lblUser = new Label("Username:");
        lblUser.setBounds(100, 100, 100, 30);
        lblUser.setFont(f);
        lblUser.setForeground(Color.white);
        add(lblUser);

        txtUser = new TextField("MarvellousAdmin");
        txtUser.setBounds(220, 100, 200, 30);
        add(txtUser);

        lblPass = new Label("Password:");
        lblPass.setBounds(100, 150, 100, 30);
        lblPass.setFont(f);
        lblPass.setForeground(Color.white);
        add(lblPass);

        txtPass = new TextField("admin");
        txtPass.setEchoChar('*');

        txtPass.setBounds(220, 150, 200, 30);
        add(txtPass);

        btnSubmit = new Button("SUBMIT");
        btnSubmit.setBounds(250, 200, 100, 30);
        btnSubmit.addActionListener(this);
        add(btnSubmit);

        clock = new ClockThread(this);
        clock.start();

        setVisible(true);
    }

    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.drawString("Marvellous Packer Unpacker : Login", 30, 60);

        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.setColor(Color.WHITE);
        g.drawString(clock.date, 400, 60);
        g.drawString(clock.time, 400, 80);
        g.drawString(clock.day, 400, 100);
    }

    public void actionPerformed(ActionEvent ae) {
        String user = txtUser.getText();
        String pass = txtPass.getText();

        if (user.equals("MarvellousAdmin") && pass.equals("admin")) {
            new MainFrame(user);
            this.dispose();
        } else {
            txtUser.setText("");
            txtPass.setText("");
        }
    }
}
