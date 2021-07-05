package tads.eaj.ufrn.testeimplantacao.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tads.eaj.ufrn.testeimplantacao.models.Celular;
import tads.eaj.ufrn.testeimplantacao.models.CodeSQL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Controller
@RequestMapping("/admin")
public class Admin {

    @GetMapping
    public void mostrarFormulario(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.getWriter().println("<h1>FORMULÁRIO PARA ADICIONAR PRODUTOS:</h1>");
        response.getWriter().println("<form action = /admin/cadastra method = post>" +
                "<label>modelo: </label><input type=text name = modeloLabel></br> " +
                "</br> " +
                "<label>Marca: </label><input type=text name = marcaLabel></br>" +
                "</br> " +
                "<label>Preço: </label><input type=double name = precoLabel></br>" +
                " </br>                           " +
                " <label>Ano de Lançamento:</label><input type=int name = anolancamentoLabel></br>" +
                "  </br>                          " +
                "<label>Ram: </label><input type=int name = ramLabel></br>"  +
                "                           " +
                "<button type=submit value=submit> SUBMIT</buttonh>" +
                "</form>");
    }
    @RequestMapping(value = "/cadastra",method = RequestMethod.POST)
    public void inserirDoFormulario(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        CodeSQL code = new CodeSQL();
        String modeloLabel = request.getParameter("modeloLabel");
        String marcaloLabel = request.getParameter("marcaLabel");
        double precoLabel = Double.parseDouble(request.getParameter("precoLabel"));
        int anolancamentoLabel = Integer.parseInt(request.getParameter("anolancamentoLabel"));
        int ramLabel = Integer.parseInt(request.getParameter("ramLabel"));
        code.inserirDados(new Celular(modeloLabel, marcaloLabel, precoLabel, anolancamentoLabel, ramLabel));
        response.sendRedirect("/admin");
    }


}
