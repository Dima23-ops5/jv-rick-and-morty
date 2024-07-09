package mate.academy.rickandmorty.service.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import mate.academy.rickandmorty.dto.internal.CharactersResponseDto;
import mate.academy.rickandmorty.mapper.CharactersMapper;
import mate.academy.rickandmorty.repository.CharactersRepository;
import mate.academy.rickandmorty.service.CharactersService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CharactersServiceImpl implements CharactersService {
    private final CharactersMapper charactersMapper;
    private final CharactersRepository charactersRepository;

    @Override
    public CharactersResponseDto getRandomCharacter() {
        return charactersMapper.toDto(charactersRepository.getRandom());
    }

    @Override
    public List<CharactersResponseDto> getAllCharactersByName(String name) {
        return charactersMapper.toDtoList(charactersRepository.findAllByName(name));
    }
}
