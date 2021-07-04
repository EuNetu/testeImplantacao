package tads.eaj.ufrn.testeimplantacao.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tads.eaj.ufrn.testeimplantacao.models.CodeSQL;
import tads.eaj.ufrn.testeimplantacao.models.Celular;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
@RequestMapping("/cliente")
public class Cliente {

    @GetMapping
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{

        CodeSQL code = new CodeSQL();
        ArrayList<Celular> cel = code.mostrarTabela();

        response.getWriter().println( "<table>" +
                "        <tr>" +
                "            <th> Modelo </th>" +
                "            <th> Marca </th>" +
                "            <th> Preço </th>" +
                "            <th> Ano de lançamento </th>" +
                "            <th> Ram </th>" +
                "        </tr>"
        );
        for (var aux: cel){
            response.getWriter().println("<tr>" +
                    "        <td>" + aux.getModelo()  + "</td>" +
                    "        <td>" + aux.getMarca()  + "</td>" +
                    "        <td>" + aux.getPreco()  + "</td>" +
                    "        <td>" + aux.getAnolancamento()  + "</td>" +
                    "        <td>" + aux.getRam()  + "</td>" +
                    "    </tr>"

            );
        }
        response.getWriter().println("</table>");
    }

}
