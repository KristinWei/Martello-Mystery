import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Test implements ActionListener{
    private Guest Veronica;
    private JLabel label1;
    private JButton play = new JButton();
    public Test(){
        JFrame myFrame = new JFrame("Detective App");
        myFrame.setSize(1200,1000);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font f = new Font("Times New Roman", Font.BOLD, 26);


        Container gameboardPanel = new Container();
        gameboardPanel.setEnabled(false);
        gameboardPanel.setSize(400,600);
        Veronica = new Guest("Veronica", 0 , 0);
        Veronica.setBounds(Veronica.xpos,Veronica.ypos,40,40);
        gameboardPanel.add(Veronica);

        play.setBackground(Color.white);
        play.setForeground(Color.blue);
        play.setFont(f);
        play.setText("Play");
        play.addActionListener(this);
        gameboardPanel.add(play);

        play.setBounds(850,450,200,50);
        ImageIcon image1= new ImageIcon(("Floor-Plan-page-001.jpg"));
        label1 = new JLabel(image1);
        label1.setBounds(0,0,700,800);
        gameboardPanel.add(label1);

        gameboardPanel.setEnabled(true);
        myFrame.setContentPane(gameboardPanel); //Add gameboardPanel to JFrame
        myFrame.setVisible(true); //Turn on JFrame
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==play){
            System.out.println("Action Performed");
            Veronica.xpos+=50;
            Veronica.setBounds(Veronica.xpos,Veronica.ypos,40,40);
        }
    }
}
