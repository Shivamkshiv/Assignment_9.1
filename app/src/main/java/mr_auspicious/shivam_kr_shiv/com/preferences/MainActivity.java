package mr_auspicious.shivam_kr_shiv.com.preferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private static final int RESULT_SETTINGS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button button = (Button) findViewById(R.id.b1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this,User_Settings.class);
                startActivityForResult(i,RESULT_SETTINGS);

            }
        });


        showUserSettings();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case RESULT_SETTINGS:
                showUserSettings();
                break;

        }

    }

    private void showUserSettings() {
        SharedPreferences sharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(this);

        StringBuilder builder = new StringBuilder();

        builder.append(" Password: "
                + sharedPrefs.getString("user_password", "No password"));

        builder.append("\n Screen Lock:"
                + sharedPrefs.getBoolean("lock_screen", true));

        builder.append("\n Update Frequency: "
                + sharedPrefs.getString("update_frequency", "0"));

        TextView settingsTextView = (TextView) findViewById(R.id.t1);

        settingsTextView.setText(builder.toString());
    }
}
