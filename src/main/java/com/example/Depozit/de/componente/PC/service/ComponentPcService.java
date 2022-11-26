package com.example.Depozit.de.componente.PC.service;

import com.example.Depozit.de.componente.PC.dto.ComponentPcDto;
import com.example.Depozit.de.componente.PC.entity.ComponentPc;
import com.example.Depozit.de.componente.PC.mapper.ComponentMapper;
import com.example.Depozit.de.componente.PC.repository.ComponentPcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComponentPcService {

    @Autowired
    ComponentPcRepository componentPcRepository;

    @Autowired
    ComponentMapper componentMapper;

    public List<ComponentPcDto> getComponents() {
        return componentPcRepository.findAll().stream().map(e -> componentMapper.mapComponentPcDto(e)).collect(Collectors.toList());
    }

    public ComponentPc getComponentById(Long id) throws Exception {
        Optional<ComponentPc> toy = componentPcRepository.findById(id);
        if (toy.isPresent()) return toy.get();
        else {
            throw new Exception("Exceptie");
        }
    }

    public ComponentPc saveComponent(ComponentPcDto componentPcDto) {
        ComponentPc componentPc = componentMapper.mapComponentPc(componentPcDto);
        componentPcRepository.save(componentPc);
        return componentPc;
    }

    public void deleteComponentById(Long id) {
        componentPcRepository.deleteById(id);
    }
}
