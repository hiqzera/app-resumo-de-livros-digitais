import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "clients.db" // Nome do banco de dados
        private const val DATABASE_VERSION = 1 // Versão do banco de dados

        // Tabela de clientes
        const val TABLE_CLIENTS = "clients"
        const val COLUMN_ID = "id"
        const val COLUMN_EMAIL_CPF = "email_or_cpf"
        const val COLUMN_PASSWORD = "password"
    }

    // Criação da tabela
    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = """
        CREATE TABLE clients (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            email_or_cpf TEXT NOT NULL UNIQUE,
            password TEXT NOT NULL
        )
    """.trimIndent()
        db?.execSQL(createTableQuery)
    }

    // Atualização do banco de dados
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_CLIENTS")
        onCreate(db)
    }
}
