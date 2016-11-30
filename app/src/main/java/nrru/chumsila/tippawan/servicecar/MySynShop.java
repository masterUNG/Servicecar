package nrru.chumsila.tippawan.servicecar;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Created by masterUNG on 11/30/2016 AD.
 */

public class MySynShop extends AsyncTask<Void, Void, String>{

    private Context context;
    private static final String urlJSON = "http://swiftcodingthai.com/joy1/get_data.php";

    public MySynShop(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Void... voids) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlJSON).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }
}   // Main Class
