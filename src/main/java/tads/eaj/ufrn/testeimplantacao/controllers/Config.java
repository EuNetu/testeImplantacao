package tads.eaj.ufrn.testeimplantacao.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tads.eaj.ufrn.testeimplantacao.models.Celular;
import tads.eaj.ufrn.testeimplantacao.models.CodeSQL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

@Controller
@RequestMapping("/config")
public class Config {

    @GetMapping
    public void testandoTabela(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, URISyntaxException {
        CodeSQL code = new CodeSQL();
        code.criartabela();
        code.inserirDados(new Celular("a10", "Samsung", 800, 2019,2));
        code.inserirDados(new Celular("a20", "Samsung", 1000, 2019,3));
        code.inserirDados(new Celular("a30", "Samsung", 1200, 2019,4));
        code.inserirDados(new Celular("a50", "Samsung", 1800, 2019,6));
        code.inserirDados(new Celular("a70", "Samsung", 2200, 2019,8));
        response.getWriter().println("Aí simm");
    }
}
