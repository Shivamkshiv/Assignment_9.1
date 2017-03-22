package mr_auspicious.shivam_kr_shiv.com.preferences;

import android.os.Bundle;
import android.preference.PreferenceActivity;


public class User_Settings extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.user_settings);
    }
}
