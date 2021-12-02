package com.rosatom.oilspills.api.controller;

import com.rosatom.oilspills.service.PollutionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Pollution")

@RestController
@RequestMapping("/pollutions")
public class PollutionController {

    private final PollutionService service;

    public PollutionController(PollutionService service) {
        this.service = service;
    }
}
