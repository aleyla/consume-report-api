package com.aleyla.consumereportapi.util;

import com.aleyla.consumereportapi.entity.*;
import com.aleyla.consumereportapi.enums.*;
import com.aleyla.consumereportapi.repository.*;
import com.aleyla.consumereportapi.repository.transaction.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DBInitializerUtil {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final CustomerInfoRepository customerInfoRepository;

    private final AddressRepository addressRepository;

    private final TransactionRepository transactionRepository;

    private final MerchantRepository merchantRepository;

    private final AcquirerRepository acquirerRepository;


    @PostConstruct
    private void initDb() {
        userRepository.save(getDefaultUserEntity());
        transactionRepository.saveAll(generateTransaction());
    }

    private List<TransactionEntity> generateTransaction() {
        List<TransactionEntity> transactionEntities = new ArrayList<>(3);
        MerchantEntity merchant = createMerchant();
        AcquirerEntity acquirer = createAcquirer();
        CustomerInfoEntity customerInfo = createCustomerInfoEntity();
        for (int i = 0; i < 4; i++) {
            TransactionEntity transaction = new TransactionEntity();
            transaction.setId(Long.valueOf(++i));
            transaction.setAmount(BigDecimal.TEN.multiply(BigDecimal.valueOf(i)));
            transaction.setMerchant(merchant);
            transaction.setAcquirer(acquirer);
            transaction.setCustomerInfo(customerInfo);
            transaction.setTxDate(LocalDate.now().minus(Period.ofDays(i)));
            if (i % 2 == 0) {
                transaction.setCurrency(Currency.USD);
                transaction.setOperation(Operation.TREE_D);
                transaction.setStatus(Status.APPROVED);
                transaction.setPaymentMethod(PaymentMethod.STORED);
                transaction.setErrorCode(null);
            } else {
                transaction.setCurrency(Currency.EUR);
                transaction.setStatus(Status.DECLINED);
                transaction.setOperation(Operation.DIRECT);
                transaction.setPaymentMethod(PaymentMethod.PAYTOCARD);
                transaction.setErrorCode("Invalid Card");
            }
            transactionEntities.add(transaction);
        }
        return transactionEntities;
    }

    public AcquirerEntity createAcquirer() {
        AcquirerEntity entity = new AcquirerEntity();
        entity.setName("acquirer");
        return acquirerRepository.save(entity);
    }

    public MerchantEntity createMerchant() {
        MerchantEntity entity = new MerchantEntity();
        entity.setName("merchant");
        return merchantRepository.save(entity);
    }

    private CustomerInfoEntity createCustomerInfoEntity() {
        CustomerInfoEntity entity = new CustomerInfoEntity();
        entity.setEmail("ali@mail.com");
        entity.setExpiryMonth("1");
        entity.setExpiryYear("2022");
        entity.setNumber("2022222222689333");
        entity.setIssueNumber("E2");
        entity.setBillingAddress(createAddress());
        return customerInfoRepository.save(entity);
    }

    private AddressEntity createAddress() {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddress1("test");
        addressEntity.setCity("london");
        return addressRepository.save(addressEntity);
    }

    private UserEntity getDefaultUserEntity() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setEmail("admin@mail.com");
        userEntity.setPassword(passwordEncoder.encode("12345"));
        userEntity.setRole(Role.ADMIN);
        return userEntity;
    }

}
