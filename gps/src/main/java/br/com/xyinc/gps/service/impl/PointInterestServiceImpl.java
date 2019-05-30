package br.com.xyinc.gps.service.impl;

import br.com.xyinc.gps.exception.PointInterestException;
import br.com.xyinc.gps.model.PointInterest;
import br.com.xyinc.gps.repository.PointInterestRepository;
import br.com.xyinc.gps.service.PointInterestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PointInterestServiceImpl implements PointInterestService {
  private static final Logger LOGGER = LogManager.getLogger(PointInterestServiceImpl.class);

  @Autowired
  PointInterestRepository pointInterestRepository;

  @Override
  @Transactional( readOnly = true )
  public Page<PointInterest> findAllWithPage( Pageable pageable ) {
    return pointInterestRepository.findAll( pageable );
  }

  @Override
  public List<PointInterest> findAll() {
    return pointInterestRepository.findAll();
  }

  @Override
  public List findAllNear(Long x, Long y, Long dist) {
    validParameter(x, y, dist);

    List<PointInterest> points = pointInterestRepository.findAll();
    return points.stream()
        .filter(o -> {
          Long catx = o.getX() - x;
          Long caty = o.getY() - y;
          Double result = Math.sqrt( catx * catx + caty * caty );
          return result <= dist ;
        })
        .collect( Collectors.toList() );
  }

  private void validParameter(Long x, Long y, Long dist) {
    try {
      Assert.notNull( x, "Point x is required" );
      Assert.isTrue( x >= 0, "The X-point must be >= 0" );
      Assert.notNull( y, "Point y is required" );
      Assert.isTrue( y >= 0, "The Y-point must be >= 0" );
      Assert.notNull( dist, "Distance is required" );
      Assert.isTrue( dist >= 0, "The distance must be >= 0" );
    }catch ( Exception e ){
      throw new PointInterestException( e.getMessage() );
    }
  }

  @Override
  public void save(PointInterest poi) {
    Assert.notNull(poi, "POI cannot be null");

    validPOI( poi );

    pointInterestRepository.save( poi );

    LOGGER.info( "Created poi " + poi.getId() );
  }



  private void validPOI( PointInterest poi ) {

    if( StringUtils.isEmpty( poi.getX() ) ||
        poi.getX() < 0 ){
      throw new PointInterestException( "The X-point is required and must be >= 0" );
    }

    if( StringUtils.isEmpty( poi.getY() ) ||
        poi.getY() < 0 ){
      throw new PointInterestException( "The Y-point is required and must be >= 0" );
    }

    if( StringUtils.isEmpty( poi.getName() ) ){
      throw new PointInterestException( "The name point is required" );
    }

  }

  @Override
  public List findAllNearUsingQuery(Long x, Long y, Long dist) {
    validParameter(x, y, dist);
    return pointInterestRepository.findAllNearUsingQuery( dist, x, y );
  }
}
