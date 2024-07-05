package mate.academy.rickandmorty.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.internal.CharactersResponseDto;
import mate.academy.rickandmorty.service.CharactersClient;
import mate.academy.rickandmorty.service.CharactersService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/characters")
@Tag(name = "Rick and Morty API service")
public class CharactersController {
    private final CharactersService charactersService;
    private final CharactersClient charactersClient;

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get characters by name",
            description = "return list of characters with same names")
    public List<CharactersResponseDto> getCharactersByName(
            @RequestParam String name) {
        return charactersService.getAllCharactersByName(name);
    }

    @GetMapping("/random")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get random character", description =
            "Method return random character")
    public CharactersResponseDto getRandomCharacter() {
        return charactersService.getRandomCharacter();
    }
}
