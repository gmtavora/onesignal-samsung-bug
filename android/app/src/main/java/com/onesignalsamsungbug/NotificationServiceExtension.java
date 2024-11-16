package com.onesignalsamsungbug;

import androidx.annotation.Keep;
import android.util.Log;
import org.json.JSONObject;
import org.json.JSONException;

import com.onesignal.OneSignal;
import com.onesignal.notifications.IDisplayableMutableNotification;
import com.onesignal.notifications.INotificationReceivedEvent;
import com.onesignal.notifications.INotificationServiceExtension;

@Keep // Keep is required to prevent minification from renaming or removing your class
public class NotificationServiceExtension implements INotificationServiceExtension {
  @Override
  public void onNotificationReceived(INotificationReceivedEvent event) {
    IDisplayableMutableNotification notification = event.getNotification();
    //JSONObject data = notification.getAdditionalData();
    int count = 10;

    OneSignal.getNotifications().clearAllNotifications();

    notification.setExtender(builder -> builder.setNumber(count));
  }
}