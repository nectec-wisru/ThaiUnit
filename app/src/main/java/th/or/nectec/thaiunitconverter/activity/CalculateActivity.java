package th.or.nectec.thaiunitconverter.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Set;

import th.or.nectec.thaiunitconverter.R;
import th.or.nectec.thaiunitconverter.fragment.CalculateFragment;

/**
 * Created by User on 7/10/2558.
 */
public class CalculateActivity extends AppCompatActivity {

    private Spinner spinner;

    private ArrayList<String> ThaiUnit = new ArrayList<String>();
    private String[] unitArray;

    String unitStr;
    int unitIcon;
    double[] defaultUnitFactor;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate_activity);


        unitArray = getResources().getStringArray(R.array.thai_unit);
        spinner = (Spinner) findViewById(R.id.thai_spinner);

        // Adapter ตัวแรก
        ArrayAdapter<String> adapterThai = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_dropdown_item, unitArray);

        Set<String> intentCategories = getIntent().getCategories();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        if (intentCategories == null){
            
        } else if (intentCategories.contains("unitconverter.intent.category.KRASOP")) {
            unitStr = getString(R.string.krasop);
            unitIcon = R.drawable.krasop;
            defaultUnitFactor = new double[]{30, 50, 100};
            fragmentTransaction.replace(R.id.container, CalculateFragment.newInstance(unitStr, unitIcon, defaultUnitFactor)).commit();
            getSupportActionBar().setTitle(R.string.krasop_to_kg);
        } else if (intentCategories.contains("unitconverter.intent.category.TUNG")) {
            unitStr = getString(R.string.tung);
            unitIcon = R.drawable.tung;
            defaultUnitFactor = new double[]{10, 15};
            fragmentTransaction.replace(R.id.container, CalculateFragment.newInstance(unitStr, unitIcon, defaultUnitFactor)).commit();
            getSupportActionBar().setTitle(R.string.tung_to_kg);
        }
    }
}


