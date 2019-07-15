package rabiu.com.alc4challengeone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button aboutBtn,profileBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
