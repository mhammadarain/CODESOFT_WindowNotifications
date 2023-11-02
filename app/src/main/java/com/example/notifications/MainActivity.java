package com.example.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	Button btn_simple, btn_bigtext, btn_bigpicture, btn_inbox, btn_messaging, btn_actions;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//init buttons
		btn_simple =findViewById(R.id.simpleNot);
		btn_bigtext =  findViewById(R.id.bigtextNot);
		btn_bigpicture =findViewById(R.id.bigpictureNot);
		btn_inbox =findViewById(R.id.inboxNot);
		btn_messaging =findViewById(R.id.messagingNot);
		btn_actions = findViewById(R.id.actionNot);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.simpleNot:
				simple_Notification();
				break;

			case R.id.bigtextNot:
				big_textstyle_Notification();
				break;

			case R.id.bigpictureNot:
				big_picturestyle_Notification();
				break;

			case R.id.inboxNot:
				inboxstyle_Notification();
				break;

//			case R.id.messagingNot:
//				messagingstyle_Notification();
//				break;

			case R.id.actionNot:
				notification_Actions();
				break;
		}
	}


	private void simple_Notification() {
		//declare an id for your notification
		//id is used in many things especially when setting action buttons and their intents
		int notificationId = 0;
		//init notification and declare specifications
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
				.setSmallIcon(R.drawable.logo)
				.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.logo))
				.setContentTitle("Android Development")
				.setContentText("Android Development Internship at CodeSoft.")
				.setAutoCancel(true)
				.setDefaults(NotificationCompat.DEFAULT_ALL);

		//set a tone when notification appears
		Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		builder.setSound(path);

		//call notification manager so it can build and deliver the notification to the OS
		NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

		//Android 8 introduced a new requirement of setting the channelId property by using a NotificationChannel.
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			String channelId = "YOUR_CHANNEL_ID";
			NotificationChannel channel = new NotificationChannel(channelId,
					"Channel human readable title",
					NotificationManager.IMPORTANCE_DEFAULT);
			notificationManager.createNotificationChannel(channel);
			builder.setChannelId(channelId);
		}

		notificationManager.notify(notificationId, builder.build());
	}

	private void big_textstyle_Notification() {
		int notificationId = 1;
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		builder.setSmallIcon(R.drawable.logo)
				.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.logo))
				.setContentTitle("Hammad Arain")
				//set the style of your notification and pass parameters for any specific style
				.setStyle(new NotificationCompat.BigTextStyle().bigText(getResources().getString(R.string.CodeSoft)))
				.setAutoCancel(true);

		Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		builder.setSound(path);

		NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			String channelId = "YOUR_CHANNEL_ID";
			NotificationChannel channel = new NotificationChannel(channelId,
					"Channel human readable title",
					NotificationManager.IMPORTANCE_DEFAULT);
			notificationManager.createNotificationChannel(channel);
			builder.setChannelId(channelId);
		}

		notificationManager.notify(notificationId, builder.build());
	}

	private void big_picturestyle_Notification() {
		int notificationId = 2;
		Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.img);
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		builder.setSmallIcon(R.drawable.logo)
				.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.logo))
				.setContentTitle("CodeSoft Internship")
				//style = BigPictureStyle
				.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(picture))
				.setAutoCancel(true);

		Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		builder.setSound(path);

		NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			String channelId = "YOUR_CHANNEL_ID";
			NotificationChannel channel = new NotificationChannel(channelId,
					"Channel human readable title",
					NotificationManager.IMPORTANCE_DEFAULT);
			notificationManager.createNotificationChannel(channel);
			builder.setChannelId(channelId);
		}

		notificationManager.notify(notificationId, builder.build());
	}

	private void inboxstyle_Notification() {
		int notificationId = 3;
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		builder.setSmallIcon(R.drawable.logo)
				.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.logo))
				.setStyle(new NotificationCompat.InboxStyle().addLine("Congratulations").addLine("You Are Selected at CodeSoft Internship").setBigContentTitle("2 New Messages for you").setSummaryText("Inbox"))
				.setAutoCancel(true);

		Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		builder.setSound(path);

		NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			String channelId = "YOUR_CHANNEL_ID";
			NotificationChannel channel = new NotificationChannel(channelId,
					"Channel human readable title",
					NotificationManager.IMPORTANCE_DEFAULT);
			notificationManager.createNotificationChannel(channel);
			builder.setChannelId(channelId);
		}

		notificationManager.notify(notificationId, builder.build());
	}



	private void notification_Actions() {
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "channel_id")
				.setSmallIcon(R.drawable.logo)
				.setContentTitle("CodeSoft ")
				.setContentText("Android Developer ")
				.setPriority(NotificationCompat.PRIORITY_DEFAULT);

		NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
		if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
			return;
		}
		int notificationId = 0;
		notificationManager.notify(notificationId, builder.build());
	}

}