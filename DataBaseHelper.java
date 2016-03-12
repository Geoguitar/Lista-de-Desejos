import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by geoguitar on 22/06/15.
 */
public class DataBaseHelper extends SQLiteOpenHelper{

    private static final String NOME_BANCO_DADOS = "ListaDeDesejos";
    private static final int VERSAO_BANCO_DADOS = 1;
    private static DataBaseHelper instance;

    public static DataBaseHelper getInstance(Context context){

        if(instance == null)
            instance = new DataBaseHelper(context);

        return = instance;
    }

    private DataBaseHelper(Context context){

        super(context, NOME_BANCO_DADOS, null, VERSAO_BANCO_DADOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        db.execSQL(MeusDesejosDAO.SCRIPT_CRIACAO_TABELA_MEUS_DESEJOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        db.execSQL(MeusDesejosDAO.SCRIPT_DELECAO_TABELA);
        onCreate(db);
    }


}
