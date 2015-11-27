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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.domain.Cidade;
import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;
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
        List<ClienteDTO> dtos = clienteService.listarClientes();
        return new ModelAndView("cliente/lista", "clientes", dtos);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ModelAndView viewExibe(@PathVariable("id") Long id) {
        return new ModelAndView("cliente/exibe", "cliente", clienteService.buscarClientePorId(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
    public ModelAndView viewEdita(@PathVariable("id") Long id) {
        return new ModelAndView("cliente/edita", "cliente", clienteService.buscarClientePorId(id));
    }

    @RequestMapping(path = "/ {nomeCliente}", method = RequestMethod.GET)
    public ModelAndView viewEdita(@RequestParam("nomeCliente") String nomeCliente) {
        return new ModelAndView("cliente/lista", "clientes", clienteService.buscarClientePorNome(nomeCliente));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/editar", method = RequestMethod.POST)
    public ModelAndView editar(@Valid @ModelAttribute("cliente") ClienteDTO cliente,
            BindingResult result,
            final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return new ModelAndView("cliente/edita", "cliente", cliente);
        }
        clienteService.atualizar(cliente);

        redirectAttributes.addFlashAttribute("mensagem", "Cliente alterado com sucesso");

        return new ModelAndView("redirect:/clientes");
    }

    @ModelAttribute("cidades")
    public List<Cidade> comboCidades() {
        return cidadeService.listar();
    }

    @ModelAttribute("situacaoCliente")
    public List<SituacaoCliente> comboSituacao() {
        return clienteService.listarSituacao();
    }

    @RequestMapping("/cadastrar")
    public ModelAndView viewCadastra(ClienteDTO dto) {
        return new ModelAndView("cliente/cadastra", "cliente", new ClienteDTO());
    }

    @RequestMapping(path = "/cadastrar", method = RequestMethod.POST)
    public ModelAndView cadastrar(@Valid @ModelAttribute("cliente") ClienteDTO dto,
            BindingResult result,
            final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return new ModelAndView("cliente/cadastra");
        }

        redirectAttributes.addFlashAttribute("mensagem", "Cliente alterado com sucesso");

        clienteService.incluir(dto);
        return new ModelAndView("redirect:/clientes");
    }
}