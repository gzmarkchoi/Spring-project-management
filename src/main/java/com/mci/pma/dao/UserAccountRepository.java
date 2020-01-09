package com.mci.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.mci.pma.entities.UserAccount;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {

}
