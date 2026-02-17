package br.com.postech.auth.adapter.in.rest.mapper;

import br.com.postech.auth.adapter.in.rest.dto.CreateTenantResponse;
import br.com.postech.auth.adapter.in.rest.dto.CreateUserResponse;
import br.com.postech.auth.adapter.in.rest.dto.RequestCreateTenantDto;
import br.com.postech.auth.adapter.in.rest.dto.RequestCreateUserDto;
import br.com.postech.auth.adapter.out.persistence.TenantEntity;
import br.com.postech.auth.adapter.out.persistence.UserEntity;

public class TenantMapper {

    public static TenantEntity createTenantDtoToEntity(RequestCreateTenantDto createTenantDto){

        return TenantEntity.builder()
                .nome(createTenantDto.getNome())
                .tipo(createTenantDto.getTipo())
                .build();
    }

    public static CreateTenantResponse entityUserToCreateTenantResponse(TenantEntity entity){
        return CreateTenantResponse.builder()
                .idTenant(entity.getId())
                .nome(entity.getNome())
                .tipo(entity.getTipo())
                .build();
    }
}
