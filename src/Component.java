import java.applet.Applet;
import java.awt.*;
import java.awt.Color;
import java.lang.Object;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;


/**
 * Created by ${Sangeeth} on 11/12/16.
 */

public class Component extends Applet implements Runnable {

    //public static final long serialVersionUID = 1L;





    public static boolean isRuning = false;
    public static int width = 600;
    //public static int height = 600;


    public static Graphics g;
    public static Image screen;

    public Numbers number;
    public static JFrame frame;
    public static JPanel frame1;
    public static String Titel = "Sangeeth - 2015043";



    public static void main (String args[]){

        Component component = new Component();

        frame = new JFrame();
        frame1 = new JPanel();
        frame.add(component);
        frame.setSize(width+6,width+26);
        frame.setTitle(Titel);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //frame.setUndecorated(true);


        component.start();
    }

    public Component(){

    }

    public void start(){

        requestFocus();
        number = new Numbers();

        init();
        isRuning = true;
        Thread th = new Thread(this);
        th.start();


    }

    public void init(){

        screen = createVolatileImage(width,width);


    }

    public void  run(){

        screen = createVolatileImage(width,width);

        while (isRuning){

            //tick();
            render(g);

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

//    public void tick(){
//
//    }

    public int center = width/2;
    public double time = (int) System.currentTimeMillis();
    public int anim;
    public int anim2;
    public int size = (width - 40)/2;
    public int anim3;
    public int anim4;

    public void render(Graphics g){

        screen = createImage(width,width);
        g = screen.getGraphics();

        //int center = width/2;
        //double time = (int) System.currentTimeMillis();
        //int anim;
        //int anim2;
        //int size = width - 80;
        //int anim3;
        //int anim4;

            //background
            //g.setColor(Color.DARK_GRAY);
            g.setColor(new Color(240,240,240,Color.TRANSLUCENT));
            g.fillRect(0,0,width,width);



            //back oval
            g.setColor(Color.BLACK);
            g.fillOval(20,20,width-40,width-40);

            //mid oval
            g.setColor(Color.LIGHT_GRAY);
            g.fillOval(30,30,width-60,width-60);

            g.setColor(Color.BLACK);
            g.fillOval(290,290,width-580,width-580);

        number.render(g);

        // time numbers line

        double t;


        for (int i=0; i<60 ; i++){
            size = width - 40;
            t = i% 60.0/60 * Math.PI *2;
            anim = center + (int)((Math.sin(t))*(size/2));
            anim2 = center - (int)((Math.cos(t))*(size/2));

            size = width - 80;
            anim3 = (int)((center)+ (Math.sin(t)*size/2));
            anim4 = (int)((center)- (Math.cos(t)*size/2));
            g.setColor(Color.BLACK);
            g.drawLine(anim,anim2,anim3,anim4);

            if ( i % 5 == 0){
                g.drawLine(anim + 1,anim2,anim3 + 1,anim4);
                g.drawLine(anim ,anim2 + 1,anim3 ,anim4 + 1);
                g.drawLine(anim - 1,anim2,anim3 - 1,anim4);
                g.drawLine(anim ,anim2 - 1,anim3 ,anim4 - 1);

            }

        }


        //*****hour hand*****

        DateFormat dateFormat2 = new SimpleDateFormat("HH");
        Calendar cal2 = Calendar.getInstance();
        String h = dateFormat2.format(cal2.getTime());

        int hour = (Integer.parseInt(h) *5);


        size = width - 240;
        anim = center + (int)((Math.sin(hour % 60.0 / 60 * Math.PI*2)* size/2));
        anim2 = center - (int)((Math.cos(hour % 60.0 / 60 * Math.PI*2)*size/2));


        //****drawing the hour hand****

        g.setColor(Color.orange);
        g.drawLine(center,center,anim,anim2);
        g.fillOval(center - 8,center - 8,16,16);
        g.drawLine(center + 1,center,anim + 1,anim2);
        g.drawLine(center ,center + 1,anim ,anim2 + 1);
        g.drawLine(center - 1,center,anim - 1,anim2);
        g.drawLine(center ,center - 1,anim ,anim2 - 1);
        g.drawLine(center + 1,center,anim + 1,anim2);
        g.drawLine(center + 1,center,anim - 1,anim2);
        g.drawLine(center - 1,center,anim + 1,anim2);
        g.drawLine(center - 1,center,anim - 1,anim2);



        // ****minute hand*****

        DateFormat dateFormat1 = new SimpleDateFormat("mm");
        Calendar cal1 = Calendar.getInstance();
        String m = dateFormat1.format(cal1.getTime());


        size = width - 90;

        anim = center + (int)((Math.sin(Integer.parseInt(m) % 60.0 / 60 * Math.PI * 2)*size/2));
        anim2 = center - (int)((Math.cos(Integer.parseInt(m) % 60.0/ 60 * Math.PI * 2)*size/2));

        //***** drawing minute hand ******

        g.setColor(Color.BLUE);

        g.drawLine(center,center,anim,anim2);
        g.drawLine(center + 1,center,anim + 1,anim2);
        g.drawLine(center ,center + 1,anim ,anim2 + 1);
        g.drawLine(center - 1,center,anim - 1,anim2);
        g.drawLine(center ,center - 1,anim ,anim2 - 1);


        // *****second hand******

        DateFormat dateFormat = new SimpleDateFormat("ss");
        Calendar cal = Calendar.getInstance();
        String s = dateFormat.format(cal.getTime());

        size = width - 70;

        time = Integer.parseInt(s) % 60.0 / 60 * Math.PI *2;
        anim = center + (int)(Math.sin(time)*(size/2));
        anim2 = center - (int)(Math.cos(time)*(size/2));


        // ***** Drawing second hand

        g.setColor(Color.RED);
        g.drawLine(center,center,anim,anim2);
        g.fillOval(center-5,center-5,10,10);
        g.drawLine(center + 1,center,anim + 1,anim2);
        g.drawLine(center ,center + 1,anim ,anim2 + 1);
        g.drawLine(center - 1,center,anim - 1,anim2);
        g.drawLine(center ,center - 1,anim ,anim2 - 1);

        g = getGraphics();
        g.drawImage(screen,0,0,width,width,null);
        g.dispose();


    }

}
