package test;

import org.junit.Test;
import web1.EnteryServlet;

/**
 * @author haishao
 * @create 2020-05-19 14:57
 * @discript :
 */
public class EnteryServletTest {

    @Test
    public void selectBybookname() {
        EnteryServlet enteryServlet = new EnteryServlet();
        System.out.println(enteryServlet.selectBybookname("大话java"));
    }
}