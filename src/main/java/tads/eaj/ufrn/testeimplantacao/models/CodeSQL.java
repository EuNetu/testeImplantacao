package tads.eaj.ufrn.testeimplantacao.models;

import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;

public class CodeSQL {
    private static final String DATABASE = "CREATE TABLE vendas (\n" +
                    "\tid SERIAL PRIMARY KEY NOT NULL,\n" +
                    "\tmodelo varchar(50) NOT NULL,\n" +
                    "\tmarca VARCHAR(50) NOT NULL,\n" +
                    "\tpreco DECIMAL(7, 2) NOT NULL,\n" +
                    "\tanolancamento int NOT NULL,\n" +
                    "\tram int NOT NULL,\n" +
                    "\testoque int NOT NULL\n" +
                    ")";
    private static final String INSERT = "ISERT INTO vendas (\"modelo\",\"marca\",\"preco\",\"anolancamento\",\"ram\") VALUES (?,?,?,?,?,?)";
    private static final String SELECT = "SELECT * FROM vendas";

    public static void criartabela() throws SQLException, URISyntaxException {
        Connection conexao = ConectaBanco.getConnection();
        Statement st = conexao.createStatement();
        st.execute(DATABASE);
        conexao.close();
        System.out.println("DEU BOM A TABELA");

    }

    public boolean inserirDados(Celular c) throws SQLException{
        try{
            Connection conexao = ConectaBanco.getConnection();
            PreparedStatement psi = conexao.prepareStatement(INSERT);
            psi.setString(1,c.getModelo());
            psi.setString(2, c.getMarca());
            psi.setDouble(3,c.getPreco());
            psi.setInt(4,c.getAnolancamento());
            psi.setInt(5,c.getRam());
            psi.execute();
            conexao.close();
            System.out.println("DEU BOM");
            return true;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            System.out.println("DEU RUIM");
            return false;
        }
    }


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
