import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Person extends JLabel{
    public int xpos;
    public int ypos;
    public String name;
    public BufferedImage img1,img2,img3,img4,img5,img6,img7,img8,img9;
    public Person(){
        this("", 0 ,0);
    }
    public Person(String n, int x, int y){
        name = n;
        xpos = x;
        ypos = y;

        try{
            img1= ImageIO.read(GUI.class.getResource("/Images/red.png"));
            img2=ImageIO.read(GUI.class.getResource("/Images/blue.png"));
            img3=ImageIO.read(GUI.class.getResource("/Images/yellow.png"));
            img4=ImageIO.read(GUI.class.getResource("/Images/green.png"));
            img5=ImageIO.read(GUI.class.getResource("/Images/orange.png"));
            img6=ImageIO.read(GUI.class.getResource("/Images/purple.jpg"));
            img7=ImageIO.read(GUI.class.getResource("/Images/brown.png"));
            img8=ImageIO.read(GUI.class.getResource("/Images/pink.jpg"));
            img9=ImageIO.read(GUI.class.getResource("/Images/black.png"));
        }catch(Exception e){
            System.out.println("IO Exception");
        }

        switch (name) {
            case "Veronica":
                this.setIcon(new ImageIcon(img1));
                break;
            case "Jason":
                this.setIcon(new ImageIcon(img2));
                break;
            case "Thomas":
                this.setIcon(new ImageIcon(img3));
                break;
            case "Rob":
                this.setIcon(new ImageIcon(img4));
                break;
            case "Kristina":
                this.setIcon(new ImageIcon(img5));
                break;
            case "MarcAndre":
                this.setIcon(new ImageIcon(img6));
                break;
            case "Dave":
                this.setIcon(new ImageIcon(img7));
                break;
            case "Salina":
                this.setIcon(new ImageIcon(img8));
                break;
            case "Harrison":
                this.setIcon(new ImageIcon(img9));
                break;
        }
    }
}
