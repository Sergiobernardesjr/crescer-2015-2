package br.com.cwi.crescer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.domain.Cidade;
import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.service.CidadeService;
import br.com.cwi.crescer.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService clienteService;
    private CidadeService cidadeService;

    @Autowired
    public ClienteController(ClienteService clienteService, CidadeService cidadeService) {
        this.clienteService = clienteService;
        this.cidadeService = cidadeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        List<ClienteDTO> dtos = clienteService.listarClientesAtivos();
        return new ModelAndView("cliente/lista", "clientes", dtos);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ModelAndView viewExibe(@PathVariable("id") Long id) {
        return new ModelAndView("cliente/exibe", "cliente", clienteService.buscarClientePorId(id));
    }

    @RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
    public ModelAndView viewEdita(@PathVariable("id") Long id) {
        return new ModelAndView("cliente/edita", "cliente", clienteService.buscarClientePorId(id));
    }

    @RequestMapping(path = "/editar", method = RequestMethod.POST)
    public ModelAndView editar(ClienteDTO dto) {
        clienteService.atualizar(dto);
        return new ModelAndView("redirect:/clientes");
    }

    @ModelAttribute("cidades")
    public List<Cidade> comboCidades() {
        return cidadeService.listar();
    }

    @RequestMapping("/cadastrar")
    public ModelAndView viewCadastra(ClienteDTO dto) {
        return new ModelAndView("cliente/cadastra", "cliente", new ClienteDTO());
    }

    @RequestMapping(path = "/cadastrar", method = RequestMethod.POST)
    public ModelAndView cadastrar(@Valid @ModelAttribute("cliente") ClienteDTO dto, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("cliente/cadastra");
        }
        clienteService.incluir(dto);
        return new ModelAndView("redirect:/clientes");
    }

    @RequestMapping(path = "/desativar")
    public ModelAndView viewDesativa(@PathVariable("id") Long id, final RedirectAttributes redirectAttribute) {
        ClienteDTO dto = new ClienteDTO();

        dto = clienteService.buscarClientePorId(id);

        clienteService.desativar(dto);

        redirectAttribute.addFlashAttribute("desativado", "Cliente " + id + " desativado com sucesso");

        return new ModelAndView("redirect:/clientes");
    }
}