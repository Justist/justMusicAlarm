package justist.justprograms.android.justmusicalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Debug;
import android.os.PowerManager;
import android.util.Log;
import android.widget.Toast;

import java.util.Calendar;

public class Alarm extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        //PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "");
        //wakeLock.acquire();

        //TODO: Add music library functionality
        Toast.makeText(context, "Text", Toast.LENGTH_LONG).show();
        Log.d("Alarm went off", "hi");

        //wakeLock.release();
    }

    public void SetAlarm(Context context, int hours, int minutes) {
        CancelAlarm(context);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, Alarm.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
        //Log.d("Hours target", Integer.toString(hours));
        int time = timeToMillis(hours, minutes) - getCurrentTimeMillis();
        Log.d("Millis target", Integer.toString(time));
        if (time > 0) {
            alarmManager.set(AlarmManager.RTC_WAKEUP, time, pendingIntent);
        }
    }

    private int timeToMillis(int hours, int minutes) {
        return (360*hours + 60*minutes) * 1000;
    }

    private int getCurrentTimeMillis() {
        Calendar calendar = Calendar.getInstance();
        Log.d("Hours current", Integer.toString(calendar.get(Calendar.HOUR_OF_DAY)));
        return timeToMillis(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE)) + (calendar.get(Calendar.SECOND) * 1000);
    }

    public void CancelAlarm(Context context) {
        Intent intent = new Intent(context, Alarm.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);
    }
}
