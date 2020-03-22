package com.mp.speach_to_text.A;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.mp.speach_to_text.B.SpeechActivity;
import com.mp.speach_to_text.R;

public class SeungjiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_seungji_activity);

        new SplashActivity().execute();
    }
    class SplashActivity extends AsyncTask<Void, Void, Void>
    {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(1500);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            startActivity(new Intent(SeungjiActivity.this, SpeechActivity.class));
            finish();
        }
    }
}
