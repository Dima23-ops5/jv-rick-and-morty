package mate.academy.rickandmorty.service.impl;

import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.internal.CharactersResponseDto;
import mate.academy.rickandmorty.mapper.CharactersMapper;
import mate.academy.rickandmorty.repository.CharactersRepository;
import mate.academy.rickandmorty.service.CharactersClient;
import mate.academy.rickandmorty.service.CharactersService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharactersServiceImpl implements CharactersService {
    private final CharactersMapper charactersMapper;
    private final CharactersRepository charactersRepository;
    private final CharactersClient charactersClient;
    private final Random random;

    @Override
    public CharactersResponseDto getRandomCharacter() {
        Long randomId = random.nextLong(
                charactersClient.getCharacters().info().count());
        return charactersMapper.toDto(charactersRepository.getById(randomId));
    }

    @Override
    public List<CharactersResponseDto> getAllCharactersByName(String name) {
        return charactersMapper.toDtoList(charactersRepository.findAllByName(name));
    }
}
