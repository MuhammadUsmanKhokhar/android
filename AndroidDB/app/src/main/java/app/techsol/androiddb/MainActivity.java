package app.techsol.androiddb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
        EditText mUserNameET,mUserEmailET,mPasswordET,mContactET;
        Button mSignUpBtn;
        String UserNameStr,UserEmailETStr,PasswordETStr,ContactETStr;

        String Url="sign.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserNameET=findViewById(R.id.UserNameET);
        mUserEmailET=findViewById(R.id.UserEmailET);
        mPasswordET=findViewById(R.id.PasswordET);
        mContactET=findViewById(R.id.ContactET);
        mSignUpBtn=findViewById(R.id.SignUpBtn);

        mSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                     getString();
                     if(UserNameStr.isEmpty()){
                         mUserNameET.setError("Please enter name");
                     }
                     else if(UserEmailETStr.isEmpty()){
                         mUserEmailET.setError("please enter email");
                     }
                     else if(PasswordETStr.isEmpty()){
                         mPasswordET.setError("please enter password");
                     }
                     else if(PasswordETStr.length()<=7){
                         mPasswordET.setError("password length should be 8");
                     }
                     else if(ContactETStr.isEmpty()){
                         mContactET.setError("please enter phone number");
                     }
                     else {


                     //    Intent intent=new Intent(MainActivity.this,Homepage.class);
                      //   startActivity(intent);
                         StringRequest request=new StringRequest(1, getResources().getString(R.string.base)+Url, new Response.Listener<String>() {
                             @Override
                             public void onResponse(String response) {
                                 if (response.equals("true")) {

                                     Intent intent=new Intent(MainActivity.this,Homepage.class);
                                        startActivity(intent);
                                 }
                             }
                         }, new Response.ErrorListener() {
                             @Override
                             public void onErrorResponse(VolleyError error) {
                                 Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                             }
                         }){
                             @Override
                             protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String,String> params=new HashMap<>();
                                params.put("Name",UserNameStr);
                                 params.put("email",UserEmailETStr);
                                 params.put("password",PasswordETStr);
                                 params.put("contactno",ContactETStr);
                                 return params;

                             }
                         };

                         RequestQueue queue= Volley.newRequestQueue(MainActivity.this);
                         queue.add(request);
                     }

                     }

        });


}
void getString(){
    UserNameStr=mUserNameET.getText().toString();
    UserEmailETStr=mUserEmailET.getText().toString();
    PasswordETStr=mPasswordET.getText().toString();
    ContactETStr=mContactET.getText().toString();

}
}
