package com.yellowstone.yellowboardbe.repository;

import com.yellowstone.yellowboardbe.entity.FavoriteEntity;
import com.yellowstone.yellowboardbe.entity.primaryKey.FavoritePk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<FavoriteEntity, FavoritePk> {
}
