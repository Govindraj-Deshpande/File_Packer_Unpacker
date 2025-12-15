/*import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class PackFrame extends Frame implements ActionListener {
    Label lblFolder, lblOutput;
    TextField txtFolder, txtOutput;
    Button btnBrowse, btnPack, btnBack;

    public PackFrame() {
        setTitle("Pack Files - Marvellous Infosystems");
        setSize(500, 300);
        setLayout(null);
        setBackground(new Color(0, 51, 102));

        lblFolder = new Label("Select Folder:");
        lblFolder.setBounds(50, 80, 100, 30);
        lblFolder.setForeground(Color.white);
        add(lblFolder);

        txtFolder = new TextField();
        txtFolder.setBounds(160, 80, 200, 30);
        add(txtFolder);

        btnBrowse = new Button("Browse");
        btnBrowse.setBounds(370, 80, 60, 30);
        btnBrowse.addActionListener(this);
        add(btnBrowse);

        lblOutput = new Label("Output File Name:");
        lblOutput.setBounds(50, 130, 120, 30);
        lblOutput.setForeground(Color.white);
        add(lblOutput);

        txtOutput = new TextField();
        txtOutput.setBounds(180, 130, 150, 30);
        add(txtOutput);

        btnPack = new Button("Pack");
        btnPack.setBounds(180, 180, 80, 30);
        btnPack.addActionListener(this);
        add(btnPack);

        btnBack = new Button("Back");
        btnBack.setBounds(280, 180, 80, 30);
        btnBack.addActionListener(this);
        add(btnBack);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnBrowse) {
            FileDialog fd = new FileDialog(this, "Select Folder", FileDialog.LOAD);
            fd.setDirectory("C:\\");
            fd.setVisible(true);
            txtFolder.setText(fd.getDirectory());
        } else if (ae.getSource() == btnPack) {
            String folderPath = txtFolder.getText();
            String outputFile = txtOutput.getText();

            try {
                if (folderPath.equals("") || outputFile.equals("")) {
                    throw new Exception("Please enter both folder and output file name.");
                }

                MarvellousPacker mp = new MarvellousPacker(folderPath, outputFile);
                Dialog d = new Dialog(this, "Success", true);
                d.setLayout(new FlowLayout());
                d.setSize(250, 100);
                d.add(new Label("Packing completed successfully."));
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
*/

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.JFileChooser;

public class PackFrame extends Frame implements ActionListener {
    Label lblFolder, lblOutput;
    TextField txtFolder, txtOutput;
    Button btnBrowse, btnPack, btnBack;

    public PackFrame() {
        setTitle("Pack Files - Marvellous Infosystems");
        setSize(500, 300);
        setLayout(null);
        setBackground(new Color(0, 51, 102));

        lblFolder = new Label("Select Folder:");
        lblFolder.setBounds(50, 80, 100, 30);
        lblFolder.setForeground(Color.white);
        add(lblFolder);

        txtFolder = new TextField();
        txtFolder.setBounds(160, 80, 200, 30);
        add(txtFolder);

        btnBrowse = new Button("Browse");
        btnBrowse.setBounds(370, 80, 60, 30);
        btnBrowse.addActionListener(this);
        add(btnBrowse);

        lblOutput = new Label("Output File Name:");
        lblOutput.setBounds(50, 130, 120, 30);
        lblOutput.setForeground(Color.white);
        add(lblOutput);

        txtOutput = new TextField();
        txtOutput.setBounds(180, 130, 150, 30);
        add(txtOutput);

        btnPack = new Button("Pack");
        btnPack.setBounds(180, 180, 80, 30);
        btnPack.addActionListener(this);
        add(btnPack);

        btnBack = new Button("Back");
        btnBack.setBounds(280, 180, 80, 30);
        btnBack.addActionListener(this);
        add(btnBack);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnBrowse) {
            // ✅ Use JFileChooser for folder selection
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Select Folder to Pack");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);

            int result = chooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFolder = chooser.getSelectedFile();
                txtFolder.setText(selectedFolder.getAbsolutePath());
            }

        } else if (ae.getSource() == btnPack) {
            String folderPath = txtFolder.getText();
            String outputFile = txtOutput.getText();

            try {
                if (folderPath.equals("") || outputFile.equals("")) {
                    throw new Exception("Please enter both folder and output file name.");
                }

                MarvellousPacker mp = new MarvellousPacker(folderPath, outputFile);
                Dialog d = new Dialog(this, "Success", true);
                d.setLayout(new FlowLayout());
                d.setSize(250, 100);
                d.add(new Label("Packing completed successfully."));
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
