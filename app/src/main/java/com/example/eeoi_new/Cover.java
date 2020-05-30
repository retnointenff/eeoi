package com.example.eeoi_new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

public class Cover extends AppCompatActivity {
    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover);

        final ProgressBar progress ;

        progress = (ProgressBar)findViewById ( R.id.progressBar );
        if(thread == null || thread.getState () == Thread.State.TERMINATED){
            Runnable runnable = new Runnable () {
                @Override
                public void run() {
                    try{
                        for (int i = 0; i<= 10; i++){
                            final int value = i;
                            Thread.sleep ( 200 );
                            progress.post ( new Runnable () {
                                @Override
                                public void run() {
                                    progress.setProgress ( value );
                                }
                            } );
                        }
                        Intent intent = new Intent (getApplicationContext(), MainActivity.class );
                        startActivity ( intent );
                        finish();
                    }catch (InterruptedException e){
                        e.printStackTrace ();
                    }
                }
            };
            thread = new Thread ( runnable );
            thread.start ();
        }
    }
}
