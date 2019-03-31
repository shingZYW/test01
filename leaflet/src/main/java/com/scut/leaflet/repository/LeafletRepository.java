package com.scut.leaflet.repository;

import com.scut.leaflet.dataobject.Leaflet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * ass we can!
 * created by shing
 * 2019-03-27 10:06
 */
public interface LeafletRepository extends JpaRepository<Leaflet,String> {
   Leaflet findByLeafletId(String LeafletId);
}
