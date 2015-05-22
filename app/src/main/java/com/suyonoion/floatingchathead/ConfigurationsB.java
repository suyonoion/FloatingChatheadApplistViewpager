package com.suyonoion.floatingchathead;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


public class ConfigurationsB extends Activity {

	private ImageView icon;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_configurationsb);

		icon = (ImageView)findViewById(R.id.imageViewB1);


		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ConfigurationsB.this);
		if(prefs.getString("ikonb", "ion1").equals("ion0")){
			icon.setImageResource(R.mipmap.ion0);
		}
        else
        if(prefs.getString("ikonb", "ion1").equals("ion1")){
			icon.setImageResource(R.mipmap.ion1);
		}
        else
        if(prefs.getString("ikonb", "ion1").equals("ion2")){
			icon.setImageResource(R.mipmap.ion2);
		}
        else
        if(prefs.getString("ikonb", "ion1").equals("ion3")){
            icon.setImageResource(R.mipmap.ion3);
        }
        else
        if(prefs.getString("ikonb", "ion1").equals("ion4")){
            icon.setImageResource(R.mipmap.ion4);
        }
        else
        if(prefs.getString("ikonb", "ion1").equals("ion5")){
            icon.setImageResource(R.mipmap.ion5);
        }
        else
        if(prefs.getString("ikonb", "ion1").equals("ion6")){
            icon.setImageResource(R.mipmap.ion6);
        }
        else
        if(prefs.getString("ikonb", "ion1").equals("ion7")){
            icon.setImageResource(R.mipmap.ion7);
        }
        else
        if(prefs.getString("ikonb", "ion1").equals("ion8")){
            icon.setImageResource(R.mipmap.ion8);
        }
        else
        if(prefs.getString("ikonb", "ion1").equals("ion9")){
            icon.setImageResource(R.mipmap.ion9);
        }
        else
        if(prefs.getString("ikonb", "ion1").equals("ion10")){
            icon.setImageResource(R.mipmap.ion10);
        }
        else
        if(prefs.getString("ikonb", "ion1").equals("garuda1")){
            icon.setImageResource(R.mipmap.garuda1);
        }
        ImageButton image0 = (ImageButton)findViewById(R.id.imageButtonB0);
        image0.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                setPreferences("ion0");
                icon.setImageResource(R.mipmap.ion0);
            }
        });
        ImageButton image1 = (ImageButton)findViewById(R.id.imageButtonB1);
		image1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				setPreferences("ion1");
				icon.setImageResource(R.mipmap.ion1);
			}
		});
		ImageButton image2 = (ImageButton)findViewById(R.id.imageButtonB2);
		image2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setPreferences("ion2");
				icon.setImageResource(R.mipmap.ion2);
			}
		});
		ImageButton image3 = (ImageButton)findViewById(R.id.imageButtonB3);
		image3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setPreferences("ion3");
				icon.setImageResource(R.mipmap.ion3);
			}
		});
        ImageButton image4 = (ImageButton)findViewById(R.id.imageButtonB4);
        image4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setPreferences("ion4");
                icon.setImageResource(R.mipmap.ion4);
            }
        });
        ImageButton image5 = (ImageButton)findViewById(R.id.imageButtonB5);
        image5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setPreferences("ion5");
                icon.setImageResource(R.mipmap.ion5);
            }
        });
        ImageButton image6 = (ImageButton)findViewById(R.id.imageButtonB6);
        image6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setPreferences("ion6");
                icon.setImageResource(R.mipmap.ion6);
            }
        });
        ImageButton image7 = (ImageButton)findViewById(R.id.imageButtonB7);
        image7.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setPreferences("ion7");
                icon.setImageResource(R.mipmap.ion7);
            }
        });
        ImageButton image8 = (ImageButton)findViewById(R.id.imageButtonB8);
        image8.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setPreferences("ion8");
                icon.setImageResource(R.mipmap.ion8);
            }
        });
        ImageButton image9 = (ImageButton)findViewById(R.id.imageButtonB9);
        image9.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setPreferences("ion9");
                icon.setImageResource(R.mipmap.ion9);
            }
        });
        ImageButton image10 = (ImageButton)findViewById(R.id.imageButtonB10);
        image10.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setPreferences("ion10");
                icon.setImageResource(R.mipmap.ion10);
            }
        });
        ImageButton imagegaruda1 = (ImageButton)findViewById(R.id.imageButtonBGaruda1);
        imagegaruda1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setPreferences("garuda1");
                icon.setImageResource(R.mipmap.garuda1);
            }
        });
// RESTORE
		Button restore = (Button)findViewById(R.id.restoreB);
		restore.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setPreferences("suyono");
				icon.setImageResource(R.mipmap.suyono);
			}
		});
// KEMBALI
		Button backHome = (Button)findViewById(R.id.back_mainB);
		backHome.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intentMain = new Intent(ConfigurationsB.this, SambutanAwal.class);
				startActivity(intentMain);
			}
		});
	}

	private void setPreferences(String myIconPref)
	{
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ConfigurationsB.this);
		Editor editor = prefs.edit();
		editor.putString("ikonb", myIconPref);
		editor.commit();
	}
}
