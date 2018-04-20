package test.dao;

import test.model.Course;
import test.model.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    //学生x选课y(向student_course表插入记录)
    int studentChooseCourse(Integer id,Student student, Course course);

    //查询student级联查询出所选的course并且组装成完整的对象
    Student getStudentByIdWithCourses(Integer id);
}