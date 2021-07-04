package tads.eaj.ufrn.testeimplantacao.models;

import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;

public class CodeSQL {
    private static final String INSERT = "ISERT INTO vendas (\"modelo\",\"marca\",\"preco\",\"anolancamento\",\"ram\")";
    private static final String SELECT = "SELECT * FROM vendas";

    public static ArrayList<Celular> mostrarTabela(){
        ArrayList<Celular> lista = new ArrayList<>();
        try{
            Connection conexao = ConectaBanco.getConnection();
            PreparedStatement psi = conexao.prepareStatement(SELECT);
            ResultSet result = psi.executeQuery();
            while(result.next()){
                Celular pro = new Celular(
                        result.getString("modelo"),
                        result.getString("marca"),
                        result.getDouble("preco"),
                        result.getInt("anolancamento"),
                        result.getInt("ram")
                );
                lista.add(pro);
            }
            conexao.close();
            System.out.println("funcionou a lista");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
