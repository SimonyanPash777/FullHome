package com.example.fullhome.service;

import com.example.fullhome.entity.Tool;
import com.example.fullhome.repository.ToolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ToolService {

    private final ToolRepository toolRepository;

    public void saveTool(Tool tool){

        toolRepository.save(tool);

    }

}
