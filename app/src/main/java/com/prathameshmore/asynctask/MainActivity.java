package com.prathameshmore.asynctask;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnAsyncTask;
    private EditText getSleepTime;
    private String sleepTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAsyncTask = findViewById(R.id.btnAsyncTask);
        getSleepTime = findViewById(R.id.get_sleep_time);
        btnAsyncTask.setOnClickListener(this);

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAsyncTask:
                AsyncTask asyncTask = new AsyncTask();
                asyncTask.execute(getSleepTime.getText().toString());
                break;
        }
    }

    public class AsyncTask extends android.os.AsyncTask<String, String, String> {
        private String resp;


        /**
         * Runs on the UI thread before {@link #doInBackground}.
         *
         * @see #onPostExecute
         * @see #doInBackground
         */
        @Override
        protected void onPreExecute() {
            Toast.makeText(MainActivity.this, "Pre executing method", Toast.LENGTH_SHORT).show();
        }

        /**
         * <p>Runs on the UI thread after {@link #doInBackground}. The
         * specified result is the value returned by {@link #doInBackground}.</p>
         *
         * <p>This method won't be invoked if the task was cancelled.</p>
         *
         * @param s The result of the operation computed by {@link #doInBackground}.
         * @see #onPreExecute
         * @see #doInBackground
         * @see #onCancelled(Object)
         */
        @Override
        protected void onPostExecute(String s) {
            getSleepTime.setText(s);
        }

        /**
         * Override this method to perform a computation on a background thread. The
         * specified parameters are the parameters passed to {@link #execute}
         * by the caller of this task.
         * <p>
         * This method can call {@link #publishProgress} to publish updates
         * on the UI thread.
         *
         * @param strings The parameters of the task.
         * @return A result, defined by the subclass of this task.
         * @see #onPreExecute()
         * @see #onPostExecute
         * @see #publishProgress
         */
        @Override
        protected String doInBackground(String... strings) {
            try {
                int time = Integer.parseInt(strings[0]) * 1000;
                Thread.sleep(time);
                resp = "Slept for " + strings[0] + " seconds";

            } catch (Exception e) {

            }
            return resp;
        }

        /**
         * Runs on the UI thread after {@link #publishProgress} is invoked.
         * The specified values are the values passed to {@link #publishProgress}.
         *
         * @param values The values indicating progress.
         * @see #publishProgress
         * @see #doInBackground
         */
        @Override
        protected void onProgressUpdate(String... values) {
            getSleepTime.setText(values[0]);
            Toast.makeText(MainActivity.this, values[0], Toast.LENGTH_SHORT).show();
        }
    }


}
