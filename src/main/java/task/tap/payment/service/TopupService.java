package task.tap.payment.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import task.tap.payment.model.entity.Customer;
import task.tap.payment.model.entity.CustomerWallet;
import task.tap.payment.model.entity.Fees;
import task.tap.payment.model.entity.Topup;
import task.tap.payment.model.entity.dto.TopupDTO;
import task.tap.payment.model.enums.Status;
import task.tap.payment.model.paylod.TopupRequest;
import task.tap.payment.repository.CustomerRepository;
import task.tap.payment.repository.CustomerWalletRepository;
import task.tap.payment.repository.TopopRepostitory;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class TopupService {
	private final CustomerRepository customerRepository;
	private final CustomerWalletRepository customerWalletRepository;
	private final TopopRepostitory topopRepostitory;

	public TopupDTO topup(TopupRequest request) throws Exception {
		TopupDTO topupDTO = new TopupDTO();
		Topup topup = new Topup();

		Customer customer = validateCustomer(request);

		CustomerWallet wallet = vlidateWallet(request);

		Fees fees = prepareFees(request);

		prepareTopup(request, topup, customer, fees, wallet);

		return topupResponse(topupDTO, topup, customer);
	}

	private TopupDTO topupResponse(TopupDTO topupDTO, Topup topup, Customer customer) {
		topupDTO.setAmount(topup.getAmount());
		topupDTO.setBalanceAmount(topup.getCustomer().getCustomerWallets().get(0).getAmount());
		topupDTO.setCharge_id(topup.getCharge_id());
		topupDTO.setCurrency(topup.getCurrency());
		topupDTO.setCustomerId(customer.getId());
		topupDTO.setCustomerWalletId(customer.getCustomerWallets().get(0).getId());
		topupDTO.setFeesAmount(topup.getFees().getAmount());
		topupDTO.setFeesCurrency(topup.getFees().getCurrency());
		topupDTO.setId(topup.getId());
		topupDTO.setStatus(topup.getStatus());
		topupDTO.setCreatedDate(topup.getCreatedDate());
		return topupDTO;
	}

	private void prepareTopup(TopupRequest request, Topup topup, Customer customer, Fees fees, CustomerWallet wallet)
			throws Exception {
		topup.setAmount(request.getAmount());
		topup.setCharge_id(request.getCharge_id());
		topup.setCurrency(request.getCurrency());
		topup.setCustomer(customer);
		topup.setStatus(Status.SUCCESS);
		topup.setFees(fees);
		topup.setCreatedDate(LocalDateTime.now());
		addBalance(request, customer, wallet);

		topopRepostitory.save(topup);
	}

	private Fees prepareFees(TopupRequest request) {
		Fees fees = new Fees();
		if (request.getFeesRequest() != null) {
			fees.setAmount(request.getFeesRequest().getAmount());
			fees.setCurrency(request.getFeesRequest().getCurrency());
		}
		return fees;
	}

	private double addBalance(TopupRequest request, Customer customer, CustomerWallet wallet) throws Exception {
		if (request.getAmount() <= 0)
			throw new Exception("You Must Add valid Amount");

		double balance = wallet.getAmount();
		balance += request.getAmount();
		balance = addFees(request, balance);
		wallet.setAmount(balance);
		customerWalletRepository.save(wallet);
		return balance;
	}

	private double addFees(TopupRequest request, double balance) {
		if (request.getFeesRequest() != null) {
			double fees = request.getFeesRequest().getAmount();

			balance -= fees;
			return balance;
		}
		return balance;
	}

	private CustomerWallet vlidateWallet(TopupRequest request) throws Exception {
		CustomerWallet wallet = customerWalletRepository
				.findByIdAndCustomerId(request.getCustomerRequest().getCustomerWalletId(),
						request.getCustomerRequest().getId())
				.orElseThrow(() -> new Exception("Wallet Not Found!"));
		return wallet;
	}

	private Customer validateCustomer(TopupRequest request) throws Exception {
		Customer customer = customerRepository.findById(request.getCustomerRequest().getId())
				.orElseThrow(() -> new Exception("Customer Not Found!"));
		return customer;
	}

}
