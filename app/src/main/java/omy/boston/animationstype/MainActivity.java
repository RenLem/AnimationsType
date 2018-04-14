package omy.boston.animationstype;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import omy.boston.animationstype.anim.ViewAnimation;

public class MainActivity extends AppCompatActivity {

    private Button btnStartAnimation;
    private ImageView imageView;
    private AnimationDrawable frameAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        btnStartAnimation = (Button) findViewById(R.id.btn_StartAnimation);
        btnStartAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //animateObjects();
                //animateScale();
                //animateTranslateAlpha();
                //animateRotate();
                animateView();
            }
        });
    }

    private void animateObjects(){
        imageView.setVisibility(ImageView.VISIBLE);
        imageView.setBackgroundResource(R.drawable.animation_frame);
        frameAnimation = (AnimationDrawable) imageView.getBackground();

        if (frameAnimation.isRunning()){
            frameAnimation.stop();
        }else {
            frameAnimation.start();
        }
    }

    private void animateScale(){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation_scale);
        imageView.setBackgroundResource(R.mipmap.ic_launcher);
        imageView.startAnimation(animation);
    }

    private void animateTranslateAlpha(){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation_translate_alpha);
        imageView.setBackgroundResource(R.mipmap.ic_launcher);
        imageView.setAnimation(animation);
    }

    private void animateRotate(){
        String[] listItams = new String[]{"Bukva", "Hrast", "Bor", "Smreka", "Lipa"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItams);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void animateView(){
        String[] listItams = new String[]{"Bukva", "Hrast", "Bor", "Smreka", "Lipa"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItams);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        listView.startAnimation(new ViewAnimation());
    }
}
