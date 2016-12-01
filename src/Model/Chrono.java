package Model;

import javax.swing.*;
import java.text.DecimalFormat;

/**
 * Created by ANTOINE on 01/12/2016.
 */
public class Chrono extends Thread {

        JLabel timer;
        boolean commencer;
        double temps=0;

        public Timer(JLabel timer ){

            this.timer=timer;
        }

        public void run(){
            setCommencer(true);
            temps=0;
            while(commencer){
                try{
                    this.sleep(100);
                    temps+=0.1;
                    DecimalFormat df = new DecimalFormat("#######0.0");
                    String str = df.format(temps);
                    timer.setText(str);
                }catch(InterruptedException e){

                }
            }
        }

        public void stopTimer(){

            setCommencer(false);
        }

        public void setCommencer(boolean commencer) {

            this.commencer = commencer;
        }
    }
}

