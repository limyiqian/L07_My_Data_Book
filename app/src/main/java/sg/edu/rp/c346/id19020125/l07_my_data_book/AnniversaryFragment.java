package sg.edu.rp.c346.id19020125.l07_my_data_book;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class AnniversaryFragment extends Fragment {

    Button btn;
    TextView tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anniversary, container, false);
        tv = view.findViewById(R.id.tv);
        btn = view.findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();

        String entered = tv.getText().toString();

        if (!entered.isEmpty()){
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext().getApplicationContext());
            SharedPreferences.Editor prefEdit = prefs.edit();

            prefEdit.putString("Ann", entered);
            prefEdit.commit();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext().getApplicationContext());
        String data = prefs.getString("Ann", "");
        tv.setText(data);
    }
}