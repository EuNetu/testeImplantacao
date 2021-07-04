package tads.eaj.ufrn.testeimplantacao.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class Admin {

    @GetMapping
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.getWriter().println("<h1>FORMULÁRIO PARA ADICIONAR PRODUTOS:</h1>");
        response.getWriter().println("<form method=post  id=formulario>" +
                "<label>modelo:</label><input type=text name = modelo></br> " +
                "</br> " +
                "<label>Marca:</label><input type=text name = marca></br>" +
                "</br> " +
                "<label>Preco:</label><input type=double name = preco></br>" +
                " </br>                           " +
                " <label>Ano de Lançamento:</label><input type=int name = anolancamento></br>" +
                "  </br>                          " +
                "<label>Ram:</label><input type=int name = ram></br>"  +
                "                           " +
                "                           " +
                "</form>");
        response.getWriter().println("<button type=submit id=formulario value=submit> SUBMIT</buttonh>");
    }
    @RequestMapping (value = "/cadastra", method = RequestMethod.POST)
    public void doPost(HttpServletRequest request, HttpServletResponse response){

    }


}
