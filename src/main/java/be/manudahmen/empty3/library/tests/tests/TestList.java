/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.manudahmen.empty3.library.tests.tests;

/*
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AssignableTypeFilter;

public class TestList {

    public static List<Class> main() {
        List<Class> listCls = new ArrayList<Class>();
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(true);
        provider.addIncludeFilter(new AssignableTypeFilter(TestObjetSub.class));

// scan in org.example.package
        Set<BeanDefinition> components = provider.findCandidateComponents("*");
        for (BeanDefinition component : components) {
            Class cls;
            //try {
                cls = Class.forName(component.getBeanClassName());
                listCls.add(cls);
                System.out.println(cls.getCanonicalName());
            //} catch (ClassNotFoundException ex) {
              //  Logger.getLogger(TestList.class.getName()).log(Level.SEVERE, null, ex);
            //}
        }
        return listCls;
    }
}
*/