package com.onestopcancercenter.onestopcancercenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class user_sign_in_page extends AppCompatActivity {
private EditText name;
private EditText password;
private TextView info;
private Button login;
private  int counter=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_in_page);

    name =(EditText) findViewById(R.id.textView_username);
    password =(EditText) findViewById(R.id.password1);
    info=(TextView ) findViewById(R.id.textView10);
    login=(Button)findViewById(R.id. button_login);
    info.setText("Number of attemps remaining: 5");
login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
validate(name.getText().toString(),password.getText().toString());
    }
});
}

private void validate (String username , String userpassword){
      if ((username.equals("user")) && (userpassword.equals("1234"))){

         Intent intent= new Intent(user_sign_in_page.this,Homepage.class);
startActivity(intent);
}
else{
          counter--;
          info.setText(" Number of attemps remaining:"+String.valueOf(counter));
          if (counter==0){
              login.setEnabled(false);
          }
      }


}




}
