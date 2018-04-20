package test.dao;

import test.model.Course;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    //根据课程id，获取课程信息及所选学生信息
    Course selectCourseWithStudents(Integer id);
}