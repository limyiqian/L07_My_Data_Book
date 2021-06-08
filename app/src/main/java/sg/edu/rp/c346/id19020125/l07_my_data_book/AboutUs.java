package sg.edu.rp.c346.id19020125.l07_my_data_book;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class AboutUs extends AppCompatActivity {

    ImageView iv;
    ActionBar ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        iv = findViewById(R.id.imageView);
        String schLogo = "https://upload.wikimedia.org/wikipedia/commons/8/80/Republic_Polytechnic_Logo.jpg";
//        Picasso.with(this).load(schLogo).into(iv);
        Glide.with(this)
                .load(schLogo)
                .placeholder(R.drawable.ajax_loader)
                .error(R.drawable.error)
                .into(iv);

        ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }


}