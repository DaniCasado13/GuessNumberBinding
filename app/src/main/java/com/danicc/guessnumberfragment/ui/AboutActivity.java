package com.danicc.guessnumberfragment.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.danicc.guessnumberfragment.R;
import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.views.AboutView;


public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AboutView view = AboutBuilder.with(this)
                .setPhoto(R.mipmap.ic_launcher)
                .setCover(R.mipmap.ic_launcher)
                .setName("Dani Casado")
                .setSubTitle("Desarrollador Android")
                .setBrief("App que permite jugar al juego de adivinar un numero usando fragments/navigation y Viewbinding/Databinding.")
                .setAppIcon(R.mipmap.ic_launcher)
                .setAppName(R.string.app_name)
                .addGooglePlayStoreLink("73026784693183521273")
                .addGitHubLink("https://github.com/DaniCasado13/GuessNumberFragment")
                .addFacebookLink("Facebook")
                .addTwitterLink("Twitter")
                .addFiveStarsAction()
                .setVersionNameAsAppSubTitle()
                .addShareAction(R.string.app_name)
                .setWrapScrollView(true)
                .setLinksAnimated(true)
                .setShowAsCard(true)
                .build();
        setContentView(view);
    }
}