package radiogroupdemo.mytextview.com.radiogroupdemo;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private TextView MainTitle;
    private TextView Title;
    private Button showChoiceButton;
    private AlertDialog.Builder alertDilogue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*requestWindowFeature(Window.FEATURE_NO_TITLE);//to hide the app title
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);*///int flag, int mask
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.RadioGroup);
        MainTitle = (TextView) findViewById(R.id.MainTitle);
        Title = (TextView) findViewById(R.id.Title);
        showChoiceButton = (Button) findViewById(R.id.showChoiceButton);

        showChoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int clickedRadioButton = radioGroup.getCheckedRadioButtonId();

                radioButton = (RadioButton) findViewById(clickedRadioButton);

                alertDilogue = new AlertDialog.Builder(MainActivity.this);

                alertDilogue.setIcon(android.R.drawable.presence_video_online);

                alertDilogue.setTitle(getResources().getString(R.string.dialogTitle) + radioButton.getText());
                if(radioButton.getText().equals(getResources().getString(R.string.positive_button)))
                    alertDilogue.setMessage(getResources().getString(R.string.dialogueMessageYes));
                else if(radioButton.getText().equals(getResources().getString(R.string.negative_button)))
                    alertDilogue.setMessage(getResources().getString(R.string.dialogueMessageNo));
                else
                    alertDilogue.setMessage(getResources().getString(R.string.dialogueMessageMayBe));

                //alertDilogue.setCancelable(false);
                alertDilogue.create().show();
                /*AlertDialog alertD = alertDilogue.create();
                alertD.show();*/

                //Toast.makeText(getApplicationContext(),radioButton.getText(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
