package com.orderworks.oswork.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderworks.oswork.domain.model.OrdemServicos;
@Repository
public interface OrdemServicosRepository extends JpaRepository<OrdemServicos, Long>{

}
