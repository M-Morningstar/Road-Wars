import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class GUI extends JPanel implements ActionListener  {

    //Create variables
    Timer t;
    
    int x=0;
    int y=0;
    
    int[] lineX= {5, 255, 505, 755, 1005, 1255, 1505};
    int[] lineY= {210, 440, 670};

    int[] imgX= {0,0,0,0};
    int[] imgY= {15,225,475,685,15,225,475,685,15,225,475,685};

    BufferedImage[] imgs=new BufferedImage[3];

    int[] imgXR= {0,0,0,0};
    int[] imgYR= {15,225,475,685,15,225,475,685,15,225,475,685};
    
    ArrayList<Integer> bulletX1= new ArrayList<Integer>();
    ArrayList<Integer> bulletY1= new ArrayList<Integer>();
    
    ArrayList<Integer> bulletX2= new ArrayList<Integer>();
    ArrayList<Integer> bulletY2= new ArrayList<Integer>();

    int carX1=1395;
    int carY1=285;

    int carX2=1395;
    int carY2=515;

    int scoreP1=0000;
    int scoreP2=0000;

    int width=100;
    int height=100;
    
    int bulletW1=30;
    int bulletH1=20;
    
    int bulletW2=30;
    int bulletH2=20;

    int timeP1;
    int timeP2;
    
    BufferedImage img, img2,img3, img4, img5, img6, img7, img8, img9, img10, img11, img12;

    ArrayList<Integer> heartX= new ArrayList<Integer>();
    ArrayList<Integer> heartY= new ArrayList<Integer>();

    int p1Lives=3;
    int p2Lives=3;

    Random r=new Random();
    int n;
    
    int mousex;
    int mousey;

    Color desertColor=new Color(255,192,128);
    Color road=new Color(56, 55, 55);
    Color forestColor=new Color(37,89,31);
    Color forestLine=new Color (234, 187, 140);
    Color marsSurface=new Color (231,125,17);
    Color marsLine=new Color (69,24,4);
    
    String question="How many player will play?";
    
    Font f1 = new Font("Comic Sans MS",1,36);
    Font f2 = new Font("Comic Sans MS",1,14);
    
    boolean player1;
    boolean player2;
    
    boolean p1Alive=true;
    boolean p2Alive=true;
    
    boolean car1Draw=true;
    boolean car2Draw=true;
    
    boolean p1ScoreLimit=false;
    boolean p1ScoreLimit1=false;
    boolean p1ScoreLimit2=false;
    boolean p2ScoreLimit=false;
    boolean p2ScoreLimit1=false;
    boolean p2ScoreLimit2=false;
    
    boolean tree;
    boolean rock;

    boolean moveUp1;
    boolean moveDown1;
    boolean moveLeft1;
    boolean moveRight1;

    boolean moveUp2;
    boolean moveDown2;
    boolean moveLeft2;
    boolean moveRight2;
    //BufferedImage 

    //end of variables//


    public GUI() {

        initComponents();
        t = new Timer(30,this);
        t.start();

        try { img = ImageIO.read(new File("src/tree.png"));
        }

        catch (IOException e) { System.out.println("tree");};

        try { img2 = ImageIO.read(new File("src/cool.png"));
        }
        catch (IOException e) { System.out.println("cool");};

        try { img3 = ImageIO.read(new File("src/car.png"));
        }
        catch (IOException e) { System.out.println("car");};

        try { img4 = ImageIO.read(new File("src/rock.png"));
        }
        catch (IOException e) {System.out.println("rock"); };

        try { img5 = ImageIO.read(new File("src/heart.png"));
        }
        catch (IOException e) {System.out.println("heart"); };
        
        try { img6 = ImageIO.read(new File("src/cactus.png"));
        }

        catch (IOException e) { System.out.println("cactus");};
        
        try { img7 = ImageIO.read(new File("src/bum.png"));
        }

        catch (IOException e) { System.out.println("drock");};
        
        try { img8 = ImageIO.read(new File("src/bullet.png"));
        }

        catch (IOException e) { System.out.println("bullet");};
        
        try { img9 = ImageIO.read(new File("src/rocks.png.png"));
        }

        catch (IOException e) { System.out.println("rocks");};
        
        try { img10 = ImageIO.read(new File("src/trees2.png"));
        }

        catch (IOException e) { System.out.println("trees");};
        
        try { img11 = ImageIO.read(new File("src/alien.png"));
        }

        catch (IOException e) { System.out.println("alien");};
        
        try { img12 = ImageIO.read(new File("src/alien2.png"));
        }

        catch (IOException e) { System.out.println("alien2");};

        imgs[0]=img;
        imgs[1]=img4;


        heartX.add(5);
        heartX.add(70);
        heartX.add(135);
        heartX.add(1370);
        heartX.add(1435);
        heartX.add(1500);

        heartY.add(5);
        heartY.add(5);
        heartY.add(5);
        heartY.add(5);
        heartY.add(5);
        heartY.add(5);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);


        
        //all your drawing will go in here
        g.setColor(Color.white);
        g.fillRect(0, 0, 1600, 900);
        g.setFont(f1);
        g.setColor(Color.black);
        g.drawRect(500,250, 620, 75);
        g.drawString(question, 580, 300);
//        Scanner s = new Scanner (System.in);
//        String  choice = s.nextLine();
        g.setFont(f2);
        g.drawRect(520, 400, 200, 50);
        g.drawString("1 Player", 590, 430);
        g.drawRect(900, 400, 200, 50);
        g.drawString("2 Players", 970, 430);
        
        if(520<=mousex && mousex<=520+200 && 400<=mousey && mousey<=400+100) {
            player1=true;
            player2=false;
        }
        if(player1==true) {
            player1Game(g);
            lineMove();
            car1ColImg();
            car1Col2();
            windowBorder();
            obstacle(g);

            changeBackgroundP1();
            desertP1(g);
            carX2=3000;
            carY2=3000;
            p2Alive=false;
            moveLeft2=false;
            moveUp2=false;
            moveDown2=false;
            moveUp2=false;
            car2Draw=false;
            theEnd(g);
            g.setFont(f2);
            scoreP1(g);
        }
        if(900<=mousex && mousex<=900+200 && 400<=mousey && mousey<=400+100) {
            player1=false;
            player2=true;
        }
        if(player2==true) {
            player2Game(g);
            changeBackgroundBoth();
            lineMove();
            car1ColImg();
            car1Col2();
            car2Col1();
            car2Col2();
            windowBorder();
            obstacle(g);

            carsColl(g);
            desertBoth(g);

            bulletP2(g);
            bulletP1(g);
            theEnd(g);
            g.setFont(f2);
            scoreP1(g);
            scoreP2(g);
            
        }
        ////end of your drawing
    }     
    
    public void player1Game(Graphics g) {
//        changeBackgroundP1();
//        changeBackgroundBoth()
//        lineMove();
//        car1ColImg();
//        car1Col2();
//        car2Col1();
//        car2Col2();
//        windowBorder();
        g.setColor(road);
        g.fillRect(x, y, width+1500, height+800);
        g.setColor(Color.WHITE);
        for(int i=0; i<lineX.length; i++) {
            g.fillRect(lineX[i], lineY[0], width+50, height-80);
            g.fillRect(lineX[i], lineY[1], width+50, height-80);
            g.fillRect(lineX[i], lineY[2], width+50, height-80);

            g.drawImage(imgs[0], imgX[0], imgY[0], 150, 200,this);
            if(car1Draw==true) {
                g.drawImage(img2,carX1, carY1, 200, 100, this);
            }
//            if(car2Draw==true) {
//                g.drawImage(img3,carX2, carY2, 200, 100, this);
//            }
            g.drawImage(imgs[1], imgXR[0], imgYR[3], 150, 200,this);
        
            for(int j=3; j<heartX.size(); j++) {
                g.drawImage(img5 ,heartX.get(j), heartY.get(j), 65, 40, this);
            }
        }
//        obstacle(g);
//        scoreP1(g);
//        scoreP2(g);
//        carsColl(g);
//        desertBoth(g);

//        bulletP2(g);
//        bulletP1(g);
    }
    
    public void player2Game(Graphics g) {
        g.setColor(road);
        g.fillRect(x, y, width+1500, height+800);
        g.setColor(Color.WHITE);
        for(int i=0; i<lineX.length; i++) {
            g.fillRect(lineX[i], lineY[0], width+50, height-80);
            g.fillRect(lineX[i], lineY[1], width+50, height-80);
            g.fillRect(lineX[i], lineY[2], width+50, height-80);

            g.drawImage(imgs[0], imgX[0], imgY[0], 150, 200,this);
            if(car1Draw==true) {
                g.drawImage(img2,carX1, carY1, 200, 100, this);
            }
            if(car2Draw==true) {
                g.drawImage(img3,carX2, carY2, 200, 100, this);
            }
            g.drawImage(imgs[1], imgXR[0], imgYR[3], 150, 200,this);
        
            for(int j=0; j<heartX.size(); j++) {
                g.drawImage(img5 ,heartX.get(j), heartY.get(j), 65, 40, this);
            }
        }
    }

    public void theEnd(Graphics g) {
        if(car1Draw==false && car2Draw==false) {
            g.setColor(Color.white);
            g.fillRect(x, y, 1600, 900);
            g.setColor(Color.black);
            g.setFont(f1);
            g.drawString("The End", 700, 400);
            System.out.println("DEAD");
        }
    }
    
    public void bulletP1(Graphics g) {
            for(int i=0; i<bulletX1.size(); i++) {            
                g.drawImage(img8, bulletX1.get(i), bulletY1.get(i), bulletW1, bulletH1,this);
                System.out.println(i+" y:"+bulletY1.get(i));
                bulletX1.set(i, bulletX1.get(i)-30);
                if(bulletX1.get(i)<0) {
                    bulletX1.remove(i);
                    bulletY1.remove(i);
                }
                if(carX2<=bulletX1.get(i)+30 && bulletX1.get(i)<=carX2+200 && carY2<=bulletY1.get(i)+20 && bulletY1.get(i)<=carY2+100) {
                    p2Lives=p2Lives-1;
                    carX2=1395;
                    carY2=515;
                    lifeCounterp2(p2Lives);
                    bulletX1.remove(i);
                    bulletY1.remove(i);
                }
            }
    }
    
    public void bulletP2(Graphics g) {
            for(int i=0; i<bulletX2.size(); i++) {            
                g.drawImage(img8, bulletX2.get(i), bulletY2.get(i), bulletW2, bulletH2,this);
                System.out.println(i+" y:"+bulletY2.get(i));
                bulletX2.set(i, bulletX2.get(i)-30);
                if(bulletX2.get(i)<0) {
                    bulletX2.remove(i);
                    bulletY2.remove(i);
                }
                if(carX1<=bulletX2.get(i)+30 && bulletX2.get(i)<=carX1+200 && carY1<=bulletY2.get(i)+20 && bulletY2.get(i)<=carY2+100) {
                    p1Lives=p1Lives-1;
                    carX1=1395;
                    carY1=285;
                    lifeCounterp1(p1Lives);
                    bulletX2.remove(i);
                    bulletY2.remove(i);
                }
            }
    }
    
    public void windowBorder() {
        if(p1Alive==true) {
            if(carX1+200>1600) {
                carX1=1400;
            }
            else if(carY1+100>900) {
                carY1=800;
            }
            else if(carY1<0) {
                carY1=0;
            }
            else if(carX1<0) {
                carX1=0;
            }
        }
        if(p2Alive==true) {
            if(carX2+200>1600) {
                carX2=1400;
            }
            else if(carY2+100>900) {
                carY2=800;
            }
            else if(carY2<0) {
                carY2=0;
            }
            else if(carX2<0) {
                carX2=0;
            }
        }
    }
    
    public void changeBackgroundP1() {
        if(scoreP1>=4500) {
            p1ScoreLimit=true;
        }
        if(scoreP1>=9000) {
            p1ScoreLimit=false;
            p1ScoreLimit1=true;
        }
        if(scoreP1>=13500) {
            p1ScoreLimit=false;
            p1ScoreLimit1=false;
            p1ScoreLimit2=true;
        }
    }
    
    public void changeBackgroundBoth() {
        if(scoreP1>=4500) {
            p1ScoreLimit=true;
        }
        if(scoreP2>=4500) {
            p2ScoreLimit=true;
        }
        if(scoreP1>=9000) {
            p1ScoreLimit=false;
            p1ScoreLimit1=true;
        }
        if(scoreP2>=9000) {
            p1ScoreLimit=false;
            p2ScoreLimit1=true;
        }
        if(scoreP1>=13500) {
            p1ScoreLimit=false;
            p1ScoreLimit1=false;
            p1ScoreLimit2=true;
        }
        if(scoreP2>=13500) {
            p2ScoreLimit=false;
            p2ScoreLimit1=false;
            p2ScoreLimit2=true;
        }
    }
    
    public void desertP1(Graphics g) {
        car1ColImg();
        car1Col2();
        windowBorder();
        if(p1ScoreLimit==true) {
            g.setColor(desertColor);
            g.fillRect(x, y, width+1500, height+800);    
            imgX[0]=imgX[0]+6;
            imgXR[0]=imgXR[0]+6;
            g.setColor(Color.WHITE);
            for(int i=0; i<lineX.length; i++) {
                g.fillRect(lineX[i], lineY[0], width+50, height-80);
                g.fillRect(lineX[i], lineY[1], width+50, height-80);
                g.fillRect(lineX[i], lineY[2], width+50, height-80);

                g.drawImage(img6, imgX[0], imgY[0], 150, 190,this);
                if(car1Draw==true) {
                    g.drawImage(img2,carX1, carY1, 200, 100, this);
                }
//                if(car2Draw==true) {
//                    g.drawImage(img3,carX2, carY2, 200, 100, this);
//                }
                g.drawImage(img7, imgXR[0], imgYR[3]-35, 150, 280,this);

                for(int j=3; j<heartX.size(); j++) {
                    g.drawImage(img5 ,heartX.get(j), heartY.get(j), 65, 40, this);
                }
        
            }
//            scoreP1(g);
        }
        if(p1ScoreLimit1==true) {
            g.setColor(forestColor);
            g.fillRect(x, y, width+1500, height+800);    
            g.setColor(forestLine);
            for(int i=0; i<lineX.length; i++) {
                g.fillRect(lineX[i], lineY[0], width+50, height-80);
                g.fillRect(lineX[i], lineY[1], width+50, height-80);
                g.fillRect(lineX[i], lineY[2], width+50, height-80);

                g.drawImage(img10, imgX[0], imgY[0], 125, 200,this);
                if(car1Draw==true) {
                    g.drawImage(img2,carX1, carY1, 200, 100, this);
                }
//                if(car2Draw==true) {
//                    g.drawImage(img3,carX2, carY2, 200, 100, this);
//                }
                g.drawImage(img9, imgXR[0], imgYR[3]-25, 150, 220,this);

                for(int j=3; j<heartX.size(); j++) {
                    g.drawImage(img5 ,heartX.get(j), heartY.get(j), 65, 40, this);
                }
        
            }
            g.setColor(Color.white);
//            scoreP1(g);
        }
        if(p1ScoreLimit2==true) {
            g.setColor(marsSurface);
            g.fillRect(x, y, width+1500, height+800);    
            imgX[0]=imgX[0]+9;
            imgXR[0]=imgXR[0]+9;
            g.setColor(marsLine);
            for(int i=0; i<lineX.length; i++) {
                g.fillRect(lineX[i], lineY[0], width+50, height-80);
                g.fillRect(lineX[i], lineY[1], width+50, height-80);
                g.fillRect(lineX[i], lineY[2], width+50, height-80);

                g.drawImage(img11, imgX[0], imgY[0], 100, 180,this);
                if(car1Draw==true) {
                    g.drawImage(img2,carX1, carY1, 200, 100, this);
                }
//                if(car2Draw==true) {
//                    g.drawImage(img3,carX2, carY2, 200, 100, this);
//                }
                g.drawImage(img12, imgXR[0], imgYR[3]-25, 140, 200,this);

                for(int j=3; j<heartX.size(); j++) {
                    g.drawImage(img5 ,heartX.get(j), heartY.get(j), 65, 40, this);
                }
        
            }
            g.setColor(Color.white);
//            scoreP1(g);
        }
    }
    
    public void desertBoth(Graphics g) {
        car1ColImg();
        car1Col2();
        car2Col1();
        car2Col2();
        
        if(p1ScoreLimit==true && p2ScoreLimit==true) {
            g.setColor(desertColor);
            g.fillRect(x, y, width+1500, height+800);    
            imgX[0]=imgX[0]+3;
            imgXR[0]=imgXR[0]+3;
            g.setColor(Color.WHITE);
            for(int i=0; i<lineX.length; i++) {
                g.fillRect(lineX[i], lineY[0], width+50, height-80);
                g.fillRect(lineX[i], lineY[1], width+50, height-80);
                g.fillRect(lineX[i], lineY[2], width+50, height-80);

                g.drawImage(img6, imgX[0], imgY[0], 150, 190,this);
                if(car1Draw==true) {
                    g.drawImage(img2,carX1, carY1, 200, 100, this);
                }
                if(car2Draw==true) {
                    g.drawImage(img3,carX2, carY2, 200, 100, this);
                }
                g.drawImage(img7, imgXR[0], imgYR[3]-35, 150, 235,this);

                for(int j=0; j<heartX.size(); j++) {
                    g.drawImage(img5 ,heartX.get(j), heartY.get(j), 65, 40, this);
                }
            }
        }
        
            if(p1ScoreLimit1==true && p2ScoreLimit1==true) {
                g.setColor(forestColor);
                g.fillRect(x, y, width+1500, height+800);    
                g.setColor(forestLine);
                for(int i=0; i<lineX.length; i++) {
                    g.fillRect(lineX[i], lineY[0], width+50, height-80);
                    g.fillRect(lineX[i], lineY[1], width+50, height-80);
                    g.fillRect(lineX[i], lineY[2], width+50, height-80);

                    g.drawImage(img10, imgX[0], imgY[0], 125, 200,this);
                    if(car1Draw==true) {
                        g.drawImage(img2,carX1, carY1, 200, 100, this);
                    }
                    if(car2Draw==true) {
                        g.drawImage(img3,carX2, carY2, 200, 100, this);
                    }
                    g.drawImage(img9, imgXR[0], imgYR[3]-25, 150, 220,this);

                    for(int j=0; j<heartX.size(); j++) {
                        g.drawImage(img5 ,heartX.get(j), heartY.get(j), 65, 40, this);
                    }
            
                }
                g.setColor(Color.white);
            }
            
            if(p1ScoreLimit2==true && p2ScoreLimit2==true) {
                g.setColor(marsSurface);
                g.fillRect(x, y, width+1500, height+800);    
                imgX[0]=imgX[0]+7;
                imgXR[0]=imgXR[0]+7;
                g.setColor(marsLine);
                for(int i=0; i<lineX.length; i++) {
                    g.fillRect(lineX[i], lineY[0], width+50, height-80);
                    g.fillRect(lineX[i], lineY[1], width+50, height-80);
                    g.fillRect(lineX[i], lineY[2], width+50, height-80);

                    g.drawImage(img11, imgX[0], imgY[0], 100, 180,this);
                    if(car1Draw==true) {
                        g.drawImage(img2,carX1, carY1, 200, 100, this);
                    }
                    if(car2Draw==true) {
                        g.drawImage(img3,carX2, carY2, 200, 100, this);
                    }
                    g.drawImage(img12, imgXR[0], imgYR[3]-25, 140, 200,this);

                    for(int j=0; j<heartX.size(); j++) {
                        g.drawImage(img5 ,heartX.get(j), heartY.get(j), 65, 40, this);
                    }
            
                }
                g.setColor(Color.white);
            }
    }
    
    public void obstacle(Graphics g) {


        imgX[0]=imgX[0]+22;
        if(imgX[0]>=1600) {
            n=r.nextInt(12);
            imgY[0]=imgY[n];
            imgX[0]=-75;
            n=r.nextInt(2);
            if(n==0) {
                imgs[0]=img;
            }
            else {
                imgs[0]=img4;
            }
        }

        imgXR[0]=imgXR[0]+18;
        if(imgXR[0]>=1600) {
            n=r.nextInt(12);
            imgYR[3]=imgYR[n];
            imgXR[0]=-75;
            n=r.nextInt(2);
            if(n==0) {
                imgs[1]=img4;
            }
            else {
                imgs[1]=img;
            }
        }
        if(imgY[0]==imgYR[3]) {
            if(imgX[0]>imgXR[0]) {
                n=r.nextInt(12);
                imgYR[3]=imgYR[n];
            }
            else {
                n=r.nextInt(12);
                imgY[0]=imgY[n];
            }
        }


    }    

    public void scoreP1(Graphics g) {
        if(p1Alive==true) {
        scoreP1=scoreP1+7;
        }
        String b1=Integer.toString(scoreP1);
        g.drawString("P1 Score = "+b1, 1400, 50);

    }

    public void scoreP2(Graphics g) {
        if(p2Alive==true) {
            scoreP2=scoreP2+7;
        }
        String b2=Integer.toString(scoreP2);
        g.drawString("P2 Score = "+b2, 50, 50);

    }
    
    public void lineMove() {
        for(int i=0; i<lineX.length;i++) {
            lineX[i]=lineX[i]+10;
            if(lineX[i]>1600) {
                lineX[i]=-145;
            }
        }
    }
    
    public void car1ColImg() {
        if(carX1<=imgX[0] +90  && imgX[0]<=carX1+ width+100 && carY1<=imgY[0]+height+65 && imgY[0]<=carY1+height && imgY[0]==imgY[1]) {
            n=r.nextInt(12);
            imgY[0]=imgY[n];
            imgX[0]=-75;
            p1Lives=p1Lives-1;
            carX1=1395;
            carY1=285;
            lifeCounterp1(p1Lives);
            scoreP1=scoreP1-1000;
            
        }
        if(carX1<=imgX[0] +90  && imgX[0]<=carX1+ width+100 && carY1<=imgY[0]+height+65 && imgY[0]<=carY1+height) {
            p1Lives=p1Lives-1;
            carX1=1395;
            carY1=285;
            lifeCounterp1(p1Lives);    
            System.out.println("COOLLLIDDDEEE");
            scoreP1=scoreP1-1000;
        }    
        
    }    
    
    public void car1Col2() {
        if(carX1<=imgXR[0] +125  && imgXR[0]<=carX1+ width+100 && carY1<=imgYR[3]+height+60 && imgYR[3]<=carY1+height && imgYR[3]==imgYR[1]) {
            n=r.nextInt(12);
            imgYR[3]=imgYR[n];
            imgXR[0]=-75;
            p1Lives=p1Lives-1;
            carX1=1395;
            carY1=285;
            lifeCounterp1(p1Lives);
            scoreP1=scoreP1-1000;
            
        }

        if(carX1<=imgXR[0] +125  && imgXR[0]<=carX1+ width+100 && carY1<=imgYR[3]+height+60 && imgYR[3]<=carY1+height) {
            p1Lives=p1Lives-1;
            carX1=1395;
            carY1=285;
            lifeCounterp1(p1Lives);
            scoreP1=scoreP1-1000;
        }
        
    }

    public void car2Col1() {
        if(carX2<=imgX[0] +90  && imgX[0]<=carX2+ width+100 && carY2<=imgY[0]+height+65 && imgY[0]<=carY2+height && imgY[0]==imgY[2]) {
            n=r.nextInt(12);
            imgY[0]=imgY[n];
            imgX[0]=-75;
            p2Lives=p2Lives-1;
            carX2=1395;
            carY2=515;
            lifeCounterp2( p2Lives);
            scoreP2=scoreP2-1000;
        }
        if(carX2<=imgX[0] +90  && imgX[0]<=carX2+ width+100 && carY2<=imgY[0]+height+65 && imgY[0]<=carY2+height) {
            p2Lives=p2Lives-1;
            carX2=1395;
            carY2=515;
            lifeCounterp2(p2Lives);    
            scoreP2=scoreP2-1000;
        }    
    }
    
    public void car2Col2() {
        if(carX2<=imgXR[0] +125  && imgXR[0]<=carX2+ width+100 && carY2<=imgYR[3]+height+60 && imgYR[3]<=carY2+height && imgYR[3]==imgYR[2]) {
            n=r.nextInt(12);
            imgYR[3]=imgYR[n];
            imgXR[0]=-75;
            p2Lives=p2Lives-1;
            carX2=1395;
            carY2=515;
            lifeCounterp2(p2Lives);
            scoreP2=scoreP2-1000;
        }

        if(carX2<=imgXR[0] +125  && imgXR[0]<=carX2+ width+100 && carY2<=imgYR[3]+height+60 && imgYR[3]<=carY2+height) {
            p2Lives=p2Lives-1;
            carX2=1395;
            carY2=515;
            lifeCounterp2(p2Lives);
            scoreP2=scoreP2-1000;
        }
    }

    public void lifeCounterp1(int p1Lives) {
        if(p1Lives==2) {
            heartX.remove(heartX.size()-3);
            System.out.println("1");

        }
        else if(p1Lives==1) {
            heartX.remove(heartX.size()-2);System.out.println("2");
        }
        else if(p1Lives==0) {
            heartX.remove(heartX.size()-1);
            car1Draw=false;System.out.println("3");
            carX1=2000;
            carY1=2000;
            p1Alive=false;
            moveLeft1=false;
            moveUp1=false;
            moveDown1=false;
            moveUp1=false;
        }
    }
    
    public void lifeCounterp2(int p2Lives) {
        if(p2Lives==2) {
            heartX.remove(2);
            System.out.println("4");

        }
        else if(p2Lives==1) {
            heartX.remove(1);System.out.println("5");
        }
        else if(p2Lives==0) {
            heartX.remove(0);
            car2Draw=false;System.out.println("6");
            carX2=3000;
            carY2=3000;
            p2Alive=false;
            moveLeft2=false;
            moveUp2=false;
            moveDown2=false;
            moveUp2=false;
        }
    }

    public void carsColl(Graphics g) {        
            if(carX1<=carX2+187 && carX2<=carX1+187 && carY1<=carY2+87 && carY2<=carY1+87) {

                if ( carY1>carY2) {
                    moveUp1=false;
                    moveDown2=false;
                }    
                if ( carY2>carY1) {
                    moveUp2=false;
                    moveDown1=false;
                }
                if(carX1>carX2) {
                    moveLeft1=false;
                    moveRight2=false;
                }
                if(carX2>carX1) {
                    moveLeft2=false;
                    moveRight1=false;
                }
                System.out.println("hello");
                
            
            }
    }    
    
    public void checkCars() {
        if(carX1<=carX2+187 && carX2<=carX1+187 && carY1<=carY2+87 && carY2<=carY1+87) {
            if ( carY1>carY2) {
                moveUp1=false;
                moveDown2=false;
            }
            if ( carY2>carY1) {
                moveUp2=false;
                moveDown1=false;
            }
    
        }
    }
    
    public void checkCars2() {
        if(carX1<=carX2+187 && carX2<=carX1+187 && carY1<=carY2+87 && carY2<=carY1+87) {
            if(carX1>carX2) {
                moveLeft1=false;
                moveRight2=false;
            }
            if(carX2>carX1) {
                moveLeft2=false;
                moveRight1=false;
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
            timeP1++;
            timeP2++;
        
        if(moveLeft1==true) {
            carX1=carX1-10;
        }
        if(moveRight1==true) {
            carX1=carX1+10;
        }
        if(moveUp1==true) {
            carY1=carY1-10;
        }
        if(moveDown1==true) {
            carY1=carY1+10;
        }
        if(moveLeft2==true) {
            carX2=carX2-10;
        }
        if(moveRight2==true) {
            carX2=carX2+10;
        }
        if(moveUp2==true) {
            carY2=carY2-10;
        }
        if(moveDown2==true) {
            carY2=carY2+10;
        }
        repaint();



    }

    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
        int key=e.getKeyCode();
        if(key==KeyEvent.VK_A) {
            moveLeft1=true;checkCars2();
            
        }
        if(key==KeyEvent.VK_W ) {
            moveUp1=true;checkCars();
        }
        if(key==KeyEvent.VK_D) {
            moveRight1=true;checkCars2();
        }
        if(key==KeyEvent.VK_S) {
            moveDown1=true;checkCars();
        }
        if(key==KeyEvent.VK_LEFT) {

            moveLeft2=true;checkCars2();
        }
        if(key==KeyEvent.VK_UP ) {
            moveUp2=true;checkCars();
        }
        if(key==KeyEvent.VK_RIGHT) {
            moveRight2=true;checkCars2();
        }
        if(key==KeyEvent.VK_DOWN) {
            moveDown2=true;checkCars();
        }
        if(key==KeyEvent.VK_SPACE && timeP1>50) {
            
            bulletX1.add(carX1);
            bulletY1.add(carY1+47);
            System.out.println(bulletY1.get(bulletY1.size()-1));
            timeP1=0;
        }
        if(key==KeyEvent.VK_ENTER && timeP2>50) {
            
            bulletX2.add(carX2);
            bulletY2.add(carY2+47);
            System.out.println(bulletY2.get(bulletY2.size()-1));
            timeP2=0;
        }
        

    }

    public void keyReleased(KeyEvent e) {
        int key=e.getKeyCode();
        if(key==KeyEvent.VK_A) {
            moveLeft1=false;
        }
        if(key==KeyEvent.VK_D) {
            moveRight1=false;
        }
        if(key==KeyEvent.VK_W) {
            moveUp1=false;
        }
        if(key==KeyEvent.VK_S) {
            moveDown1=false;
        }
        if(key==KeyEvent.VK_LEFT) {

            moveLeft2=false;
        }
        if(key==KeyEvent.VK_UP ) {
            moveUp2=false;
        }
        if(key==KeyEvent.VK_RIGHT) {
            moveRight2=false;
        }
        if(key==KeyEvent.VK_DOWN) {
            moveDown2=false;
        }

    }
    
    private void formMouseClicked(java.awt.event.MouseEvent evt, Graphics g) {// GEN-FIRST:event_formMouseClicked
        mousex=evt.getX();
        mousey=evt.getY();
        System.out.println(mousex+","+mousey);
        
        
    }
    // GEN-LAST:event_formMouseClicked
        
    private void initComponents() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    
        this.setLayout(layout);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Graphics g = null;
                formMouseClicked(evt, g);
            }
        });
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 400, Short.MAX_VALUE)
                );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 300, Short.MAX_VALUE)
                );


    }
}

