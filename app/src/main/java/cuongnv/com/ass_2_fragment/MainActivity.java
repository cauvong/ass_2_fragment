package cuongnv.com.ass_2_fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnFragOne;
    private Button mBtnFragTwo;
    private Button mBtnFragThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnFragOne = (Button) findViewById(R.id.btnFragOne);
        mBtnFragTwo = (Button) findViewById(R.id.btnFragTwo);
        mBtnFragThree = (Button) findViewById(R.id.btnFragThree);

        mBtnFragOne.setOnClickListener(this);
        mBtnFragTwo.setOnClickListener(this);
        mBtnFragThree.setOnClickListener(this);
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_container, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnFragOne:
                replaceFragment(new OneFragment());
                break;
            case R.id.btnFragTwo:
                replaceFragment(new TwoFragment());
                break;
            case R.id.btnFragThree:
                replaceFragment(new ThreeFragment());
                break;
            default:
                break;
        }
    }
}
