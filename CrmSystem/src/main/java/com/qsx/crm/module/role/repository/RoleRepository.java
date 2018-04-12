
package com.qsx.crm.module.role.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qsx.crm.core.BaseRepository;
import com.qsx.crm.model.RoleModel;

@Repository
public interface RoleRepository extends CrudRepository<RoleModel, Long>{

}
