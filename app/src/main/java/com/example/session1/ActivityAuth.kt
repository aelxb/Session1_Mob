package com.example.session1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import java.util.regex.Matcher
import java.util.regex.Pattern


class ActivityAuth : AppCompatActivity() {
    public var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.auth_screen)
        var signIN : Button = findViewById(R.id.signin)
        var email :String = findViewById<EditText>(R.id.login).text as String
        var password : String = findViewById<EditText>(R.id.password).text as String
        mAuth = FirebaseAuth.getInstance();
        signIN.setOnClickListener{
            if(isEmailValid(email) and (password.isNotEmpty())){

            }
        }
    }
    override fun onStart() {
        super.onStart()
        val currentUser = mAuth!!.currentUser
    }
    fun isEmailValid(email: String?): Boolean {
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern: Pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher: Matcher = pattern.matcher(email)
        return matcher.matches()
    }
}
