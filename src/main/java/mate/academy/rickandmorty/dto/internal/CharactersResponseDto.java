package mate.academy.rickandmorty.dto.internal;

import lombok.Data;

@Data
public class CharactersResponseDto {
    private Long id;
    private String name;
    private String status;
    private String gender;
}
