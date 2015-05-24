package com.suyonoion.floatingchathead;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.List;

public class FloatingchatheadViewPager extends Service {

	public static  int ID_NOTIFICATION1 = 2021;
	private WindowManager windowManager;
	private ImageView chatHeadViewPager;
	boolean diDobelKlik = false;
	long lastPressTime;
	private Boolean _enable = true;
    private PopupWindow popupViewpager;
    private Button tutup;
    private Button sembunyikan;

	ArrayList<String> myArray;
	ArrayList<PInfo> apps;
	List listCity;

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override 
	public void onCreate() {
		super.onCreate();
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		RetrievePackages getInstalledPackages = new RetrievePackages(getApplicationContext());
		apps = getInstalledPackages.getInstalledApps(false);
		myArray = new ArrayList<String>();

		for(int i=0 ; i<apps.size() ; ++i) {
			myArray.add(apps.get(i).appname);
		}

		listCity = new ArrayList();
		for(int i=0 ; i<apps.size() ; ++i) {
			listCity.add(apps.get(i));
		}

		windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
		chatHeadViewPager = new ImageView(this);
		chatHeadViewPager.setImageResource(setResource("suyono","mipmap"));
        // mengatur icon di setting mulai
        if(prefs.getString("ikonb", "ion1").equals("ion0")){
            chatHeadViewPager.setImageResource(setResource("ion0","mipmap"));
        }
        else
        if(prefs.getString("ikonb", "ion1").equals("ion1")){
            chatHeadViewPager.setImageResource(setResource("ion1","mipmap"));
        }
        else
        if(prefs.getString("ikonb", "ion1").equals("ion2")){
            chatHeadViewPager.setImageResource(setResource("ion2","mipmap"));
        }
        else
        if(prefs.getString("ikonb", "ion1").equals("ion3")){
            chatHeadViewPager.setImageResource(setResource("ion3","mipmap"));
        }
        else
        if(prefs.getString("ikonb", "ion1").equals("ion4")) {
            chatHeadViewPager.setImageResource(setResource("ion4","mipmap"));
        }
        else
        if(prefs.getString("ikonb", "ion1").equals("ion5")) {
            chatHeadViewPager.setImageResource(setResource("ion5","mipmap"));
        }
        else
        if(prefs.getString("ikonb", "ion1").equals("ion6")) {
            chatHeadViewPager.setImageResource(setResource("ion6","mipmap"));
        }
        else
        if(prefs.getString("ikonb", "ion1").equals("ion7")) {
            chatHeadViewPager.setImageResource(setResource("ion7","mipmap"));
        }
        else
        if(prefs.getString("ikonb", "ion1").equals("ion8")) {
            chatHeadViewPager.setImageResource(setResource("ion8","mipmap"));
        }
        else
        if(prefs.getString("ikonb", "ion1").equals("ion9")) {
            chatHeadViewPager.setImageResource(setResource("ion9","mipmap"));
        }
        else
        if(prefs.getString("ikonb", "ion1").equals("ion10")) {
            chatHeadViewPager.setImageResource(setResource("ion10","mipmap"));
        }
        else
        if(prefs.getString("ikonb", "ion1").equals("garuda1")) {
            chatHeadViewPager.setImageResource(setResource("garuda1","mipmap"));
        }
        // mengatur icon di setting selesai

		final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
				WindowManager.LayoutParams.WRAP_CONTENT,
				WindowManager.LayoutParams.WRAP_CONTENT,
				WindowManager.LayoutParams.TYPE_PHONE,
				WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
				PixelFormat.TRANSLUCENT);
        params.gravity = Gravity.TOP|Gravity.CENTER;

		windowManager.addView(chatHeadViewPager, params);
		try {
			chatHeadViewPager.setOnTouchListener(new View.OnTouchListener() {
				private WindowManager.LayoutParams paramsF = params;
				private int initialX;
				private int initialY;
				private float initialTouchX;
				private float initialTouchY;

				@Override public boolean onTouch(View v, MotionEvent event) {
					switch (event.getAction()) {
					case MotionEvent.ACTION_DOWN:
						// dapatkan waktu dalam nano detik.
						long pressTime = System.currentTimeMillis();
						// jika di dobel klik...
						if (pressTime - lastPressTime <= 300) {
							buatNotifikasi();
							FloatingchatheadViewPager.this.stopSelf();
							diDobelKlik = true;
						}
						else {     // jika tidak di dobel klik....
							diDobelKlik = false;
						}
						lastPressTime = pressTime; 
						initialX = paramsF.x;
						initialY = paramsF.y;
						initialTouchX = event.getRawX();
						initialTouchY = event.getRawY();
						break;
					case MotionEvent.ACTION_UP:
						break;
					case MotionEvent.ACTION_MOVE:
						paramsF.x = initialX + (int) (event.getRawX() - initialTouchX);
						paramsF.y = initialY + (int) (event.getRawY() - initialTouchY);
						windowManager.updateViewLayout(chatHeadViewPager, paramsF);
						break;
					}
					return false;
				}
			});
		} catch (Exception e) {
			// TODO: handle exception
		}

		chatHeadViewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                LayoutInflater inflater=(LayoutInflater) getSystemService(getApplicationContext().LAYOUT_INFLATER_SERVICE);
                View popup = inflater.inflate(setResource("tampilkan_viewpager","layout"), null, true);
                popupViewpager = new PopupWindow(getApplicationContext());
                popupViewpager.setContentView(popup);
                popupViewpager.setWindowLayoutMode(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                popupViewpager.setHeight(1);
                popupViewpager.setWidth(1);
                popupViewpager.setFocusable(true);
                popupViewpager.setBackgroundDrawable(getApplicationContext().getResources().getDrawable(setResource("popup_window","drawable")));
                popupViewpager.showAsDropDown(chatHeadViewPager);
                popupViewpager.showAtLocation(chatHeadViewPager, Gravity.NO_GRAVITY, 0, 0);
                sembunyikan = (Button) popup.findViewById((setResource("sembunyikan","id")));
                sembunyikan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        buatNotifikasi();
                        FloatingchatheadViewPager.this.stopSelf();
                        diDobelKlik = true;
                    }
                });
                tutup = (Button) popup.findViewById(setResource("dismiss","id"));
                tutup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupViewpager.dismiss();
                    }
                });
            }
        });

	}


	public void buatNotifikasi(){
		Intent notificationIntent = new Intent(getApplicationContext(), FloatingchatheadViewPager.class);
		PendingIntent pendingIntent = PendingIntent.getService(getApplicationContext(), 0, notificationIntent, 0);
		Notification notification = new Notification(setResource("suyono","mipmap"), getResources().getString(setResource("pemberitahuan_viewpager","string")),System.currentTimeMillis());
		notification.setLatestEventInfo(getApplicationContext(), getResources().getString(setResource("pemberitahuan_viewpagerjudul","string")) ,  getResources().getString(setResource("pemberitahuan_subjudul","string")), pendingIntent);
		notification.flags = Notification.FLAG_AUTO_CANCEL | Notification.FLAG_ONGOING_EVENT;
		NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
		notificationManager.notify(ID_NOTIFICATION1,notification);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		if (chatHeadViewPager != null) windowManager.removeView(chatHeadViewPager);
	}
    public int setResource(String name, String Type)
    {
        return getBaseContext().getResources().getIdentifier(name, Type, getBaseContext().getPackageName());
    }
}