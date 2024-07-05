package mate.academy.rickandmorty.dto.external;

import java.util.List;

public record CharactersResponseDataDto(
        CharacterResponseInfoDto info,
        List<CharactersResponseResultDto> results
) {
}
