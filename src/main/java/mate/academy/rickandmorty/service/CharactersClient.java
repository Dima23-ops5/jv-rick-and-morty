package mate.academy.rickandmorty.service;

import java.util.List;
import mate.academy.rickandmorty.dto.external.CharactersResponseDataDto;
import mate.academy.rickandmorty.dto.internal.CharactersResponseDto;

public interface CharactersClient {
    List<CharactersResponseDto> saveCharacters();

    CharactersResponseDataDto getCharacters();
}
