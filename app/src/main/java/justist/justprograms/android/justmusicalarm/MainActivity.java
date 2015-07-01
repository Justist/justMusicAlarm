package justist.justprograms.android.justmusicalarm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class MainActivity extends Activity {

    private TimePicker timePicker;
    private Alarm alarm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker = (TimePicker) findViewById(R.id.timePicker);

        alarm = new Alarm();

        Button buttonStartAlarm = (Button) findViewById(R.id.startAlarm);
        buttonStartAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarm.SetAlarm(getApplicationContext(), timePicker.getCurrentHour(), timePicker.getCurrentMinute());
            }
        });

        Button buttonCancelAlarm = (Button) findViewById(R.id.cancelAlarm);
        buttonCancelAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarm.CancelAlarm(getApplicationContext());
            }
        });
    }
}
