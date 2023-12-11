package duc.thanhhoa.watchshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText name, email, password;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email_login);
        password = findViewById(R.id.password_login);
    }

    public void signUp(View view) {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }

    public void signIn(View view) {
        String userEmail= email.getText().toString().trim();
        String userPassword= password.getText().toString().trim();

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
        //login user
        auth.signInWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            }else{
                Toast.makeText(LoginActivity.this, "Error !"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}