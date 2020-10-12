package beertech.becks.api.repositories;

import beertech.becks.api.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT * FROM ACCOUNT WHERE HASH = ?1")
    Account findByHash(String hash);

}
