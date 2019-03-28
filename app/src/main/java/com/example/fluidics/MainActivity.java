package com.example.fluidics;

        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Handler;
        import android.support.v7.app.AppCompatActivity;

        import com.example.fluidics.interactors.UserInteractor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserInteractor interactor = UserInteractor.getInstance();
        interactor.seedUsuers(() -> new Handler().postDelayed(() -> {
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
        }, 2000));
    }
}
