package online.shixun.dao.imlp;

import org.springframework.stereotype.Repository;

import online.shixun.dao.StudentDao;
import online.shixun.model.Student;

@Repository("studentDaoImpl")
public class StudentDaoImpl extends DaoImpl<Student> implements StudentDao{

}
