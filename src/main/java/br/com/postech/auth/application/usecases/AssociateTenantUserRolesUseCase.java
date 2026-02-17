package br.com.postech.auth.application.usecases;

import br.com.postech.auth.adapter.in.rest.dto.AssociateTenantUserRolesResponse;
import br.com.postech.auth.adapter.in.rest.dto.RequestAssociateTenantUserRolesDto;
import br.com.postech.auth.adapter.in.rest.mapper.TenantUserRolesMapper;
import br.com.postech.auth.domain.exception.TenantIdNaoEncontradoException;
import br.com.postech.auth.domain.exception.UsuarioIdNaoEncontradoException;
import br.com.postech.auth.domain.ports.in.AssociateTenantUserRolesPortIn;
import br.com.postech.auth.domain.ports.out.TenantRepositoryPortOut;
import br.com.postech.auth.domain.ports.out.UserRepositoryPortOut;
import br.com.postech.auth.domain.ports.out.UserTenantRepositoryPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AssociateTenantUserRolesUseCase implements AssociateTenantUserRolesPortIn {

    private final UserTenantRepositoryPortOut userTenantRepositoryPortOut;
    private final UserRepositoryPortOut UserRepositoryPortOut;
    private final TenantRepositoryPortOut tenantRepositoryPortOut;


    @Override
    public AssociateTenantUserRolesResponse create(RequestAssociateTenantUserRolesDto requestAssociateTenantUserRolesDto){


        //validando se usuario existe
        if(UserRepositoryPortOut.findById(requestAssociateTenantUserRolesDto.getIdUser()).isEmpty()){
         throw new UsuarioIdNaoEncontradoException();
        }

        //validando se tenant existe
        if(tenantRepositoryPortOut.findById(requestAssociateTenantUserRolesDto.getIdTenant()).isEmpty()){
            throw new TenantIdNaoEncontradoException();
        }

        var entity = TenantUserRolesMapper.associateTenantUserRolesDtoToEntity(requestAssociateTenantUserRolesDto);

        var savedEntity = userTenantRepositoryPortOut.save(entity);

        return TenantUserRolesMapper.entityTenantUserToAssociateTenantUserRolesResponse(savedEntity);
    }
}
