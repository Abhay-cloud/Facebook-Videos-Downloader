package com.hcr2bot.statussaver;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ashudevs.facebookurlextractor.FacebookExtractor;
import com.ashudevs.facebookurlextractor.FacebookFile;
import com.hcr2bot.statussaver.databinding.ActivityFacebookBinding;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class facebook extends AppCompatActivity {

    private ActivityFacebookBinding binding;
    private facebook activity;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_facebook);

        activity = this;
        dialog = new ProgressDialog(this);
        dialog.setMessage("working on your request...");
        dialog.setCancelable(false);


    binding.fbDownload.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (TextUtils.isEmpty(binding.fburl.getText().toString())) {
                        Toast.makeText(activity, "Please enter an URL.", Toast.LENGTH_SHORT).show();
                        binding.fburl.setText("");

                    } else {
                        getFacebookData();

                    }


        }
    });


    }

    private void getFacebookData() {
        dialog.show();
        new FacebookExtractor()
        {
            @Override
            protected void onExtractionComplete(FacebookFile facebookFile) {
                dialog.dismiss();
                String videoUrl = facebookFile.getUrl();

                Util.download(videoUrl, Util.RootDirectoryFacebook, activity, facebookFile.getAuthor() + ".mp4");

                binding.fburl.setText("");
            }

            @Override
            protected void onExtractionFail(String error) {
                dialog.dismiss();
                Log.e("myapp","Error :  "+error);
                Toast.makeText(activity, "Not valid URL", Toast.LENGTH_SHORT).show();
                binding.fburl.setText("");
            }
        }.Extractor(facebook.this,binding.fburl.getText().toString());

    }

}