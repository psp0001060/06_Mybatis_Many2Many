package mybatis_helloworld;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import test.dao.CourseMapper;
import test.model.Course;
import test.model.Student;

import java.io.IOException;
import java.io.InputStream;

public class CourseTest {
    private String filename = "mybatis-config.xml";

    @Test
    public void testInsertCourse() {
        InputStream is;
        try {
            is = Resources.getResourceAsStream(filename);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder()
                    .build(is);
            SqlSession session = factory.openSession();

            CourseMapper mapper = session.getMapper(CourseMapper.class);

            Course course =new Course();
            course.setId(2);
            course.setCourseCode("A02");
            course.setCourseName("Mysql");
            mapper.insertSelective(course);
            session.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
