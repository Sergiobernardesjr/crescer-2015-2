package br.com.cwi.crescer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Produto.SituacaoProduto;
import br.com.cwi.crescer.domain.Servico;
import br.com.cwi.crescer.dto.ProdutoDTO;
import br.com.cwi.crescer.service.MaterialService;
import br.com.cwi.crescer.service.ProdutoService;
import br.com.cwi.crescer.service.ServicoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService produtoService;
    private MaterialService materialService;
    private ServicoService servicoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService, MaterialService materialService, ServicoService servicoService) {
        this.materialService = materialService;
        this.produtoService = produtoService;
        this.servicoService = servicoService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listarProdutos() {
        List<ProdutoDTO> dtos = produtoService.listarProdutos();
        return new ModelAndView("produto/lista", "produtos", dtos);
    }

    @ModelAttribute("materiais")
    public List<Material> comboMateriais() {
        return materialService.listar();
    }

    @ModelAttribute("situacoes")
    public List<SituacaoProduto> comboProdutos() {
        return produtoService.listarSituacao();
    }
    @ModelAttribute("servicos")
    public List<Servico> comboServicos() {
        return servicoService.listar();
    }
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ModelAndView viewExibe(@PathVariable("id") Long id) {
        return new ModelAndView("produto/exibe", "produto", produtoService.findById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
    public ModelAndView viewEdita(@PathVariable("id") Long id) {
        return new ModelAndView("produto/edita", "produto", produtoService.findById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/editar", method = RequestMethod.POST)
    public ModelAndView editar(@Valid @ModelAttribute("produto") ProdutoDTO produto,
            BindingResult result,
            final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return new ModelAndView("produto/edita", "produto", produto);
        }
        produtoService.atualizar(produto);

        redirectAttributes.addFlashAttribute("mensagem", "Produto alterado com sucesso");

        return new ModelAndView("redirect:/produtos");
    }

    @RequestMapping("/cadastrar")
    public ModelAndView viewCadastra() {
        return new ModelAndView("produto/cadastra", "produto", new ProdutoDTO());
    }

    @RequestMapping(path = "/cadastrar", method = RequestMethod.POST)
    public ModelAndView cadastrar(@Valid @ModelAttribute("produto") ProdutoDTO dto,
            BindingResult result,
            final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return new ModelAndView("produto/cadastra");
        }

        if (produtoService.incluir(dto)) {
            redirectAttributes.addFlashAttribute("mensagem", "Produto cadastrado com sucesso!");
            return new ModelAndView("redirect:/produtos");
        }

        ModelAndView mv = new ModelAndView("produto/cadastra", "produto", dto);
        mv.addObject("mensagem", "Já existe produto com este serviço e material cadastrado!");
        return mv;
    }
}
