package br.com.cwi.crescer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.domain.Servico;
import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.dto.ItemDTO;
import br.com.cwi.crescer.dto.PedidoDTO;
import br.com.cwi.crescer.service.ClienteService;
import br.com.cwi.crescer.service.MaterialService;
import br.com.cwi.crescer.service.PedidoService;
import br.com.cwi.crescer.service.ServicoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    private PedidoService pedidoService;
    private ClienteService clienteService;
    private ServicoService servicoService;
    private MaterialService materialService;

    @Autowired
    public PedidoController(PedidoService pedidoService, ClienteService clienteService, MaterialService materialService, ServicoService servicoService) {
        this.pedidoService = pedidoService;
        this.clienteService = clienteService;
        this.servicoService = servicoService;
        this.materialService = materialService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listarPedidos() {
        List<PedidoDTO> dtos = pedidoService.listAll();
        return new ModelAndView("pedido/lista", "pedidos", dtos);
    }

    @ModelAttribute("situacoes")
    public List<SituacaoPedido> comboCidades() {
        return pedidoService.listarSituacao();
    }

    @RequestMapping("/cadastrar")
    public ModelAndView viewCadastra() {
        return new ModelAndView("pedido/cadastra", "pedido", new PedidoDTO());
    }

    @ModelAttribute("clientes")
    public List<ClienteDTO> comboClientes() {
        return clienteService.listarClientes();
    }

    @RequestMapping(path = "/cadastrar", method = RequestMethod.POST)
    public ModelAndView cadastrar(@Valid @ModelAttribute("pedido") PedidoDTO dto,
            BindingResult result,
            final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return new ModelAndView("pedido/cadastra");
        }

        Pedido pedido = pedidoService.incluir(dto);

        ItemDTO item = new ItemDTO();

        item.setIdPedido(pedido.getIdPedido());

        return new ModelAndView("item/edita", "item", item);
    }

    @RequestMapping(path = "/finalizar", method = RequestMethod.GET)
    public ModelAndView finalizar(Model model) {
        PedidoDTO pedido = (PedidoDTO) model.asMap().get("pedido");
        pedidoService.finalizar(pedido);

        return new ModelAndView("pedido/lista", "pedidos", pedidoService.listAll());
    }

    @ModelAttribute("materiais")
    public List<Material> comboMateriais() {
        return materialService.listar();
    }

    @ModelAttribute("servicos")
    public List<Servico> comboServicos() {
        return servicoService.listar();
    }
}
