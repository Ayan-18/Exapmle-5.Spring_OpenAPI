package com.example.exercisefive.Controller;

import com.example.exercisefive.DTO.TextDTO;
import com.example.exercisefive.Service.TextService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/documents")

@RequiredArgsConstructor
public class TextRestController {
    private final TextService textService;

    @GetMapping(path = "/all", produces = "application/json")
    @Tag(name = "Все документы", description = "Показывает документы")
    public List<TextDTO> all(
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<String> sortBy
    ) {
        return textService.allDTO(PageRequest.of(
                page.orElse(0), 1,
                Sort.Direction.ASC, sortBy.orElse("id")));
    }

    @GetMapping(path = "/{id}")
    @Tag(name = "Удалить документ", description = "Удаляет документ по ID")
    public void delete(@PathVariable String id) {
        textService.delete(id);
    }
}
