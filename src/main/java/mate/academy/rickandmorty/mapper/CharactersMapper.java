package mate.academy.rickandmorty.mapper;

import mate.academy.rickandmorty.config.MapperConfig;
import mate.academy.rickandmorty.dto.external.CharactersResponseResultDto;
import mate.academy.rickandmorty.dto.internal.CharactersResponseDto;
import mate.academy.rickandmorty.model.Character;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface CharactersMapper {
    CharactersResponseDto toDto(Character character);

    Character toModel(CharactersResponseResultDto charactersResponseResultDto);
}
