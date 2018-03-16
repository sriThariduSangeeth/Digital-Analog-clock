import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;



/**
 * Created by ${Sangeeth} on 11/12/16.
 */

public class Numbers extends JPanel{

    public static String Titel1 = "SANGEETH";
    public static String Titel3 = " SDP CW1";
    public static String Titel2 = "\n \n 2015043 - W1583029";

    //private static final long serialVersionUID = 1L;

    public int width = Component.width;
    public int center = width / 2;

    public void setFont(Font font){
        super.setFont(font);
        repaint();
    }

    public String getDay() {

        DateFormat dateFormat = new SimpleDateFormat("dd");
        Calendar cal = Calendar.getInstance();
        String s = dateFormat.format(cal.getTime());
        int day = Integer.parseInt(s);
        String d = day + "";

        switch (day){
            case 1:
            case 21:
            case 31:
                d += "st";
                break;
            case 2:
            case 22:
                d += "nd";
                break;
            case 3:
            case 23:
                d += "rd";
                break;
            default:
                d += "th";

        } return d;
    }

    public String getHour(){

        DateFormat dateFormat = new SimpleDateFormat("HH");
        Calendar cal = Calendar.getInstance();
        String s = dateFormat.format(cal.getTime());
        int hour = Integer.parseInt(s) - 1;

        String n;
        if (hour<10){
            n = "0"+hour;
        }else{
            n = "" +hour;
        }
        return n;
    }

    public String getMonth(){

        DateFormat dateFormat = new SimpleDateFormat("MM");
        Calendar cal = Calendar.getInstance();
        String s = dateFormat.format(cal.getTime());
        int month = Integer.parseInt(s);

        String m = "";
        switch (month){
            case 1:
                m = "January";
                break;
            case 2:
                m = "February";
                break;
            case 3:
                m = "March";
                break;
            case 4:
                m = "April";
                break;
            case 5:
                m = "May";
                break;
            case 6:
                m = "June";
                break;
            case 7:
                m = "Jule";
                break;
            case 8:
                m = "August";
                break;
            case 9:
                m = "September";
                break;
            case 10:
                m = "October";
                break;
            case 11:
                m = "November";
                break;
            case 12:
                m = "December";
                break;
        }
        return m;

    }

    public void render(Graphics g){

        g.setColor(Color.YELLOW);

        DateFormat dateFormat = new SimpleDateFormat(":mm:ss");
        Calendar cal = Calendar.getInstance();
        String s = dateFormat.format(cal.getTime());
        int n = center - ((s.length()*13)/2);

        g.setFont(new Font("Arial",1,20));
        s = (Integer.parseInt(getHour(),10)%12+1)+""+dateFormat.format(cal.getTime());
        n = center - (s.length()*10/2);

        g.setColor(Color.DARK_GRAY);
        g.fillRoundRect(250,348,100,30,6,6);

        g.setColor(Color.WHITE);
        g.fillRoundRect(252,350,96,26,6,6);

        g.setColor(Color.BLACK);
        g.drawString("TIME",275,345);
        g.drawString("DATE",275,225);
        g.drawString("AM",255,485);
        g.drawString("PM",315,485);
        g.drawString( s, n, 370);

        int p = Integer.parseInt(getHour(),10);

        if ( p < 11 || p == 24){
            g.setColor(Color.WHITE);
            g.drawString("Good Morning",230,430);
            g.setColor(Color.BLACK);
            g.fillOval(265,440,10,10);
            g.drawOval(325,440,10,10);

        }else {
            g.setColor(Color.WHITE);
            g.drawString("Happy Evening",230,430);
            g.setColor(Color.BLACK);
            g.drawOval(265,450,10,10);
            g.fillOval(325,450,10,10);
        }

        dateFormat = new SimpleDateFormat("yyyy");
        cal = Calendar.getInstance();


        s = getDay() + " "+ getMonth() + ","+ dateFormat.format(cal.getTime());
        n = center - (int) ((s.length()*10.25)/2);

        g.setColor(Color.DARK_GRAY);
        g.fillRoundRect(204,228,200,30,6,6);

        g.setColor(Color.WHITE);
        g.fillRoundRect(206,230,196,26,6,6);

        g.setColor(Color.BLUE);
        g.drawString(s, n, 250);

        //set "Sangeeth" titel
        g.setColor(Color.BLACK);
        s = Titel1;
        n = center - (int)((s.length()*10)/2);
        g.drawString(s, n, 120);

        //set "SDP" titel
        g.setColor(Color.DARK_GRAY);
        s = Titel3;
        n = center - (int)((s.length()*10)/2);
        g.drawString(s, n, 150);

        //set "index" titel
        g.setColor(Color.DARK_GRAY);
        s = Titel2;
        n = center - (int)((s.length()*10)/2);
        g.drawString(s, n, 170);


        //numbers color
        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Arial",0,35));
        int size = width - 100;
        for (int i = 0; i < 12 ; i++){
            double anim = (int) ((Math.sin((i+1)%12.0/12*Math.PI*2)*(size/2)));
            double anim2 = (int) ((Math.cos((i+1)%12.0/12*Math.PI*2)*(size/2)));

            if (i >= 9){
                anim -= 10;
            }
            g.drawString((i+1)+"",center+(int) anim - 6, center - (int) anim2 +12);
        }

    }


}
