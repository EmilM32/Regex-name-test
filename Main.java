package regextest;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class Main extends JFrame
{
    public Main()
    {
        this.setTitle("Regex Test");
        this.setBounds(800,300,400,120);
        this.setResizable(false);

        panel.add(name);
        panel.add(textName);
        panel.add(surname);
        panel.add(textSurname);
        panel.add(buttonOk);
        
        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                String nameTest = textName.getText();
                String surnameTest = textSurname.getText();
              //  System.out.println(nameTest + " " + surnameTest);
                Regex(nameTest, surnameTest);
                if(Regex(nameTest, surnameTest))
                    JOptionPane.showMessageDialog(null, "Imię i nazwisko poprawne", "Dobrze!", JOptionPane.INFORMATION_MESSAGE);
                else
                {
                    JOptionPane.showMessageDialog(null, "Imię i/lub nazwisko błędne", "Źle!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        this.getContentPane().add(panel, BorderLayout.NORTH);
        panel.setPreferredSize(new Dimension(400, 120));
        this.setDefaultCloseOperation(3);
    }
    
    private JPanel panel = new JPanel();
    private JLabel name = new JLabel("Imię: ");
    private JTextField textName = new JTextField(10);
    private JTextField textSurname = new JTextField(10);
    private JLabel surname = new JLabel("Nazwisko: ");
    private JButton buttonOk = new JButton("OK");
    public static void main(String[] args) 
    {
       new Main().setVisible(true);
    }
    private static boolean Regex(String nameTest, String surnameTest)
    {
        Pattern pattern1 = Pattern.compile("\\b(?<NAME>^\\D*)\\b", Pattern.UNICODE_CHARACTER_CLASS);
        Pattern pattern2 = Pattern.compile("\\b(?<SURNAME>^\\D*)\\b", Pattern.UNICODE_CHARACTER_CLASS);
        
        boolean matcher1 = pattern1.matcher(nameTest).matches();
        boolean matcher2 = pattern2.matcher(surnameTest).matches();
        
        if(matcher1 && matcher2)
            return true;
        else
            return false;
    }
    
}
