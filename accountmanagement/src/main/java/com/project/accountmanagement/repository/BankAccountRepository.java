package com.project.accountmanagement.repository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.project.accountmanagement.entity.BankAccount;
import com.project.accountmanagement.entity.Customer;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount,Long>{	
	
	
	
	
	@Modifying
    @Query(value = "update bank_account set current_balance=:currentbalance where acc_number=:accountnumber ", nativeQuery = true)
    @Transactional
    void setAccountBalance(@Param("currentbalance") long currentbalance,@Param("accountnumber") long accountnumber);

	BankAccount getByAccountNumber(long accountnumber);
	
	
	
//	@Query("")
//	public void setAccountBalance(int currentbalance);
	

	

	Optional<List<BankAccount>> findCustomerByCustomerId(long custid);

}
