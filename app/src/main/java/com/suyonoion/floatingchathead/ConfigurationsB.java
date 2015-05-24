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
		setContentView(setResource("activity_configurationsb","layout"));

		icon = (ImageView)findViewById(setResource("imageViewB1","id"));


		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ConfigurationsB.this);
		if(prefs.getString("ikonb", "suyono").equals("ion0")){
			icon.setImageResource(setResource("ion0","mipmap"));
		}
        else
        if(prefs.getString("ikonb", "suyono").equals("ion1")){
			icon.setImageResource(setResource("ion1","mipmap"));
		}
        else
        if(prefs.getString("ikonb", "suyono").equals("ion2")){
			icon.setImageResource(setResource("ion2","mipmap"));
		}
        else
        if(prefs.getString("ikonb", "suyono").equals("ion3")){
            icon.setImageResource(setResource("ion3","mipmap"));
        }
        else
        if(prefs.getString("ikonb", "suyono").equals("ion4")){
            icon.setImageResource(setResource("ion4","mipmap"));
        }
        else
        if(prefs.getString("ikonb", "suyono").equals("ion5")){
            icon.setImageResource(setResource("ion5","mipmap"));
        }
        else
        if(prefs.getString("ikonb", "suyono").equals("ion6")){
            icon.setImageResource(setResource("ion6","mipmap"));
        }
        else
        if(prefs.getString("ikonb", "suyono").equals("ion7")){
            icon.setImageResource(setResource("ion7","mipmap"));
        }
        else
        if(prefs.getString("ikonb", "suyono").equals("ion8")){
            icon.setImageResource(setResource("ion8","mipmap"));
        }
        else
        if(prefs.getString("ikonb", "suyono").equals("ion9")){
            icon.setImageResource(setResource("ion9","mipmap"));
        }
        else
        if(prefs.getString("ikonb", "suyono").equals("ion10")){
            icon.setImageResource(setResource("ion10","mipmap"));
        }
        else
        if(prefs.getString("ikonb", "suyono").equals("garuda1")){
            icon.setImageResource(setResource("garuda1","mipmap"));
        }
        ImageButton image0 = (ImageButton)findViewById(setResource("imageButtonB0","id"));
        image0.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                setPreferences("ion0");
                icon.setImageResource(setResource("ion0","mipmap"));
            }
        });
        ImageButton image1 = (ImageButton)findViewById(setResource("imageButtonB1","id"));
		image1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				setPreferences("ion1");
				icon.setImageResource(setResource("ion1","mipmap"));
			}
		});
		ImageButton image2 = (ImageButton)findViewById(setResource("imageButtonB2","id"));
		image2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setPreferences("ion2");
				icon.setImageResource(setResource("ion2","mipmap"));
			}
		});
		ImageButton image3 = (ImageButton)findViewById(setResource("imageButtonB3","id"));
		image3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setPreferences("ion3");
				icon.setImageResource(setResource("ion3","mipmap"));
			}
		});
        ImageButton image4 = (ImageButton)findViewById(setResource("imageButtonB4","id"));
        image4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setPreferences("ion4");
                icon.setImageResource(setResource("ion4","mipmap"));
            }
        });
        ImageButton image5 = (ImageButton)findViewById(setResource("imageButtonB5","id"));
        image5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setPreferences("ion5");
                icon.setImageResource(setResource("ion5","mipmap"));
            }
        });
        ImageButton image6 = (ImageButton)findViewById(setResource("imageButtonB6","id"));
        image6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setPreferences("ion6");
                icon.setImageResource(setResource("ion6","mipmap"));
            }
        });
        ImageButton image7 = (ImageButton)findViewById(setResource("imageButtonB7","id"));
        image7.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setPreferences("ion7");
                icon.setImageResource(setResource("ion7","mipmap"));
            }
        });
        ImageButton image8 = (ImageButton)findViewById(setResource("imageButtonB8","id"));
        image8.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setPreferences("ion8");
                icon.setImageResource(setResource("ion8","mipmap"));
            }
        });
        ImageButton image9 = (ImageButton)findViewById(setResource("imageButtonB9","id"));
        image9.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setPreferences("ion9");
                icon.setImageResource(setResource("ion9","mipmap"));
            }
        });
        ImageButton image10 = (ImageButton)findViewById(setResource("imageButtonB10","id"));
        image10.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setPreferences("ion10");
                icon.setImageResource(setResource("ion10","mipmap"));
            }
        });
        ImageButton imagegaruda1 = (ImageButton)findViewById(setResource("imageButtonBGaruda1","id"));
        imagegaruda1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setPreferences("garuda1");
                icon.setImageResource(setResource("garuda1","mipmap"));
            }
        });
// RESTORE
		Button restore = (Button)findViewById(setResource("restoreB","id"));
		restore.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setPreferences("suyono");
				icon.setImageResource(setResource("suyono","mipmap"));
			}
		});
// KEMBALI
		Button backHome = (Button)findViewById(setResource("back_mainB","id"));
		backHome.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intentMain = new Intent(ConfigurationsB.this, SambutanAwal.class);
                intentMain.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
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

    public int setResource(String name, String Type)
    {
        return getBaseContext().getResources().getIdentifier(name, Type, getBaseContext().getPackageName());
    }
}
