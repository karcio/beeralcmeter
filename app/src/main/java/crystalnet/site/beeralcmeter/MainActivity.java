package crystalnet.site.beeralcmeter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

//import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void onClickButton(View v) {

        if (v.getId() == R.id.bt_calculate) {

            EditText a = (EditText) findViewById(R.id.et_og);
            String validateA = a.getText().toString();
            if (validateA.matches("")) {
                Toast.makeText(this, "please, insert value (OG)", Toast.LENGTH_SHORT).show();
                return;
            }

            EditText b = (EditText) findViewById(R.id.et_fg);
            String validateB = b.getText().toString();
            if (validateB.matches("")) {
                Toast.makeText(this, "please, insert value (FG)", Toast.LENGTH_SHORT).show();
                return;
            }

            double og, fg;
            og = Double.parseDouble(a.getText().toString());
            fg = Double.parseDouble(b.getText().toString());

            double result = (og - fg) / 0.75 * 100;
            result = Double.parseDouble(new DecimalFormat("##.##").format(result));

            if ((result < 0) || (result > 20)) {
                Toast.makeText(this, "please, check values inserted", Toast.LENGTH_SHORT).show();
                return;
            }
            TextView t = (TextView) findViewById(R.id.lb_result);
            t.setText(String.format("%s %%", result));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    return true;
        //}

        return super.onOptionsItemSelected(item);
    }
    */
}
