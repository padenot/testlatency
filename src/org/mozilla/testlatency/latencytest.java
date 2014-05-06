package org.mozilla.testlatency;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.widget.TextView;
import android.widget.LinearLayout;

import android.app.Activity;
import android.os.Bundle;

public class latencytest extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        PackageManager pm = getApplicationContext().getPackageManager();
        boolean claimsFeature = pm.hasSystemFeature(PackageManager.FEATURE_AUDIO_LOW_LATENCY);
        AudioManager am = (AudioManager) getSystemService(getApplicationContext().AUDIO_SERVICE);
        String sampleRate = am.getProperty(AudioManager.PROPERTY_OUTPUT_SAMPLE_RATE);
        String framesPerBuffer = am.getProperty(AudioManager.PROPERTY_OUTPUT_FRAMES_PER_BUFFER);

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        TextView label = new TextView(this);
        TextView label2 = new TextView(this);
        TextView label3 = new TextView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        label.setText(claimsFeature ? "Low latency available" : "Low latency unavailable");
        label2.setText(sampleRate);
        label3.setText(framesPerBuffer);
        ll.addView(label, layoutParams);
        ll.addView(label2, layoutParams);
        ll.addView(label3, layoutParams);
        setContentView(ll);
    }
}
