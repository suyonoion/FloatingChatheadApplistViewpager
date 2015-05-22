package com.suyonoion.floatingchathead;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListPopupWindow;

import java.util.ArrayList;
import java.util.List;

public class FloatingchatheadAppList extends Service {

	public static  int ID_NOTIFICATION = 2018;

	private WindowManager windowManager;
	private ImageView chatHeadAppList;
	boolean didobelklik = false;
	long lastPressTime;
	private Boolean _enable = true;

	ArrayList<String> myArray;
	ArrayList<PInfo> apps;
	List listAplikasi;

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
		listAplikasi = new ArrayList();
		for(int i=0 ; i<apps.size() ; ++i) {
			listAplikasi.add(apps.get(i));
		}
		windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

		chatHeadAppList = new ImageView(this);
		chatHeadAppList.setImageResource(R.mipmap.suyono);
        // mengatur icon di setting mulai
        if(prefs.getString("ICON", "suyono").equals("ion0")){
            chatHeadAppList.setImageResource(R.mipmap.ion0);
        }
        else
        if(prefs.getString("ICON", "suyono").equals("ion1")){
            chatHeadAppList.setImageResource(R.mipmap.ion1);
        }
        else
        if(prefs.getString("ICON", "suyono").equals("ion2")){
            chatHeadAppList.setImageResource(R.mipmap.ion2);
        }
        else
        if(prefs.getString("ICON", "suyono").equals("ion3")){
            chatHeadAppList.setImageResource(R.mipmap.ion3);
        }
        else
        if(prefs.getString("ICON", "suyono").equals("ion4")) {
            chatHeadAppList.setImageResource(R.mipmap.ion4);
        }
        else
        if(prefs.getString("ICON", "suyono").equals("ion5")) {
            chatHeadAppList.setImageResource(R.mipmap.ion5);
        }
        else
        if(prefs.getString("ICON", "suyono").equals("ion6")) {
            chatHeadAppList.setImageResource(R.mipmap.ion6);
        }
        else
        if(prefs.getString("ICON", "suyono").equals("ion7")) {
            chatHeadAppList.setImageResource(R.mipmap.ion7);
        }
        else
        if(prefs.getString("ICON", "suyono").equals("ion8")) {
            chatHeadAppList.setImageResource(R.mipmap.ion8);
        }
        else
        if(prefs.getString("ICON", "suyono").equals("ion9")) {
            chatHeadAppList.setImageResource(R.mipmap.ion9);
        }
        else
        if(prefs.getString("ICON", "suyono").equals("ion10")) {
            chatHeadAppList.setImageResource(R.mipmap.ion10);
        }
        else
        if(prefs.getString("ICON", "suyono").equals("garuda1")) {
            chatHeadAppList.setImageResource(R.mipmap.garuda1);
        }
        // mengatur icon di setting selesai

		final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
				WindowManager.LayoutParams.WRAP_CONTENT,
				WindowManager.LayoutParams.WRAP_CONTENT,
				WindowManager.LayoutParams.TYPE_PHONE,
				WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
				PixelFormat.TRANSLUCENT);

		params.gravity = Gravity.TOP | Gravity.LEFT;


		windowManager.addView(chatHeadAppList, params);
		try {
			chatHeadAppList.setOnTouchListener(new View.OnTouchListener() {
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


						// Jika diklik 2x...
						if (pressTime - lastPressTime <= 300) {
							createNotification();
							FloatingchatheadAppList.this.stopSelf();
							didobelklik = true;
						}
						else {     // If tidak diklik 2x....
							didobelklik = false;
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
						windowManager.updateViewLayout(chatHeadAppList, paramsF);
						break;
					}
					return false;
				}
			});
		} catch (Exception e) {
			// TODO: handle exception
		}

		chatHeadAppList.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				tampilkanPopupWindow(chatHeadAppList);
				_enable = false;
			}
		});

	}

   	private void tampilkanPopupWindow(View anchor) {
		try {
			Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
			ListPopupWindow popup = new ListPopupWindow(this);
            popup.setBackgroundDrawable(getApplicationContext().getResources().getDrawable(R.drawable.popup_window));
			popup.setAnchorView(anchor);
			popup.setWidth((int) (display.getWidth()/ 1.5));
			popup.setAdapter(new CustomAdapter(getApplicationContext(), R.layout.tempat_app_list, listAplikasi));
			popup.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View view, int position, long id3) {
					Intent i;
					PackageManager manager = getPackageManager();
					try {
						i = manager.getLaunchIntentForPackage(apps.get(position).pname.toString());
						if (i == null)
							throw new PackageManager.NameNotFoundException();
						i.addCategory(Intent.CATEGORY_LAUNCHER);
						startActivity(i);
					} catch (PackageManager.NameNotFoundException e) {

					}
				}
			});
			popup.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createNotification(){
		Intent notificationIntent = new Intent(getApplicationContext(), FloatingchatheadAppList.class);
		PendingIntent pendingIntent = PendingIntent.getService(getApplicationContext(), 0, notificationIntent, 0);

		Notification notification = new Notification(R.mipmap.suyono, getResources().getString(R.string.pemberitahuan_applist),System.currentTimeMillis());
		notification.setLatestEventInfo(getApplicationContext(), getResources().getString(R.string.pemberitahuan_applistjudul) ,  getResources().getString(R.string.pemberitahuan_subjudul), pendingIntent);
		notification.flags = Notification.FLAG_AUTO_CANCEL | Notification.FLAG_ONGOING_EVENT;

		NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

		notificationManager.notify(ID_NOTIFICATION,notification);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		if (chatHeadAppList != null) windowManager.removeView(chatHeadAppList);
	}

}