package mate.academy.rickandmorty.mapper;

import mate.academy.rickandmorty.config.MapperConfig;
import mate.academy.rickandmorty.dto.external.CharactersResponseResultDto;
import mate.academy.rickandmorty.dto.internal.CharactersResponseDto;
import mate.academy.rickandmorty.model.Character;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = MapperConfig.class)
public interface CharactersMapper {
    CharactersResponseDto toDto(Character character);

    List<CharactersResponseDto> toDtoList(List<Character> characterList);

    Character toModel(CharactersResponseResultDto charactersResponseResultDto);
}
