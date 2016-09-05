package main.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout layoutweinxin;
    private LinearLayout layoutfriend;
    private ContentFragment fragmentweixin;
    private FriendFragment fragmentfriend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

//        layoutweinxin= (LinearLayout) findViewById(R.id.button);
//        layoutfriend= (LinearLayout) findViewById(R.id.button2);
//        layoutfriend.setOnClickListener(this);
//        layoutweinxin.setOnClickListener(this);
//
//        setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentManager fm=getFragmentManager();
        FragmentTransaction transaction=fm.beginTransaction();
        fragmentweixin = new ContentFragment();
        transaction.replace(R.id.id_fragment_content,fragmentweixin);
        transaction.commit();
    }

    @Override
    public void onClick(View view) {
        FragmentManager fm=getFragmentManager();
        FragmentTransaction transaction=fm.beginTransaction();
        switch (view.getId()){
            case R.id.button:
                if (fragmentweixin==null){
                    fragmentweixin=new ContentFragment();
                }
                transaction.replace(R.id.id_fragment_content,fragmentweixin);
                break;
            case R.id.button2:
                if (fragmentfriend==null){
                    fragmentfriend=new FriendFragment();
                }
                transaction.replace(R.id.id_fragment_content,fragmentfriend);
                break;
        }
        transaction.commit();
    }
}
