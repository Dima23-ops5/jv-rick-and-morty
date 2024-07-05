package mate.academy.rickandmorty.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import mate.academy.rickandmorty.dto.external.CharactersResponseDataDto;
import mate.academy.rickandmorty.dto.internal.CharactersResponseDto;
import mate.academy.rickandmorty.exception.DaraProcessingException;
import mate.academy.rickandmorty.mapper.CharactersMapper;
import mate.academy.rickandmorty.repository.CharactersRepository;
import mate.academy.rickandmorty.service.CharactersClient;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CharactersClientImpl implements CharactersClient {
    private static final String BASE_URL = "https://rickandmortyapi.com/api";
    private final ObjectMapper objectMapper;
    private final CharactersRepository charactersRepository;
    private final CharactersMapper charactersMapper;

    @Override
    public List<CharactersResponseDto> saveCharacters() {
        CharactersResponseDataDto charactersResponseDataDto = getCharacters();
        List<CharactersResponseDto> charactersResponseDtoList = new ArrayList<>();
        while (charactersResponseDataDto.info().next() != null) {
            charactersResponseDtoList.addAll(
                    charactersResponseDataDto.results().stream()
                    .map(ch -> charactersMapper.toDto(charactersRepository
                            .save(charactersMapper.toModel(ch))))
                    .toList());
        }
        return charactersResponseDtoList;
    }

    @Override
    public CharactersResponseDataDto getCharacters() {
        CharactersResponseDataDto charactersResponseDataDto;
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(BASE_URL))
                .build();
        try {
            HttpResponse httpResponse = httpClient.send(httpRequest,
                    HttpResponse.BodyHandlers.ofString());
            charactersResponseDataDto = objectMapper.readValue(
                    httpResponse.body().toString(),
                    new TypeReference<>(){});
        } catch (IOException | InterruptedException e) {
            throw new DaraProcessingException("Cannot send request to get data", e);
        }
        return charactersResponseDataDto;
    }
}
