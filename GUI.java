import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.File;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GUI extends JFrame implements ActionListener{

    private JButton play = new JButton();
    private JLabel label1;
    private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    private int i;
    private boolean go = true;
    private String guest, time, place;
    private Guest Veronica,Jason,Thomas,Rob,Kristina;
    private HotelStaff MarcAndre,Dave,Salina,Harrison;
    public BufferedImage img1,img2,img3,img4,img5,img6,img7,img8,img9;
    private int[][] places = {{175,250},{300,250},{450,125},{450,250},{550,250},
            {325,300},{500,300},{600,300},{175,375},{300,375},
            {425,375},{500,375},{550,350},{550,400},{150,500},
            {225,500},{300,500},{375,500},{450,500},{550,500},
            {600,575},{550,650},{525,575},{450,650},{425,575},
            {425,675},{300,650},{225,600},{225,675},{150,650}};

    public GUI(){
        JFrame myFrame = new JFrame("Detective App");
        myFrame.setSize(1200,1000);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font f = new Font("Times New Roman", Font.BOLD, 26);

        JPanel gameboardPanel = new JPanel();
        gameboardPanel.setEnabled(false);
        gameboardPanel.setLayout(null);
        gameboardPanel.setSize(400,600);

        Veronica = new Guest("Veronica", 0 , 0);
        Veronica.setBounds(Veronica.xpos,Veronica.ypos,40,40);
        gameboardPanel.add(Veronica);
        Jason = new Guest("Jason", 0 , 0);
        Jason.setBounds(Jason.xpos,Jason.ypos,40,40);
        gameboardPanel.add(Jason);
        Thomas = new Guest("Thomas", 0 , 0);
        Thomas.setBounds(Thomas.xpos,Thomas.ypos,40,40);
        gameboardPanel.add(Thomas);
        Rob = new Guest("Rob", 0 , 0);
        Rob.setBounds(Rob.xpos,Rob.ypos,40,40);
        gameboardPanel.add(Rob);
        Kristina = new Guest("Kristian", 0 , 0);
        Kristina.setBounds(Kristina.xpos,Kristina.ypos,40,40);
        gameboardPanel.add(Kristina);
        MarcAndre = new HotelStaff("MarcAndre", 0 , 0);
        MarcAndre.setBounds(MarcAndre.xpos,MarcAndre.ypos,40,40);
        gameboardPanel.add(MarcAndre);
        Dave = new HotelStaff("Dave", 0 , 0);
        Dave.setBounds(Dave.xpos,Dave.ypos,40,40);
        gameboardPanel.add(Dave);
        Salina = new HotelStaff("Salina", 0 , 0);
        Salina.setBounds(Salina.xpos,Salina.ypos,40,40);
        gameboardPanel.add(Salina);
        Harrison = new HotelStaff("Harrison", 0 , 0);
        Harrison.setBounds(Harrison.xpos,Harrison.ypos,40,40);
        gameboardPanel.add(Harrison);


        ImageIcon image1= new ImageIcon(("Floor-Plan-page-001.jpg"));
        label1 = new JLabel(image1);
        label1.setBounds(0,0,700,800);
        gameboardPanel.add(label1);

        l1 = new JLabel("RED: VERONICA");
        l1.setBounds(720,40,180,20);
        gameboardPanel.add(l1);
        l2 = new JLabel("BLUE: JASON");
        l2.setBounds(720,60,180,20);
        gameboardPanel.add(l2);
        l3 = new JLabel("YELLOW: THOMAS");
        l3.setBounds(720,80,180,20);
        gameboardPanel.add(l3);
        l4 = new JLabel("GREEN: ROB");
        l4.setBounds(720,100,180,20);
        gameboardPanel.add(l4);
        l5 = new JLabel("ORANGE: KRISTINA");
        l5.setBounds(720,120,180,20);
        gameboardPanel.add(l5);
        l6 = new JLabel("PURPLE: MARC-ANDRE");
        l6.setBounds(720,140,180,20);
        gameboardPanel.add(l6);
        l7 = new JLabel("BROWN: DAVE");
        l7.setBounds(720,160,180,20);
        gameboardPanel.add(l7);
        l8 = new JLabel("PINK: SALINA");
        l8.setBounds(720,180,180,20);
        gameboardPanel.add(l8);
        l9 = new JLabel("BLACK: HARRISON");
        l9.setBounds(720,200,180,20);
        gameboardPanel.add(l9);

        play.setBackground(Color.white);
        play.setForeground(Color.blue);
        play.setFont(f);
        play.setText("Play");
        play.addActionListener(this);
        gameboardPanel.add(play);

        play.setBounds(850,450,200,50);

        gameboardPanel.setEnabled(true);
        myFrame.setContentPane(gameboardPanel); //Add gameboardPanel to JFrame
        myFrame.setVisible(true); //Turn on JFrame
    }

    public void loadData(){

        String s1,s2,s3,s4,s5 = "";
        File file = new File("Murder-on-the-2nd-Floor-Raw-Data-v01.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                s1 = sc.nextLine();
                if (s1.contains("1578")) {

                    time = s1.substring(s1.indexOf("1"),s1.length()-4);
                    //System.out.println(time);
                    s2 = sc.nextLine();
                    s3 = sc.nextLine();
                    if (s3.contains("device-id")) {
                        place = s3.substring(s3.indexOf("device-id") + 13, s3.length() - 3);
                        //System.out.println(place);
                    }
                    s4 = sc.nextLine();
                    s5 = sc.nextLine();
                    if (s5.contains("guest-id")){
                        guest = s5.substring(s5.indexOf("guest-id")+12, s5.length() - 1);
                        //System.out.println(guest);
                    }

                    switch(place){
                        case"ap1-1":
                            findGuests(0);
                            TimeUnit.MILLISECONDS.sleep(10);
                            break;
                        case"ap1-4":
                            findGuests(1);
                            TimeUnit.MILLISECONDS.sleep(10);
                            break;
                        case"151":
                            findGuests(3);
                            TimeUnit.MILLISECONDS.sleep(10);
                            break;
                        case"155":
                            findGuests(4);
                            TimeUnit.MILLISECONDS.sleep(10);
                            break;
                        case"elevator":
                            findGuests(5);
                            TimeUnit.MILLISECONDS.sleep(10);
                            break;
                        case"ap1-2":
                            findGuests(6);
                            TimeUnit.MILLISECONDS.sleep(10);
                            break;
                        case"150":
                            findGuests(7);
                            TimeUnit.MILLISECONDS.sleep(10);
                            break;
                        case"156b":
                            findGuests(13);
                            TimeUnit.MILLISECONDS.sleep(10);
                            break;
                        case"156":
                            findGuests(12);
                            TimeUnit.MILLISECONDS.sleep(10);
                            break;
                        case"ap1-3":
                            findGuests(9);
                            TimeUnit.MILLISECONDS.sleep(10);
                            break;
                        case"130":
                            findGuests(8);
                            TimeUnit.MILLISECONDS.sleep(10);
                            break;
                        case"210":
                            findGuests(14);
                            TimeUnit.MILLISECONDS.sleep(10);
                            break;
                        case"231":
                            findGuests(15);
                            TimeUnit.MILLISECONDS.sleep(10);
                            break;
                        case"233":
                            findGuests(16);
                            TimeUnit.MILLISECONDS.sleep(10);
                            break;
                        case"235":
                            findGuests(17);
                            TimeUnit.MILLISECONDS.sleep(10);
                            break;
                        case"241":
                            findGuests(18);
                            TimeUnit.MILLISECONDS.sleep(10);
                            break;
                        case"247":
                            findGuests(19);
                            TimeUnit.MILLISECONDS.sleep(10);
                            break;
                        case"250":
                            findGuests(20);
                            TimeUnit.MILLISECONDS.sleep(10);
                            break;
                        case"248":
                            findGuests(21);
                            TimeUnit.MILLISECONDS.sleep(10);
                            break;
                        case"ap2-2":
                            findGuests(22);
                            TimeUnit.MILLISECONDS.sleep(10);
                            break;
                        case"244":
                            findGuests(23);
                            TimeUnit.MILLISECONDS.sleep(10);
                            break;
                        case"ap2-3":
                            findGuests(24);
                            TimeUnit.MILLISECONDS.sleep(10);
                            break;
                        case"236":
                            findGuests(25);
                            TimeUnit.MILLISECONDS.sleep(10);
                            break;
                        case"ice machine":
                            findGuests(26);
                            TimeUnit.MILLISECONDS.sleep(10);
                            break;
                        case"232":
                            findGuests(28);
                            TimeUnit.MILLISECONDS.sleep(10);
                            break;
                        case"ap2-1":
                            findGuests(27);
                            TimeUnit.MILLISECONDS.sleep(10);
                            break;
                        case"220":
                            findGuests(29);
                            TimeUnit.MILLISECONDS.sleep(10);
                            break;

                    }
                }
            }

        } catch (NullPointerException ne) {
            System.out.println("Null Pointer Exception");
        } catch(Exception e){
            System.out.println("Error");
        }
    }

    public boolean contain(String str1, String str2){
        return true;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==play){
            loadData();
        }
    }

    public void findGuests(int i) {
            switch (guest) {
                case "Veronica":
                    Veronica.setVisible(true);
                    Veronica.setBounds(places[i][0], places[i][1], 40, 40);
                    break;
                case "Jason":
                    Jason.setBounds(places[i][0], places[i][1], 40, 40);
                    break;
                case "Thomas":
                    Thomas.setBounds(places[i][0], places[i][1], 40, 40);
                    break;
                case "Rob":
                    Rob.setBounds(places[i][0], places[i][1], 40, 40);
                    break;
                case "Kristina":
                    Kristina.setBounds(places[i][0], places[i][1], 40, 40);
                    break;
                case "Marc-Andre":
                    MarcAndre.setBounds(places[i][0], places[i][1], 40, 40);
                    break;
                case "Dave":
                    Dave.setBounds(places[i][0], places[i][1], 40, 40);
                    break;
                case "Salina":
                    Salina.setBounds(places[i][0], places[i][1], 40, 40);
                    break;
                case "Harrison":
                    Harrison.setBounds(places[i][0], places[i][1], 40, 40);
                    break;
            }
    }

}