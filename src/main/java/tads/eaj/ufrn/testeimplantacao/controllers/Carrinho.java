package tads.eaj.ufrn.testeimplantacao.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tads.eaj.ufrn.testeimplantacao.models.Celular;
import tads.eaj.ufrn.testeimplantacao.models.CodeSQL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
@RequestMapping
public class Carrinho {
    @GetMapping("/adicionarCarrinho")
    public void AdicionarNoCarrinho(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, URISyntaxException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        CodeSQL code = new CodeSQL();
        Celular cel = code.buscarPorID(id);
        HttpSession sessao = request.getSession();
        ArrayList<Celular> lista = new ArrayList<>();
        if (sessao.getAttribute("carrinho") == null)sessao.setAttribute("carrinho", lista);
        ArrayList<Celular> carrinho = (ArrayList<Celular>) sessao.getAttribute("carrinho");
        carrinho.add(cel);
        RequestDispatcher encaminhar = request.getRequestDispatcher("/cliente");
        encaminhar.forward(request, response);


    }

    @GetMapping("/verCarrinho")
    public void VerCarrinho(HttpServletRequest request, HttpServletResponse response)throws IOException{
        HttpSession sessao = request.getSession();
        if (sessao.getAttribute("carrinho")!= null){
            ArrayList<Celular> carrinho = (ArrayList<Celular>) sessao.getAttribute("carrinho");
            response.getWriter().println("<h1>LISTA CARRINHA</h1>");
            response.getWriter().println( "<table>" +
                    "        <tr>" +
                    "            <th> Modelo </th>" +
                    "            <th> Marca </th>" +
                    "            <th> Preço </th>" +
                    "            <th> Ano de lançamento </th>" +
                    "            <th> Ram </th>" +
                    "        </tr>"
            );
            for (var aux: carrinho){
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
            response.getWriter().println("<a href=/finalizarCompra >Finalizar Compra</a>");
        }else{
            response.sendRedirect("/cliente");
        }
    }

    @GetMapping("/finalizarCompra")
    public void FinalizarCarrinho(HttpServletRequest request, HttpServletResponse response)throws IOException{
        request.getSession().invalidate();
        response.sendRedirect("/cliente");
    }
}
