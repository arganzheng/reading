package me.arganzheng.project.reading;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:conf-spring/spring-datasource.xml", "classpath:conf-spring/spring-service.xml" })
@Transactional
public abstract class ReadingTestBase {
}
