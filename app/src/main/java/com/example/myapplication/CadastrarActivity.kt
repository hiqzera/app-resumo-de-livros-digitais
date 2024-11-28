import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.MainActivity
import com.example.myapplication.R

class CadastrarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar)

        val emailClient = findViewById<EditText>(R.id.emailClient)
        val passwordClient = findViewById<EditText>(R.id.passwordClient)
        val passClient = findViewById<EditText>(R.id.passClient)
        val buttonCadastrar = findViewById<Button>(R.id.buttonCadastrar)

        buttonCadastrar.setOnClickListener {
            val emailOrCpf = emailClient.text.toString().trim()
            val password = passwordClient.text.toString().trim()
            val confirmPassword = passClient.text.toString().trim()

            // Verificar campos vazios
            if (emailOrCpf.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Verificar se as senhas coincidem
            if (password != confirmPassword) {
                Toast.makeText(this, "As senhas não correspondem.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Inserir cliente no banco
            val result = insertClient(this, emailOrCpf, password)
            if (result) {
                Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Erro: E-mail ou CPF já cadastrado.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
