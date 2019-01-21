# AsyncTaskAndroid
## Android AsyncTask is an abstract class provided by Android which gives us the liberty to perform heavy tasks in the background and keep the UI thread light thus making the application more responsive.

### Android application runs on a single thread when launched. Due to this single thread model tasks that take longer time to fetch the response can make the application non-responsive. To avoid this we use android AsyncTask to perform the heavy tasks in background on a dedicated thread and passing the results back to the UI thread. Hence use of AsyncTask in android application keeps the UI thread responsive at all times.

The basic methods used in an android AsyncTask class are defined below :

1. doInBackground() : This method contains the code which needs to be executed in background. In this method we can send results multiple times to the UI thread by publishProgress() method. To notify that the background processing has been completed we just need to use the return statements.
2. onPreExecute() : This method contains the code which is executed before the background processing starts.
3.onPostExecute() : This method is called after doInBackground method completes processing. Result from doInBackground is passed to this method.
4. onProgressUpdate() : This method receives progress updates from doInBackground method, which is published via publishProgress method, and this method can use this progress update to update the UI thread.
