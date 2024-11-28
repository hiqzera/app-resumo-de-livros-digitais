import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteException
import android.util.Log

fun insertClient(context: Context, emailOrCpf: String, password: String): Boolean {
    val dbHelper = DatabaseHelper(context)
    val db = dbHelper.writableDatabase

    return try {
        val values = ContentValues().apply {
            put(DatabaseHelper.COLUMN_EMAIL_CPF, emailOrCpf)
            put(DatabaseHelper.COLUMN_PASSWORD, password)
        }

        val result = db.insert(DatabaseHelper.TABLE_CLIENTS, null, values)
        result > 0
    } catch (e: SQLiteException) {
        false // Retorna false em caso de erro (ex: duplicidade)
    } finally {
        db.close()
    }
}

fun isLoginValid(context: Context, emailOrCpf: String, password: String): Boolean {
    val dbHelper = DatabaseHelper(context)
    val db = dbHelper.readableDatabase

    val cursor = db.query(
        DatabaseHelper.TABLE_CLIENTS,
        arrayOf(DatabaseHelper.COLUMN_ID),
        "${DatabaseHelper.COLUMN_EMAIL_CPF} = ? AND ${DatabaseHelper.COLUMN_PASSWORD} = ?",
        arrayOf(emailOrCpf, password),
        null,
        null,
        null
    )

    val isValid = cursor.count > 0
    cursor.close()
    db.close()

    return isValid
}
