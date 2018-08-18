package com.common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;

public class NetworkStatus {

    public static boolean isNetworkAvailable(Context context) {
        final ConnectivityManager cManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo netInfo = cManager.getActiveNetworkInfo();
        if (netInfo != null) {
            if (netInfo.isAvailable() && netInfo.isConnected()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOnline() {
        final Runtime runtime = Runtime.getRuntime();
        try {
            final Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            final int exitValue = ipProcess.waitFor();
            return (exitValue == 0);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }
}
