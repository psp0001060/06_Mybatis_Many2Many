package mybatis_helloworld;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import test.dao.StudentMapper;
import test.model.Course;
import test.model.Student;

import java.io.IOException;
import java.io.InputStream;

public class StudentTest {
	private String filename = "mybatis-config.xml";


	@Test
	public void testInsertStudent() {
		InputStream is;
		try {
			is = Resources.getResourceAsStream(filename);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder()
			.build(is);
			SqlSession session = factory.openSession();

			StudentMapper mapper = session.getMapper(StudentMapper.class);

			Student student = new Student();
			student.setName("zs");
			student.setAge(23);
			student.setSex("man");

			mapper.insertSelective(student);
			session.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    /**
     * 学生选择课程
     */
    @Test
	public void testStudentChooseCourse(){
        InputStream is;
        try {
            is = Resources.getResourceAsStream(filename);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder()
                    .build(is);
            SqlSession session = factory.openSession();

            StudentMapper mapper = session.getMapper(StudentMapper.class);

            Student student = new Student();
            student.setId(1);

            Course course = new Course();
            course.setId(2);

            mapper.studentChooseCourse(1, student, course);
            session.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询某个学生的个人信息及所选的课程信息
     */
    @Test
	public void testGetStudentByIdWithCourses(){
        InputStream is;
        try {
            is = Resources.getResourceAsStream(filename);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder()
                    .build(is);
            SqlSession session = factory.openSession();

            StudentMapper mapper = session.getMapper(StudentMapper.class);

            Student student =mapper.getStudentByIdWithCourses(1);

            System.out.println("姓名："+student.getName());
            for (Course course:
                 student.getCourses()) {
                System.out.println(course.getCourseCode()+"--"+course.getCourseName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
