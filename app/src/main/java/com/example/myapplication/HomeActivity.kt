import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.MainActivity
import com.example.myapplication.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val editTextEmailCpf = findViewById<EditText>(R.id.emailClient)
        val editTextSenha = findViewById<EditText>(R.id.passwordClient)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)

        buttonLogin.setOnClickListener {
            val emailOrCpf = editTextEmailCpf.text.toString()
            val password = editTextSenha.text.toString()

            if (emailOrCpf.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos.", Toast.LENGTH_SHORT).show()
            } else {
                if (isLoginValid(this, emailOrCpf, password)) {
                    Toast.makeText(this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Credenciais inválidas!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun isLoginValid(
        loginActivity: LoginActivity,
        emailOrCpf: String,
        password: String
    ): Boolean {
        TODO("Not yet implemented")
    }
}
