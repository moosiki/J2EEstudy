package online.shixun.dao.imlp;

import org.springframework.stereotype.Repository;

import online.shixun.dao.TeacherDao;
import online.shixun.model.Teather;

@Repository("teacherDaoImpl")
public class TeacherDaoImpl extends DaoImpl<Teather> implements TeacherDao{

}
