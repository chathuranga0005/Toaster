package digital.serverclub.mylibrary;

import android.content.Context;
import android.widget.Toast;

public class Send_Mail {

    public static void send(Context c, String mail,String message){

        Toast.makeText(c,message,Toast.LENGTH_SHORT).show();
        //Send Mail
        JavaMailAPI javaMailAPI = new JavaMailAPI(c,mail,"Mail Server Testing",message);

        javaMailAPI.execute();
    }
}
