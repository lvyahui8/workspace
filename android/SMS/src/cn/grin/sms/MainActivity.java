package cn.grin.sms;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
	EditText numberText;
	EditText contentText;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        numberText = (EditText)super.findViewById(R.id.number);
        contentText = (EditText)super.findViewById(R.id.content);
        Button bt = (Button)super.findViewById(R.id.button);
        bt.setOnClickListener(new ButtonClickListener());
    }
    
    private final class ButtonClickListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			String number = numberText.getText().toString();
			String content = contentText.getText().toString();
			SmsManager manager = SmsManager.getDefault();
			List <String> texts = manager.divideMessage(content);
			for(String text : texts){
				manager.sendTextMessage(number, null, text, null, null);
			}
			Toast.makeText(MainActivity.this, R.string.success, Toast.LENGTH_LONG).show();
		}
    	
    }
}