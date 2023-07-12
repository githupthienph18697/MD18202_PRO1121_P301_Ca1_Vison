package thiennhph18697.fpt.poly.md18202_pro1121_p301_ca1_vison;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar_trangchu;
    ViewFlipper viewBanner;
    DrawerLayout drawer_trangchu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        ActionBar();
        ActionViewFliper();
    }
    private void Anhxa(){
        toolbar_trangchu=findViewById(R.id.id_toolbar_trangchu);
        viewBanner=findViewById(R.id.id_imgbanner);
        drawer_trangchu=findViewById(R.id.DrawerLayout_trangchu);
    }
    private void ActionBar(){
        setSupportActionBar(toolbar_trangchu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_trangchu.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar_trangchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer_trangchu.openDrawer(GravityCompat.START);
            }
        });
    }
    private void ActionViewFliper(){
        List<String> quangcao=new ArrayList<>();
        quangcao.add("http://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/Blaster-E3-01.jpg");
        quangcao.add("http://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/transcend-TS8GMP710W-01.jpg");
        quangcao.add("http://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/logitech-Z906-01.jpg");
        quangcao.add("http://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/hp-probook-440-g3-t9s24pa-01.jpg");
        quangcao.add("http://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/jbl-t450-02.jpg");
        for(int i=0;i<quangcao.size();i++){
            ImageView img=new ImageView(getApplicationContext());
            Glide.with(getApplicationContext()).load(quangcao.get(i)).into(img);
            img.setScaleType(ImageView.ScaleType.FIT_XY);
            viewBanner.addView(img);
        }
        viewBanner.setFlipInterval(2000);
        viewBanner.setAutoStart(true);
        Animation slive_in= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.sliveshow_quangcao_in);
        Animation slive_out= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.sliveshow_quangcao_out);
        viewBanner.setInAnimation(slive_in);
        viewBanner.setOutAnimation(slive_out);
    }
}