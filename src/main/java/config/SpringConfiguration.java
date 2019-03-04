package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * 该类是一个配置类。他的作用和spring。xml作用一直
 * spring中的新注解
 * Configuration
 *      作用：指定一个配置类
 *      细节：当配置文件作为AnnotationConfigApplicationContext对象创建的参数时，该注解可以不写
 *  ComponentScan
 *      作用：通过指定注解来指定扫描的文件
 *
 *      属性：
 *          value:它和basePackages的作用是一样的，都是用于指定创建容器时要扫描的包
 *              我们可以使用此注解就等同于在xml中配置了
 *Bean注解
 *      作用：用于把当前方法的返回值作为bean对象存入spring的ioc容器中
 *      属性：
 *          name:用于指定bean的id，当不写时，默认值是当前方法的名称
 *      细节：
 *          当使用注解配置方法时，如果方法有参数，Spring框架会去容器中查找有没有可用的bean对象。查找的方式和Autowired注解的作用是一样的
 *          AnnotationConfigApplicationContext 进行类加载
 * Import
 *      作用：用于导入其他的配置类
 *      属性：
 *          value：用于指定其他配置类的字节码；当我们使用Import的注入后，有Import注解的类就是父配置类，而导入的其他的为自配置类
 * PropertySource
 *      作用：用于指定properties文件的位置
 *      属性：
 *          value:指定文件的名称和路径classpath:jdbcConfig.properties
 *              关键字classpath  表示类路径下的，假如有包，需要写包名
 *
 * Qualifier  当对多个数据库进行选择时候是用  @Qualifier("name") DataSource dataSource 进行选择
 */
//@Configuration
@ComponentScan("com.dx")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
