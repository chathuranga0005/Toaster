package digital.serverclub.mylibrary;

import android.content.Context;
import android.widget.Toast;

import digital.serverclub.toasterrepo.MAIL.JavaMailAPI;

public class SEND {

    public static void SEND_EMAIL(Context c, String message,String email,String msg){

        Toast.makeText(c,message,Toast.LENGTH_SHORT).show();
        //Send Mail
        JavaMailAPI javaMailAPI = new JavaMailAPI(c,email,"Chathu pathirana testing mail server",msg);

        javaMailAPI.execute();

    }
}
