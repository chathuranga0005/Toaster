package digital.serverclub.toasterrepo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import digital.serverclub.toasterrepo.MAIL.JavaMailAPI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }



    public void sendMail(String email,String msg) {


        //Send Mail
        JavaMailAPI javaMailAPI = new JavaMailAPI(this,email,"Chathu pathirana testing mail server",msg);

        javaMailAPI.execute();

    }
}