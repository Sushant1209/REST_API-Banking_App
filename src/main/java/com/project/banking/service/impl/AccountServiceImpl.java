package com.project.banking.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.banking.dto.AccountDto;
import com.project.banking.entity.Account;
import com.project.banking.mapper.AccountMapper;
import com.project.banking.repository.AccountRepository;
import com.project.banking.service.AccountService;


@Service
public class AccountServiceImpl implements AccountService {
	
	private AccountRepository accountRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository) { 
		this.accountRepository = accountRepository;
	}

	//add account
	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		// TODO Auto-generated method stub
		Account account = AccountMapper.mapToAccount(accountDto);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}
	
	//get account
	@Override
	public AccountDto getAccountById(Long id) {
		// TODO Auto-generated method stub
		Account account = accountRepository
				.findById(id)
				.orElseThrow(()-> new RuntimeException("Account Does not exists"));
		return AccountMapper.mapToAccountDto(account);
	}

	//add Deposit
	@Override
	public AccountDto deposit(Long id, double amount) {
		// TODO Auto-generated method stub
		Account account = accountRepository
				.findById(id)
				.orElseThrow(()-> new RuntimeException("Account Does not exists"));
		double total = account.getBalance() + amount;
		account.setBalance(total);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	//withdraw
	@Override
	public AccountDto withdraw(Long id, double amount) {
		// TODO Auto-generated method stub
		Account account = accountRepository
				.findById(id)
				.orElseThrow(()-> new RuntimeException("Account Does not exists"));
		
		if(account.getBalance()<amount) {
			throw new RuntimeException("Insufficient amount");
		}
		
		double total = account.getBalance() - amount;
		account.setBalance(total);
		Account savedAccount= accountRepository.save(account);
		
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	//List all accounts
	@Override
	public java.util.List<AccountDto> getAllAccounts() {
		// TODO Auto-generated method stub
		List<Account> accounts = accountRepository.findAll();
		return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
	}

	//delete account
	@Override
	public void deleteAccount(Long id) {
		// TODO Auto-generated method stub
		Account account = accountRepository
				.findById(id)
				.orElseThrow(()-> new RuntimeException("Account Does not exists"));
		accountRepository.deleteById(id);
		
	}

}
