package rabiu.com.alc4challengeone;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    Button aboutBtn,profileBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        aboutBtn = findViewById(R.id.aboutBtn);
        aboutBtn.setOnClickListener(this);
        profileBtn = findViewById(R.id.profileBtn);
        profileBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.aboutBtn:
                Intent intent = new Intent(this,AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.profileBtn:
                Intent i = new Intent(this,MyProfileActivity.class);
                startActivity(i);
                break;

        }
    }
}
