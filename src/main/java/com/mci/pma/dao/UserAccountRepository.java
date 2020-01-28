package com.mci.pma.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mci.pma.entities.UserAccount;

public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, Long> {

}
