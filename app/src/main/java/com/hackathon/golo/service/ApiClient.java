package com.hackathon.golo.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String WEOMNI_HOME = "";
    private static final String GOLO_HOME = "";
    private static final String TAT_HOME = "https://tatapi.tourismthailand.org";
    private static final String MOCK_API = "https://5f3e5f8c13a9640016a68a1b.mockapi.io/api/v1";
    private static final String Mock_API_Promotion_List = "https://5f3f886e44212d0016fece97.mockapi.io";
    private Gson mGson;

    // public A

    public ApiInterface getBASEToken() {
        return provideRetrofit(MOCK_API + "/", provideClient2())
                .create(ApiInterface.class);
    }

    public TATInterface getBASETATToken() {
        return provideRetrofit(TAT_HOME + "/", provideTAT())
                .create(TATInterface.class);
    }

    private OkHttpClient provideClient2() {
        int READ_TIMEOUT = 15;
        int CONNECTION_TIMEOUT = 15;



        List<CipherSuite> cipherSuites = new ArrayList<>();
        cipherSuites.addAll(ConnectionSpec.MODERN_TLS.cipherSuites());
        cipherSuites.add(CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA);
        cipherSuites.add(CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA);

        ConnectionSpec legacyTls = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                .cipherSuites(cipherSuites.toArray(new CipherSuite[0]))
                .build();

        try {

            OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
                @Override
                public okhttp3.Response intercept(Chain chain) throws IndexOutOfBoundsException {
                    try {
                        Request originalRequest = chain.request();
                        Request.Builder builder = originalRequest.newBuilder();
                        builder.addHeader("x-key", "test");

                        Request newRequest = builder.build();
                        Response response = chain.proceed(newRequest);
                                              return response;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                }
            }).readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                    .connectionSpecs(Arrays.asList(legacyTls, ConnectionSpec.CLEARTEXT))
                    .build();

            return okHttpClient;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private OkHttpClient provideTAT() {
        int READ_TIMEOUT = 15;
        int CONNECTION_TIMEOUT = 15;

        List<CipherSuite> cipherSuites = new ArrayList<>();
        cipherSuites.addAll(ConnectionSpec.MODERN_TLS.cipherSuites());
        cipherSuites.add(CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA);
        cipherSuites.add(CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA);

        ConnectionSpec legacyTls = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                .cipherSuites(cipherSuites.toArray(new CipherSuite[0]))
                .build();

        HttpLoggingInterceptor.Logger networkLayerLogger = new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {


                Log.i("ApiClient", message);
            }
        };
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(networkLayerLogger);
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        try {

            OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
                @Override
                public okhttp3.Response intercept(Chain chain) throws IndexOutOfBoundsException {
                    try {
                        Request originalRequest = chain.request();
                        Request.Builder builder = originalRequest.newBuilder();
                        builder.addHeader("Authorization", "Bearer GUjuQd31FzGhPuopjg3lM32arSZ1Ny(1YaEeMfeVbt2vtE3Xc777t4o4KOZObNLteprO3Q6xeaO3S4sxMOqdxQG=====2");
                        builder.addHeader("Accept-Language", "th");

                        Request newRequest = builder.build();
                        Response response = chain.proceed(newRequest);
                        return response;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                }
            }).readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .addNetworkInterceptor(interceptor)
                    .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                    .connectionSpecs(Arrays.asList(legacyTls, ConnectionSpec.CLEARTEXT))
                    .build();

            return okHttpClient;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Retrofit provideRetrofit(String baseURL, OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().serializeNulls().create()))
                .build();
    }

    public ApiInterface getPromotionList() {
        return provideRetrofit(Mock_API_Promotion_List, provideClient2())
                .create(ApiInterface.class);
    }
}
