package sample.kingja.supershapeview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kingja.supershapeview.core.SuperManager;
import com.kingja.supershapeview.view.SuperShapeEditText;
import com.kingja.supershapeview.view.SuperShapeImageView;
import com.kingja.supershapeview.view.SuperShapeTextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeIvStyle(View view) {
        SuperShapeImageView superShapeImageView = (SuperShapeImageView) view;
        SuperManager superManager = superShapeImageView.getSuperManager();
        superManager.setStrokeColor(getResources().getColor(R.color.colorAccent));
        superManager.setStrokeWidth(new Random().nextInt(6));
        superManager.setDashGap(new Random().nextInt(6));
        superManager.setDashWidth(new Random().nextInt(6));
        superManager.setCorner(new Random().nextInt(10), new Random().nextInt(20), new Random().nextInt(30), new
                Random().nextInt(50));
//        superManager.setCorner(new Random().nextInt(20));
    }

}
