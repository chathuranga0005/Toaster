package digital.serverclub.mylibrary;

import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;







     public  class Send_sms extends AsyncTask<String ,Void,String> {
        String msg="";

        Context context;
        public String message=null;
        @Override
        protected String doInBackground(String... params) {


            String updateTeacher="https://slh.nebuloapps.com/SMS/serverclub-sms-api-master/send_sms.php";

            try {

                URL url = new URL(updateTeacher);

                String api_key = params[0];
                String mask = params[1];
                String mobile = params[2];
                String sms = params[3];

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String postData = URLEncoder.encode("api_key", "UTF-8") + "=" + URLEncoder.encode(api_key, "UTF-8") + "&"
                        + URLEncoder.encode("mask", "UTF-8") + "=" + URLEncoder.encode(mask, "UTF-8") + "&"
                        + URLEncoder.encode("mobile", "UTF-8") + "=" + URLEncoder.encode(mobile, "UTF-8") + "&"
                        + URLEncoder.encode("sms", "UTF-8") + "=" + URLEncoder.encode(sms, "UTF-8");

                bufferedWriter.write(postData);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return msg;
        }


        @Override
        protected void onPostExecute(String result) {



            try {
                //token
                JSONObject jo = new JSONObject(result);
                message = jo.getString("message");
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }


