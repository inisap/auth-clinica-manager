package br.com.postech.auth.adapter.in.rest.mapper;

import br.com.postech.auth.adapter.in.rest.dto.CreateUserResponse;
import br.com.postech.auth.adapter.in.rest.dto.RequestCreateUserDto;
import br.com.postech.auth.adapter.out.persistence.UserEntity;

public class UserMapper {

    public static UserEntity createUserDtoToEntity(RequestCreateUserDto createUserDto){

        return UserEntity.builder()
                .username(createUserDto.getUsername())
                .password(createUserDto.getPassword())
                .enabled(true)
                .build();
    }

    public static CreateUserResponse entityUserToCreateUserResponse(UserEntity entity){
        return CreateUserResponse.builder()
                .idUsuario(entity.getId())
                .nome(entity.getUsername())
                .usuarioAtivo(entity.isEnabled())
                .build();
    }
}
