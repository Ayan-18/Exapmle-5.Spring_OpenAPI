package com.example.exercisefive.Service;

import com.example.exercisefive.DTO.TextDTO;
import com.example.exercisefive.Document.Text;
import com.example.exercisefive.Repository.TextRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class TextService {
    private final TextRepository textRepository;
    @Autowired
    private ModelMapper modelMapper;

    public TextService(TextRepository textRepository) {
        this.textRepository = textRepository;
    }


    public void create(final Text text) {
        textRepository.save(text);
    }

    public List<Text> find() {
        List<Text> list = new ArrayList<>();
        textRepository.findAll().forEach(list::add);
        return list;
    }

    public Page<Text> find(String text, Pageable pageable) {
        return textRepository.findAllByTextContainingIgnoreCase(text, pageable);
    }

    public Page<Text> all(Pageable pageable) {
        return textRepository.findAll(pageable);
    }

    public void delete(String id) {
        textRepository.deleteById(id);
    }

    public List<TextDTO> allDTO(Pageable pageable) {
        return textRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
    private TextDTO convertEntityToDto(Text text){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(text, TextDTO.class);
    }
}