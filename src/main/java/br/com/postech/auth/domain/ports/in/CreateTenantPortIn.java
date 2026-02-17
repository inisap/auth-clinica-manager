package br.com.postech.auth.domain.ports.in;

import br.com.postech.auth.adapter.in.rest.dto.CreateTenantResponse;
import br.com.postech.auth.adapter.in.rest.dto.CreateUserResponse;
import br.com.postech.auth.adapter.in.rest.dto.RequestCreateTenantDto;
import br.com.postech.auth.adapter.in.rest.dto.RequestCreateUserDto;

public interface CreateTenantPortIn {
    public CreateTenantResponse create(RequestCreateTenantDto requestCreateTenantDto);
}
