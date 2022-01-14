import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import java.util.List;

public class AuthorHelper {
    private SessionFactory sessionFactory;

    public AuthorHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void addAuthor(Author author){
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(author);

        session.getTransaction().commit();

        session.close();
    }

    public void updateName(){
        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery<Author> cq = cb.createQuery(Author.class);

        Root<Author> root = cq.from(Author.class);

        cq.select(root);

        Query query = session.createQuery(cq);

        List<Author> authorList = query.getResultList();

        for (Author author : authorList) {
            if (author.getLastName().length() > 7) {
                session.beginTransaction();
                author.setName("1");
                session.save(author);
                session.getTransaction().commit();
            }
        }

        session.close();
    }

}
