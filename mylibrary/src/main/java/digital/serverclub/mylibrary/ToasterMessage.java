package digital.serverclub.mylibrary;

import android.content.Context;
import android.widget.Toast;

public class ToasterMessage {

    public static void s(Send_sms c, String message){

        Toast.makeText(c,message,Toast.LENGTH_SHORT).show();

    }
}