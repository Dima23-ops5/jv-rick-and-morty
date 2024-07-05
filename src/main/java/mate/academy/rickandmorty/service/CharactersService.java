package mate.academy.rickandmorty.service;

import java.util.List;
import mate.academy.rickandmorty.dto.internal.CharactersResponseDto;

public interface CharactersService {
    CharactersResponseDto getRandomCharacter();

    List<CharactersResponseDto> getAllCharactersByName(String name);
}
