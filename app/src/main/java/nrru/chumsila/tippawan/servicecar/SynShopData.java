package nrru.chumsila.tippawan.servicecar;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by masterUNG on 12/12/2016 AD.
 */

public class SynShopData extends AsyncTask<String, Void, String>{

    //Explicit
    private static final String strPHP = "http://swiftcodingthai.com/joy1/get_shop_where_shop.php";
    private Context context;

    public SynShopData(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("Shop", strings[0])
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(strPHP).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            Log.d("12devV2", "e doin ==> " + e.toString());
            return null;
        }


    }
}   // Main Class
