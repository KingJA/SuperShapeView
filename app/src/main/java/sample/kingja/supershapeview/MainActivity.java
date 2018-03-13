package sample.kingja.supershapeview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kingja.supershapeview.core.SuperManager;
import com.kingja.supershapeview.view.SuperShapeImageView;
import com.kingja.supershapeview.view.SuperShapeTextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeTvStyle(View view) {
        SuperShapeTextView superShapeTextView = (SuperShapeTextView) view;
        SuperManager superManager = superShapeTextView.getSuperManager();
        superManager.setCorner(new Random().nextInt(20));
        superManager.setSolidColor(0xff303F9F);
        superManager.setStrokeColor(getResources().getColor(R.color.colorAccent));
        superManager.setStrokeWidth(new Random().nextInt(4));
    }

    public void changeIvStyle(View view) {
        SuperShapeImageView superShapeImageView = (SuperShapeImageView) view;
        SuperManager superManager = superShapeImageView.getSuperManager();
        superManager.setCorner(new Random().nextInt(20));
        superManager.setStrokeColor(getResources().getColor(R.color.colorAccent));
        superManager.setStrokeWidth(new Random().nextInt(6));
    }
}
