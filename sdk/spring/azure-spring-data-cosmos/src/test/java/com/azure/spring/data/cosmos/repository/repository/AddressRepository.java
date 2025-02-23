// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.spring.data.cosmos.repository.repository;

import com.azure.spring.data.cosmos.domain.Address;
import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.azure.spring.data.cosmos.repository.Query;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends CosmosRepository<Address, String> {
    void deleteByPostalCodeAndCity(String postalCode, String city);

    void deleteByCity(String city);

    Iterable<Address> findByPostalCodeAndCity(String postalCode, String city);

    Iterable<Address> findByCity(String city);

    Iterable<Address> findByCityIn(List<String> cities);

    Iterable<Address> findByPostalCode(String postalCode);

    Iterable<Address> findByPostalCodeInAndCity(List<String> postalCodes, String city);

    Iterable<Address> findByStreetOrCity(String street, String city);

    @Query("select * from a where a.city = @city")
    List<Address> annotatedFindListByCity(@Param("city") String city);

    @Query("select * from a where (NOT IS_DEFINED(@city) OR a.city = @city)")
    List<Address> annotatedFindListByCityOptional(@Param("city") Optional<String> city);

    @Query("select * from a where a.city = @city")
    Page<Address> annotatedFindByCity(@Param("city") String city, Pageable pageable);

    @Query("select * from a where a.city = @city")
    List<Address> annotatedFindByCity(@Param("city") String city, Sort pageable);

    @Query("select DISTINCT value a.postalCode from a where a.city = @city")
    Page<String> annotatedFindPostalCodeValuesByCity(@Param("city") String city, Pageable pageable);

    @Query("select DISTINCT a.postalCode from a where a.city = @city")
    Page<JsonNode> annotatedFindPostalCodesByCity(@Param("city") String city, Pageable pageable);

    @Query("select DISTINCT a.postalCode from a where a.city = @city")
    Slice<JsonNode> annotatedFindPostalCodesByCityAsSlice(@Param("city") String city, Pageable pageable);

    @Query("select DISTINCT value a.postalCode from a where a.city = @city")
    List<String> annotatedFindPostalCodeValuesByCity(@Param("city") String city);

    @Query("SELECT VALUE SUM(a.longId) from a where a.city = @city")
    Long annotatedSumLongIdValuesByCity(@Param("city") String city);

    @Query(value = "select * from a where a.city IN (@cities)")
    List<Address> annotatedFindByCityIn(@Param("cities") List<String> cities, Sort sort);

    @Query(value = "select * \n from a where \n a.city = @city \n")
    List<Address> annotatedFindByCityWithSort(@Param("city") String city, Sort sort);

    @Query(value = "select * \n from a \n where a.city = @city \n")
    List<Address> annotatedFindByCityWithSort2(@Param("city") String city, Sort sort);

    @Query(value = "select * from a where a.longId IN (@longList)")
    List<Address> annotatedFindByInLongParameters(@Param("longList") List<Long> longsList, Sort sort);

    @Query(value = "select * from a where a.homeNumber IN (@homeNumbers)")
    List<Address> annotatedFindByInHomeNumberParameters(@Param("homeNumbers") List<Integer> longsList, Sort sort);

    @Query(value = "select * from a where a.registrationDate IN (@registrationDates)")
    List<Address> annotatedFindByInRegistrationDateParameters(@Param("registrationDates") List<LocalDate> registrationDates, Sort sort);

    @Query(value = "select * from a where a.isOffice IN (@isOffices)")
    List<Address> annotatedFindByInIsOfficeParameters(@Param("isOffices") List<Boolean> isOffices, Sort sort);

    @Query(value = "SELECT * FROM a WHERE ARRAY_CONTAINS(@cities, a.city) ")
    List<Address> annotatedFindByCities(@Param("cities") List<String> cities);

    @Query(value = "SELECT * FROM a WHERE ARRAY_CONTAINS(@cities, a.city) ")
    List<Address> annotatedFindByCitiesWithSort(@Param("cities") List<String> cities, Sort sort);

    @Query(value = "SELECT * FROM C")

    List<Address> annotatedFindAllWithSort(Sort sort);

    Address findFirstByOrderByStreetAsc();

    Address findFirstByOrderByStreetDesc();

    Address findTopByOrderByStreetAsc();

    Address findTopByOrderByStreetDesc();

    List<Address> findAllByStreetNotNull();

    List<Address> findFirst2ByOrderByStreetAsc();

    List<Address> findTop3ByOrderByStreetDesc();

    Long countByStreetNotNull();

}
