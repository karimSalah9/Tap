package task.tap.payment.mapper;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import task.tap.payment.model.entity.Customer;
import task.tap.payment.model.entity.dto.CustomerDTO;

@Mapper(componentModel = "spring" , uses = CustomerWalletMapper.class)
public interface CustomerMapper {

	@Mappings({ @Mapping(source = "entity.customerWallets", target = "customerWalletDTO") })
	CustomerDTO toDTO(Customer entity);

	Customer toEntity(CustomerDTO dto);

	List<Customer> toListEntity(List<CustomerDTO> dto);

	Set<Customer> toSetEntity(Set<CustomerDTO> dto);

	List<CustomerDTO> toListDTO(List<Customer> entities);

	Set<CustomerDTO> toSetDTO(Set<Customer> entities);
}
