package jack.com.servicekeep;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import jack.com.servicekeep.manager.KeepAliveManager;


public class MainActivity extends Activity implements View.OnClickListener{


    private TextView mKillService, mStartService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mKillService = (TextView) findViewById(R.id.kill_service);
        mStartService = (TextView) findViewById(R.id.start_service);
        mKillService.setOnClickListener(this);
        mStartService.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.kill_service:
                Toast.makeText(getApplicationContext(), "kill service", Toast.LENGTH_LONG).show();
                KeepAliveManager.INSTANCE.stopKeepAliveSerice(MainActivity.this);
                break;
            case R.id.start_service:
                Toast.makeText(getApplicationContext(), "start service", Toast.LENGTH_LONG).show();
                KeepAliveManager.INSTANCE.startKeepAliveService(MainActivity.this);
                break;
        }
    }
}
