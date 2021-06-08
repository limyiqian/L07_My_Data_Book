package sg.edu.rp.c346.id19020125.l07_my_data_book;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
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
        tv = view.findViewById(R.id.textView);
        btn = view.findViewById(R.id.buttonEdit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                alertDialog.setTitle("Edit Anniversary");
                EditText etText  = new EditText(getContext());
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                etText.setLayoutParams(params);
                alertDialog.setView(etText);
                alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tv.setText(etText.getText().toString());
                    }
                });
                alertDialog.setNegativeButton("Cancel", null);
                alertDialog.show();
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