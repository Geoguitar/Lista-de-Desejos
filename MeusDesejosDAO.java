import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.List;

public class MeusDesejosDAO {

    public static final String NOME_TABELA = "MeusDesejos";
    public static final String COLUNA_ID = "id";
    public static final String COLUNA_PRODUTO = "produto";
    public static final String COLUNA_CATEGORIA = "categoria";
    public static final String COLUNA_LOJAS = "lojas";
    public static final String COLUNA_PRECOMAX = "precoMax";
    public static final String COLUNA_PRECOMIN = "precoMin";

    public static final String SCRIPT_CRIACAO_TABELA_MEUS_DESEJOS = "CREATE TABLE" + NOME_TABELA + "("

            + COLUNA_ID + "INTEGER PRIMARY KEY autoincrement,"
            + COLUNA_PRODUTO + "TEXT,"
            + COLUNA_CATEGORIA + "TEXT,"
            + COLUNA_LOJAS + "TEXT,"
            + COLUNA_PRECOMAX + "TEXT,"
            + COLUNA_PRECOMIN + "TEXT"
            + ")";

    public static final String SCRIPT_DELECAO_TABELA = "DROP TABLE IF EXISTS" + NOME_TABELA;

    private SQLiteDatabase dataBase = null;

    private static MeusDesejosDAO instance;

    public static MeusDesejosDAO getInstance(Context context){

        if(instance == null)
            instance = new MeusDesejosDAO(context);
        return instance;
    }

    private MeusDesejosDAO(Context context){

        PersistenceHelper persistenceHelper = PersistenceHelper.getInstance(context);
        dataBase = persistenceHelper.getWritableDatabase();
    }

    public void salvar(MeusDesejos desejos){

        ContentValues values = gerarContentValuesMeusDesejos(desejos);
        dataBase.insert(NOME_TABELA, null, values);
    }

    public List<MeusDesejos> recuperarTodos(){

        String queryReturnAll = "SELECT * FROM" + NOME_TABELA;
        Cursor cursor = dataBase.rawQuery(queryReturnAll, null);
        List<MeusDesejos> desejos = construirMeusDesejosPorCursor(cursor);

        return desejos;
    }

    public void fecharConexao(){

        if(dataBase != null && dataBase.isOpen())
            dataBase.close();
    }


    private List<MeusDesejos> construirMeusDesejosPorCursor(Cursor cursor){

        List<MeusDesejos> desejos  = new ArrayList<MeusDesejos>();
        if(Cursor == null)
            return desejos;

        try {

            if (cursor.moveToFirst()){
                do{

                    int indexID = cursor.getColumnIndex(COLUNA_ID);
                    int indexProduto = cursor.getColumnIndex(COLUNA_PRODUTO);
                    int indexCategoria = cursor.getColumnIndex(COLUNA_CATEGORIA);
                    int indexLojas = cursor.getColumnIndex(COLUNA_LOJAS);
                    int indexPrecoMax = cursor.getColumnIndex(COLUNA_PRECOMAX);
                    int indexPrecoMin = cursor.getColumnIndex(COLUNA_PRECOMIN);

                    int id cursor.getInt(indexID);
                    String produto = cursor.getString(indexProduto);
                    String categoria = cursor.getString(indexCategoria);
                    String lojas = cursor.getString(indexLojas);
                    String precoMax = cursor.getString(indexPrecoMax);
                    String precoMin = cursor.getString(indexPrecoMin);

                    MeusDesejos desejos = new MeusDesejos(id, produto, categoria, lojas, precoMax, precoMin);

                    desejos.add(desejos);

                } while (cursor.moveToNext());
            }
        } finally {
            cursor.close();
        }
        return desejos;
    }


    private ContentValues gerarContentValuesMeusDesejos(MeusDesejos desejos) {
        ContentValues values = new ContentValues();
        values.put(COLUNA_PRODUTO, desejos.getProduto());
        values.put(COLUNA_CATEGORIA, desejos.getCategoria());
        values.put(COLUNA_LOJAS, desejos.getLojas());
        values.put(COLUNA_PRECOMAX, desejos.getPrecoMax());
        values.put(COLUNA_PRECOMIN, desejos.getPrecoMin());

        return values;
    }


}
