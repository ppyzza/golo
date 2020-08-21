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
    private static final String Mock_API_Promotion = "https://5f3f886e44212d0016fece97.mockapi.io";
    private static final String WEOMNI_NEW = "https://platform.weomni-test.com/promotion/api/";

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

    private OkHttpClient provideClientWithToken() {
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
                        builder.addHeader("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJjYW1wLmNhbXAuZCIsInNob3J0bGluay5saW5rLndyaXRlIiwiYWxpLmRlbGl2ZXJ5LmNyZWF0ZSIsImludmVudG9yeS5jb21wYW55LnciLCJhbGkucXVvdGF0aW9uLmdldCIsImludmVudG9yeS5jb21wYW55LmQiLCJpbnZlbnRvcnkudHJhbnNmZXIuciIsInR5LXByaXZpbGVnZS5lYXJuIiwiYWxpLnRyYWNraW5nLmdldCIsImNhbXAuY2FtcC53IiwiaW52ZW50b3J5LnByb2R1Y3QudyIsImludmVudG9yeS5wcm9kdWN0LnIiLCJjYW1wLmNhbXAuciIsImludmVudG9yeS50cmFuc2Zlci53IiwiY29uc2VudC5yIiwiYWxpLmRlbGl2ZXJ5LmNhbmNlbCIsImludmVudG9yeS5jb21wYW55LnIiLCJ0eS1wcml2aWxlZ2UuYnVybiIsImNtcy5jdC5kIiwiY29uc2VudC53IiwiaW52ZW50b3J5LnByb2R1Y3QuZCIsImludmVudG9yeS53YXJlaG91c2UuZCIsImludmVudG9yeS5sb2NhdGlvbi5yIiwic2hvcnRsaW5rLmxpbmsucmVhZCIsImNtcy5jdC53IiwiY21zLmN0LnMiLCJjYW1wLnJlZGVlbS53IiwiY21zLmN0LnIiLCJpbnZlbnRvcnkud2FyZWhvdXNlLnIiLCJpbnZlbnRvcnkud2FyZWhvdXNlLnciLCJpbnZlbnRvcnkubG9jYXRpb24udyIsImFsaS53YXliaWxsLmdldCIsImFsaS5kZWxpdmVyeS5nZXQiLCJzYWxlLnIiLCJ0eS1wcml2aWxlZ2Uudm9pZCIsImludmVudG9yeS5sb2NhdGlvbi5kIiwiYWxpLmRlbGl2ZXJ5LnByZXBhcmUiLCJ0eS1wcml2aWxlZ2UubWFyay11c2VkIiwic2FsZS53IiwiYWxpLmxvZ2lzdGljLmdldCIsInR5LXByaXZpbGVnZS5jdXN0b21lci5yZWFkIiwic2FsZS5zdW0udyIsImFsaS5kZWxpdmVyeS5zZWFyY2giLCJjYW1wLnNlYXJjaCIsImludmVudG9yeS5hZGp1c3RtZW50LnIiLCJyZWRlZW0ucmVkZWVtLnIiLCJpbnZlbnRvcnkuYWRqdXN0bWVudC53IiwiY21zLmN0LioiXSwiZXhwIjoxNTk4MTE2NzI4LCJpYXQiOjE1OTgwMzAzMjgsImp0aSI6IjVmN2U2Y2I0LTEyNzgtNDcyYS05MThjLTE3YjgwNDg4YTZhYyIsImNsaWVudF9pZCI6ImVhMGE2MjU3LWM3ZGItNGQyYi1hNzUxLTEyZDc4YTE5YmQ4MSJ9.mQm4mY4iykA5-qfMXewqnrGRQ8w3tUtmuQAyaqNhaP3CXOY6GL5W6xgRy-OEebOcc9RXrhVeqXgrT1uzf8xpP5nDojM_SHtN7tye-xBkLolQ0zES8XqOfpWFF6cHJT2HNYrftxEaLiBDSg1ewWSfSj53LnztnqUnTF0bnzevICWXFTKQQfWPE-738r15M11l_5A5DWQEq7IXO3-0PT9RSb_LZnTIJralN_0ro8ZtLvo-FYOZUZpitnbFK7IzS4SjI-umG6GghEYqTp81GvRZs1KHbJB-G8yfF4w5x0IziHHXe-TCMO7jcfBO3XckJQjQdIg3CcCBX3Yr4TaBSDAkUQ");
                        builder.addHeader("Content-Type", "application/json");

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

    private Retrofit provideRetrofit(String baseURL, OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().serializeNulls().create()))
                .build();
    }

    public ApiInterface getPromotion() {
        return provideRetrofit(Mock_API_Promotion, provideClient2())
                .create(ApiInterface.class);
    }

    public ApiInterface getWeomni() {
        return provideRetrofit(WEOMNI_NEW, provideClientWithToken())
                .create(ApiInterface.class);
    }
}
