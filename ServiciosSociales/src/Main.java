import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author JuanJo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("ServiciosSocialesPU");
        EntityManager em = emf.createEntityManager();
                
        em.close();
    }
    
}
