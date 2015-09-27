package ca.glial.interntoolkit;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class IronStudies extends Activity {

    private String serum_iron;
    private String tibc;
    private String transferrin;
    private String ferritin;
    private String transferrin_receptor;
    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iron_studies);

        final Button diagnose = (Button) findViewById(R.id.diagnose);
        diagnose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    public void openDialog() {
        final Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.diagnosis);
        tv = (TextView) dialog.findViewById(R.id.diagnosis_title);
        dialog.setTitle("Diagnosis:");


        tv.setText(diagnoseIronStudies());

        dialog.show();
    }

    public String diagnoseIronStudies() {
        String diagnosis = "Abnormal";

        if (serum_iron.equals("low") &&
                tibc.equals("high") &&
                transferrin.equals("low") &&
                ferritin.equals("low") &&
                transferrin_receptor.equals("high"))
            diagnosis = "Iron deficiency";

        else if (serum_iron.equals("low") &&
                tibc.equals("low") &&
                transferrin.equals("low") &&
                ferritin.equals("normal") &&
                transferrin_receptor.equals("normal"))
            diagnosis = "Anaemia of chronic disease";

        else if (serum_iron.equals("low") &&
                (tibc.equals("low") || tibc.equals("normal")) &&
                (transferrin.equals("low") || transferrin.equals("low"))&&
                ferritin.equals("normal") &&
                transferrin_receptor.equals("high"))
            diagnosis = "Iron deficiency and inflammation";

        else if (serum_iron.equals("low") &&
                tibc.equals("low") &&
                transferrin.equals("low") &&
                ferritin.equals("high") &&
                transferrin_receptor.equals("normal"))
            diagnosis = "Acute phase response";

        else if (serum_iron.equals("high") &&
                (tibc.equals("low") || tibc.equals("normal")) &&
                transferrin.equals("high") &&
                ferritin.equals("high") &&
                transferrin_receptor.equals("decreased"))
            diagnosis = "Iron overload";

        else if (serum_iron.equals("normal") &&
                tibc.equals("normal") &&
                transferrin.equals("normal") &&
                ferritin.equals("normal") &&
                transferrin_receptor.equals("normal"))
            diagnosis = "Normal";

        return diagnosis;
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.serum_iron_low:
                if (checked)
                    serum_iron = "low";
                    break;
            case R.id.serum_iron_normal:
                if (checked)
                    serum_iron = "normal";
                    break;
            case R.id.serum_iron_high:
                if (checked)
                    serum_iron = "high";
                    break;

            case R.id.tibc_low:
                if (checked)
                    tibc = "low";
                    break;
            case R.id.tibc_normal:
                if (checked)
                    tibc = "normal";
                    break;
            case R.id.tibc_high:
                if (checked)
                    tibc = "high";
                    break;

            case R.id.transferrin_low:
                if (checked)
                    transferrin = "low";
                    break;
            case R.id.transferrin_normal:
                if (checked)
                    transferrin = "normal";
                    break;
            case R.id.transferrin_high:
                if (checked)
                    transferrin = "high";
                    break;

            case R.id.ferritin_low:
                if (checked)
                    ferritin = "low";
                break;
            case R.id.ferritin_normal:
                if (checked)
                    ferritin = "normal";
                break;
            case R.id.ferritin_high:
                if (checked)
                    ferritin = "high";
                break;

            case R.id.transferrin_receptor_low:
                if (checked)
                    transferrin_receptor = "low";
                break;
            case R.id.transferrin_receptor_normal:
                if (checked)
                    transferrin_receptor = "normal";
                break;
            case R.id.transferrin_receptor_high:
                if (checked)
                    transferrin_receptor = "high";
                break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_iron_studies, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
