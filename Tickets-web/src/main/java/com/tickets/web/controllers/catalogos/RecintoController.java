package com.tickets.web.controllers.catalogos;

import com.tickets.api.entitys.catalogos.Recinto;
import com.tickets.services.catalogos.RecintoService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/recinto")
public class RecintoController {

    @Resource
    RecintoService recintoService;

    @RequestMapping(value = "/consultaRecinto", method = RequestMethod.POST)
    public @ResponseBody
    List<Recinto> consultaEvento() {
        return recintoService.consultaRecintoList();
    }

    @RequestMapping(value = "/bajaRecinto", method = RequestMethod.POST)
    public @ResponseBody
    boolean bajaRecinto(@RequestBody Integer id) {
        recintoService.bajaRecinto(id);
        return true;
    }

    @RequestMapping(value = "/altaRecinto", method = RequestMethod.POST)
    public @ResponseBody
    Recinto altaRecinto(@RequestBody Recinto recinto) {
        return recintoService.altaRecinto(recinto);
    }
}
