package task.tap.payment.mapper;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;

import task.tap.payment.model.entity.CustomerWallet;
import task.tap.payment.model.entity.dto.CustomerWalletDTO;

@Mapper(componentModel = "spring")

public interface CustomerWalletMapper {
	
	
	CustomerWalletDTO toDTO(CustomerWallet entity);

	CustomerWallet toEntity(CustomerWalletDTO dto);

	List<CustomerWallet> toListEntity(List<CustomerWalletDTO> dto);

	Set<CustomerWallet> toSetEntity(Set<CustomerWalletDTO> dto);

	List<CustomerWalletDTO> toListDTO(List<CustomerWallet> entities);

	Set<CustomerWalletDTO> toSetDTO(Set<CustomerWallet> entities);
}
