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


public class Configurations extends Activity {

	private ImageView icon;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_configurations);

		icon = (ImageView)findViewById(R.id.imageView1);


		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Configurations.this);
		if(prefs.getString("ICON", "suyono").equals("ion0")){
			icon.setImageResource(R.mipmap.ion0);
		}
        else
        if(prefs.getString("ICON", "suyono").equals("ion1")){
			icon.setImageResource(R.mipmap.ion1);
		}
        else
        if(prefs.getString("ICON", "suyono").equals("ion2")){
			icon.setImageResource(R.mipmap.ion2);
		}
        else
        if(prefs.getString("ICON", "suyono").equals("ion3")){
            icon.setImageResource(R.mipmap.ion3);
        }
        else
        if(prefs.getString("ICON", "suyono").equals("ion4")){
            icon.setImageResource(R.mipmap.ion4);
        }
        else
        if(prefs.getString("ICON", "suyono").equals("ion5")){
            icon.setImageResource(R.mipmap.ion5);
        }
        else
        if(prefs.getString("ICON", "suyono").equals("ion6")){
            icon.setImageResource(R.mipmap.ion6);
        }
        else
        if(prefs.getString("ICON", "suyono").equals("ion7")){
            icon.setImageResource(R.mipmap.ion7);
        }
        else
        if(prefs.getString("ICON", "suyono").equals("ion8")){
            icon.setImageResource(R.mipmap.ion8);
        }
        else
        if(prefs.getString("ICON", "suyono").equals("ion9")){
            icon.setImageResource(R.mipmap.ion9);
        }
        else
        if(prefs.getString("ICON", "suyono").equals("ion10")){
            icon.setImageResource(R.mipmap.ion10);
        }
        else
        if(prefs.getString("ICON", "suyono").equals("garuda1")){
            icon.setImageResource(R.mipmap.garuda1);
        }
        ImageButton image0 = (ImageButton)findViewById(R.id.imageButton0);
        image0.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                setPreferences("ion0");
                icon.setImageResource(R.mipmap.ion0);
            }
        });
        ImageButton image1 = (ImageButton)findViewById(R.id.imageButton1);
		image1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				setPreferences("ion1");
				icon.setImageResource(R.mipmap.ion1);
			}
		});
		ImageButton image2 = (ImageButton)findViewById(R.id.imageButton2);
		image2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setPreferences("ion2");
				icon.setImageResource(R.mipmap.ion2);
			}
		});
		ImageButton image3 = (ImageButton)findViewById(R.id.imageButton3);
		image3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setPreferences("ion3");
				icon.setImageResource(R.mipmap.ion3);
			}
		});
        ImageButton image4 = (ImageButton)findViewById(R.id.imageButton4);
        image4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setPreferences("ion4");
                icon.setImageResource(R.mipmap.ion4);
            }
        });
        ImageButton image5 = (ImageButton)findViewById(R.id.imageButton5);
        image5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setPreferences("ion5");
                icon.setImageResource(R.mipmap.ion5);
            }
        });
        ImageButton image6 = (ImageButton)findViewById(R.id.imageButton6);
        image6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setPreferences("ion6");
                icon.setImageResource(R.mipmap.ion6);
            }
        });
        ImageButton image7 = (ImageButton)findViewById(R.id.imageButton7);
        image7.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setPreferences("ion7");
                icon.setImageResource(R.mipmap.ion7);
            }
        });
        ImageButton image8 = (ImageButton)findViewById(R.id.imageButton8);
        image8.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setPreferences("ion8");
                icon.setImageResource(R.mipmap.ion8);
            }
        });
        ImageButton image9 = (ImageButton)findViewById(R.id.imageButton9);
        image9.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setPreferences("ion9");
                icon.setImageResource(R.mipmap.ion9);
            }
        });
        ImageButton image10 = (ImageButton)findViewById(R.id.imageButton10);
        image10.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setPreferences("ion10");
                icon.setImageResource(R.mipmap.ion10);
            }
        });
        ImageButton imagegaruda1 = (ImageButton)findViewById(R.id.imageButtonGaruda1);
        imagegaruda1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setPreferences("garuda1");
                icon.setImageResource(R.mipmap.garuda1);
            }
        });

// RESTORE KE DEFAULT
		Button restore = (Button)findViewById(R.id.restore);
		restore.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setPreferences("suyono");
				icon.setImageResource(R.mipmap.suyono);
			}
		});
// KEMBALI KE AKTIVITI MainActivity.class
		Button backHome = (Button)findViewById(R.id.back_main);
		backHome.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intentMain = new Intent(Configurations.this, SambutanAwal.class);
				startActivity(intentMain);
			}
		});
	}


	private void setPreferences(String myIconPref)
	{
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Configurations.this);
		Editor editor = prefs.edit();
		editor.putString("ICON", myIconPref);
		editor.commit();
	}
}
