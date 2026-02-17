package br.com.postech.auth.application.usecases;

import br.com.postech.auth.adapter.in.rest.dto.RequestCreateUserDto;
import br.com.postech.auth.adapter.out.persistence.UserEntity;
import br.com.postech.auth.domain.ports.out.UserRepositoryPortOut;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateUserUseCaseTest {

    @Mock
    private UserRepositoryPortOut userRepositoryPortOut;

    @InjectMocks
    private CreateUserUseCase createUserUseCase;

    @Test
    void criaUsuarioComSucesso(){
        //arrange
        String password = "1234";
        String userName = "1234";
        UUID id = UUID.randomUUID();

        RequestCreateUserDto requestCreateUserDto =  RequestCreateUserDto.builder()
                .userName(userName)
                .password(password)
                .build();

        UserEntity userEntity = UserEntity.builder()
                .id(id)
                .username(userName)
                .password(password)
                .enabled(true)
                .build();

        when(userRepositoryPortOut.save(any())).thenReturn(userEntity);

        //act
        var retorno = createUserUseCase.create(requestCreateUserDto);

        //assert
        assertEquals(retorno.getIdUsuario(), id);
        assertEquals(retorno.getNome(), userName);
        assertEquals(retorno.getUsuarioAtivo(), true);


    }
}
