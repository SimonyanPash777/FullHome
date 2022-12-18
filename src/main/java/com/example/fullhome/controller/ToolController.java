package com.example.fullhome.controller;

import com.example.fullhome.entity.Tool;
import com.example.fullhome.service.ToolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class ToolController {

    private final ToolService toolService;

    @GetMapping("/tools")
    public String ToolsPage() {
        return "tools";
    }

    @GetMapping("/tools/add/page")
    public String ToolsAddPage() {
        return "add-tool";
    }

    @PostMapping("/tools/add/processing")
    public String ToolsAdd(@ModelAttribute Tool tool,
                           @RequestParam("toolImage") MultipartFile file,
                           ModelMap modelMap) throws IOException {
        if (!file.isEmpty() && file.getSize() > 0) {
            if (file.getContentType() != null && file.getContentType().contains("image")) {
                modelMap.addAttribute("errorMessageFile", "Please choose only image");
                tool.setCreatedAt(LocalDateTime.now());
                toolService.saveTool(tool);
                return "redirect:/";
            }
        }

        return "redirect:/";
    }

    @GetMapping("/tools/single")
    public String ToolsSinglePage() {
        return "tools-single";
    }

    @GetMapping("/tools/single/buy")
    public String ToolsSingleBuyPage() {
        return "tools-single-buy";
    }


}
