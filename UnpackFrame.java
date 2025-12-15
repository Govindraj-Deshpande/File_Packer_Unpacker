/*import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class UnpackFrame extends Frame implements ActionListener {
    Label lblFile;
    TextField txtFile;
    Button btnBrowse, btnUnpack, btnBack;

    public UnpackFrame() {
        setTitle("Unpack Files - Marvellous Infosystems");
        setSize(500, 250);
        setLayout(null);
        setBackground(new Color(102, 0, 102));

        lblFile = new Label("Select Packed File:");
        lblFile.setBounds(50, 80, 130, 30);
        lblFile.setForeground(Color.white);
        add(lblFile);

        txtFile = new TextField();
        txtFile.setBounds(190, 80, 180, 30);
        add(txtFile);

        btnBrowse = new Button("Browse");
        btnBrowse.setBounds(380, 80, 60, 30);
        btnBrowse.addActionListener(this);
        add(btnBrowse);

        btnUnpack = new Button("Unpack");
        btnUnpack.setBounds(190, 130, 80, 30);
        btnUnpack.addActionListener(this);
        add(btnUnpack);

        btnBack = new Button("Back");
        btnBack.setBounds(290, 130, 80, 30);
        btnBack.addActionListener(this);
        add(btnBack);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnBrowse) {
            FileDialog fd = new FileDialog(this, "Select Packed File", FileDialog.LOAD);
            fd.setDirectory("C:\\");
            fd.setVisible(true);
            txtFile.setText(fd.getDirectory() + fd.getFile());
        } else if (ae.getSource() == btnUnpack) {
            String packedFile = txtFile.getText();

            try {
                if (packedFile.equals("")) {
                    throw new Exception("Please select a packed file.");
                }

                MarvellousUnpacker mu = new MarvellousUnpacker(packedFile);
                Dialog d = new Dialog(this, "Success", true);
                d.setLayout(new FlowLayout());
                d.setSize(250, 100);
                d.add(new Label("Unpacking completed successfully."));
                Button b = new Button("OK");
                b.addActionListener(e -> d.setVisible(false));
                d.add(b);
                d.setVisible(true);
            } catch (Exception e) {
                Dialog d = new Dialog(this, "Error", true);
                d.setLayout(new FlowLayout());
                d.setSize(300, 100);
                d.add(new Label("Error: " + e.getMessage()));
                Button b = new Button("OK");
                b.addActionListener(err -> d.setVisible(false));
                d.add(b);
                d.setVisible(true);
            }
        } else if (ae.getSource() == btnBack) {
            new MainFrame("Admin"); // default user
            this.dispose();
        }
    }
}*/

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.JFileChooser;

public class UnpackFrame extends Frame implements ActionListener {
    Label lblFile;
    TextField txtFile;
    Button btnBrowse, btnUnpack, btnBack;

    public UnpackFrame() {
        setTitle("Unpack Files - Marvellous Infosystems");
        setSize(500, 250);
        setLayout(null);
        setBackground(new Color(0, 51, 102));

        lblFile = new Label("Select File:");
        lblFile.setBounds(50, 80, 100, 30);
        lblFile.setForeground(Color.white);
        add(lblFile);

        txtFile = new TextField();
        txtFile.setBounds(160, 80, 200, 30);
        add(txtFile);

        btnBrowse = new Button("Browse");
        btnBrowse.setBounds(370, 80, 60, 30);
        btnBrowse.addActionListener(this);
        add(btnBrowse);

        btnUnpack = new Button("Unpack");
        btnUnpack.setBounds(180, 130, 80, 30);
        btnUnpack.addActionListener(this);
        add(btnUnpack);

        btnBack = new Button("Back");
        btnBack.setBounds(280, 130, 80, 30);
        btnBack.addActionListener(this);
        add(btnBack);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnBrowse) {
            // ✅ Use JFileChooser for file selection
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Select Packed File");
            int result = chooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();
                txtFile.setText(selectedFile.getAbsolutePath());
            }

        } else if (ae.getSource() == btnUnpack) {
            String filePath = txtFile.getText();

            try {
                if (filePath.equals("")) {
                    throw new Exception("Please select the file to unpack.");
                }

                MarvellousUnpacker mu = new MarvellousUnpacker(filePath);
                Dialog d = new Dialog(this, "Success", true);
                d.setLayout(new FlowLayout());
                d.setSize(250, 100);
                d.add(new Label("Unpacking completed successfully."));
                Button b = new Button("OK");
                b.addActionListener(e -> d.setVisible(false));
                d.add(b);
                d.setVisible(true);
            } catch (Exception e) {
                Dialog d = new Dialog(this, "Error", true);
                d.setLayout(new FlowLayout());
                d.setSize(300, 100);
                d.add(new Label("Error: " + e.getMessage()));
                Button b = new Button("OK");
                b.addActionListener(err -> d.setVisible(false));
                d.add(b);
                d.setVisible(true);
            }

        } else if (ae.getSource() == btnBack) {
            new MainFrame("Admin"); // default user
            this.dispose();
        }
    }
}

