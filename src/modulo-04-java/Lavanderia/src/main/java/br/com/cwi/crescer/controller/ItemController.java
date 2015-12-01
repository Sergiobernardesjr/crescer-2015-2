package br.com.cwi.crescer.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.domain.Item.SituacaoItem;
import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Servico;
import br.com.cwi.crescer.dto.ItemDTO;
import br.com.cwi.crescer.dto.PedidoDTO;
import br.com.cwi.crescer.service.ItemService;
import br.com.cwi.crescer.service.MaterialService;
import br.com.cwi.crescer.service.PedidoService;
import br.com.cwi.crescer.service.ServicoService;

@Controller
@RequestMapping("/itens")
public class ItemController {

    private MaterialService materialService;
    private ServicoService servicoService;
    private ItemService itemService;
    private PedidoService pedidoService;

    @Autowired
    public ItemController(MaterialService materialService, ServicoService servicoService, ItemService itemService, PedidoService pedidoService) {
        this.materialService = materialService;
        this.servicoService = servicoService;
        this.itemService = itemService;
        this.pedidoService = pedidoService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/editar")
    public ModelAndView viewEdita() {
        return new ModelAndView("item/edita", "item", new ItemDTO());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/editar", method = RequestMethod.POST)
    public ModelAndView editar(@Valid @ModelAttribute("item") ItemDTO item) {

        itemService.incluir(item);

        ItemDTO novoItem = new ItemDTO();

        novoItem.setIdPedido(item.getIdPedido());

        ModelAndView mv = new ModelAndView("item/edita", "item", novoItem);
        mv.addObject("mensagem", "Item inserido com sucesso!");
        return mv;
    }

    @RequestMapping(path = "/finalizar/{id}", method = RequestMethod.GET)
    public ModelAndView finalizar(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {

        PedidoDTO pedido = pedidoService.buscarPedidoPorId(id);

        redirectAttributes.addFlashAttribute("pedido", pedido);

        ModelAndView mv = new ModelAndView("redirect:/pedidos/finalizar");
        return mv;
    }

    @ModelAttribute("materiais")
    public List<Material> comboMateriais() {
        return materialService.listar();
    }

    @ModelAttribute("servicos")
    public List<Servico> comboServicos() {
        return servicoService.listar();
    }

    @ModelAttribute("situacoes")
    public List<SituacaoItem> comboSituacao() {
        return itemService.listar();
    }

}
