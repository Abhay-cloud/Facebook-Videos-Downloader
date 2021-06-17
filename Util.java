package com.hcr2bot.statussaver;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;

public class Util {

    public static String RootDirectoryFacebook = "/Story Saver/facebook/";
    public static String RootDirectorySharechat = "/Story Saver/sharechat/";
    public static String RootDirectoryInstagram = "/Story Saver/instagram/";
    public static String RootDirectoryYouTube = "/Story Saver/youtube/";

    public static void download(String downloadPath, String destinationPath, Context context, String fileName){
        Toast.makeText(context, "Downloading started...", Toast.LENGTH_SHORT).show();
        Uri uri = Uri.parse(downloadPath);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setTitle(fileName);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, destinationPath + fileName);
        ((DownloadManager)context.getSystemService(Context.DOWNLOAD_SERVICE)).enqueue(request);
    }

}
