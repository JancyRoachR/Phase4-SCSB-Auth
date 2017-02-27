package org.recap.repository;

import org.recap.model.jpa.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dharmendrag on 13/12/16.
 */
public interface PermissionsRepository extends JpaRepository<PermissionEntity,Integer> {

    PermissionEntity findByPermissionName(String permissionName);


}
