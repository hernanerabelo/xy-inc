package br.com.xyinc.gps.repository;

import br.com.xyinc.gps.model.PointInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointInterestRepository extends JpaRepository<PointInterest, Long> {
}
