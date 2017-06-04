package com.example.chat.neurabotio.Helper;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by andhana on 6/4/2017.
 */

public class DataHandler {
    static String stream=null;

    public DataHandler() {
    }

    public String GetHttpData(String urlString)
    {
        try{
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK)
            {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                BufferedReader r = new BufferedReader(new InputStreamReader(in));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = r.readLine())!=null)
                    sb.append(line);
                stream = sb.toString();
                urlConnection.disconnect();
            }
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {

        }
        return stream;
    }
}
