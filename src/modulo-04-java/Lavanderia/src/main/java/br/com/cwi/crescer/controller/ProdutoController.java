package br.com.cwi.crescer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.dto.ProdutoDTO;
import br.com.cwi.crescer.service.MaterialService;
import br.com.cwi.crescer.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService produtoService;
    private MaterialService materialService;

    @Autowired
    public ProdutoController(ProdutoService produtoService, MaterialService materialService) {
        this.materialService = materialService;
        this.produtoService = produtoService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listarProdutos() {
        List<ProdutoDTO> dtos = produtoService.listarProdutos();
        return new ModelAndView("produto/lista", "produtos", dtos);
    }

    @ModelAttribute("materiais")
    public List<Material> comboCidades() {
        return materialService.listar();
    }
}
