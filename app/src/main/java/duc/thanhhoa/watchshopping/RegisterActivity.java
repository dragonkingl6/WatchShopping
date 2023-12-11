package duc.thanhhoa.watchshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText name, email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.name_reg);
        email = findViewById(R.id.email_reg);
        password = findViewById(R.id.password_reg);

    }

    public void signUp(View view) {
        String userName= name.getText().toString().trim();
        String userEmail= email.getText().toString().trim();
        String userPassword= password.getText().toString().trim();

        if(TextUtils.isEmpty(userName)){
            name.setError("Name is required");
            return;
        }
        if(TextUtils.isEmpty(userEmail)){
            email.setError("Email is required");
            return;
        }
        if(TextUtils.isEmpty(userPassword)){
            password.setError("Password is required");
            return;
        }
        if(userPassword.length()<6){
            password.setError("Password must be >= 6 characters");
            return;
        }
        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
    }

    public void signIn(View view) {
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
    }
}