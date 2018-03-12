package sample.kingja.supershapeview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kingja.supershapeview.view.SuperShapeTextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeStyle(View view) {
        SuperShapeTextView superShapeTextView = (SuperShapeTextView) view;
        superShapeTextView.setCorner(new Random().nextInt(10));
        superShapeTextView.setSolidColor(0xff303F9F);
        superShapeTextView.setStrokeColor(getResources().getColor(R.color.colorAccent));
        superShapeTextView.setStrokeWidth(5);
    }
}
