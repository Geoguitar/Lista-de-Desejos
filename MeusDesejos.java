public class MeusDesejos {

    private String produto = " ";
    private String categoria = " ";
    private String lojas = " ";
    private String precoMin = " ";
    private String precoMax = " ";
    private int ID = "0";

    public MeusDesejos(){

    }

    public MeusDesejos(int ID, String produto, String categoria, String lojas, String precoMax, String precoMin){

        super();
        this.ID = ID;
        this.produto = produto;
        this.categoria = categoria;
        this.lojas = lojas;
        this.precoMax = precoMax;
        this.precoMin = precoMin;
    }

    public int getId(){

        return ID;
    }
    public void setId(int I){


        this.ID = ID;
    }

    public  String getProduto(){

        return produto;
    }
    public void setProduto(String produto){

        this.produto = produto;
    }

    public  String getCategoria(){

        return categoria;
    }
    public void setCategoria(String categoria){

        this.categoria = categoria;
    }

    public  String getLojas(){

        return lojas;
    }
    public void setLojas(String lojas){

        this.lojas = lojas;

    public  String getPrecoMax(){

        return precoMax;
    }
    public void setPrecoMax(String precoMax){

        this.precoMax = precoMax;

    public  String getPrecoMin(){

        return precoMin;
    }
    public void setPrecoMin(String precoMin){

        this.precoMin = precoMin;
    }

}
