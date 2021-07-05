package tads.eaj.ufrn.testeimplantacao.models;

import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;

public class CodeSQL {
    private final String DATABASE = "CREATE TABLE vendas (" +
                    "id SERIAL PRIMARY KEY NOT NULL," +
                    "modelo varchar(50) NOT NULL," +
                    "marca VARCHAR(50) NOT NULL," +
                    "preco DECIMAL(7, 2) NOT NULL," +
                    "anolancamento int NOT NULL," +
                    "ram int NOT NULL" +
                    ")";
    private final String DADO_INSERT = "INSERT INTO vendas (MODELO,MARCA,PRECO," +
            "ANOLANCAMENTO,RAM) VALUES (?,?,?,?,?)";
    private final String SELECT = "SELECT * FROM vendas ORDER BY id";
    private final String BUSCAR_POR_ID = "SELECT * FROM vendas WHERE ID=?";

    public void criartabela() throws SQLException, URISyntaxException {
        Connection conexao = ConectaBanco.getConnection();
        Statement st = conexao.createStatement();
        st.execute(DATABASE);
        System.out.println("DEU BOM A TABELA");
        conexao.close();

    }

    public void inserirDados(Celular c) throws SQLException{
        try{
            Connection conexao = ConectaBanco.getConnection();
            PreparedStatement psi = conexao.prepareStatement(DADO_INSERT);
            psi.setString(1,c.getModelo());
            psi.setString(2, c.getMarca());
            psi.setDouble(3,c.getPreco());
            psi.setInt(4,c.getAnolancamento());
            psi.setInt(5,c.getRam());
            psi.execute();
            conexao.close();
            System.out.println("DEU BOM");
        } catch (URISyntaxException e) {
            e.printStackTrace();
            System.out.println("DEU RUIM");
        }
    }


    public ArrayList<Celular> mostrarTabela(){
        ArrayList<Celular> lista = new ArrayList<>();
        try{
            Connection conexao = ConectaBanco.getConnection();
            PreparedStatement psi = conexao.prepareStatement(SELECT);
            ResultSet result = psi.executeQuery();
            while(result.next()){
                Celular pro = new Celular(
                        result.getInt("id"),
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
        } catch (SQLException | URISyntaxException throwables) {
            throwables.printStackTrace();
            System.out.println("Não listou");
        }
        return lista;
    }
    public Celular buscarPorID(int id) throws SQLException, URISyntaxException {
        Celular cel = null;
        try{
            Connection conexao = ConectaBanco.getConnection();
            PreparedStatement psi = conexao.prepareStatement(BUSCAR_POR_ID);
            psi.setInt(1,id);
            ResultSet result = psi.executeQuery();
            if (result.next()){
                cel = new Celular(
                        result.getInt("id"),
                        result.getString("modelo"),
                        result.getString("marca"),
                        result.getDouble("preco"),
                        result.getInt("anolancamento"),
                        result.getInt("ram")
                );
            }
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return cel;
    }
}
