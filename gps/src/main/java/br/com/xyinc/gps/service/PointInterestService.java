package br.com.xyinc.gps.service;

import br.com.xyinc.gps.model.PointInterest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PointInterestService {

  Page<PointInterest> findAllWithPage( Pageable pageable );

  List<PointInterest> findAll();

  void save( PointInterest poi );

  List findAllNear(Long x, Long y, Long dist);
}
