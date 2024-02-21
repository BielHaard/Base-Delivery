package com.base.delivery.controller;

import com.base.delivery.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ClienteController {

    @Autowired
    ClienteService clienteService;
}
