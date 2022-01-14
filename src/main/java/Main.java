import java.util.List;

public class Main {
    public static void main(String[] args) {
        AuthorHelper ah = new AuthorHelper();

        Author author1 = new Author();
        author1.setName("name1");
        author1.setLastName("LastName1");
        Author author2 = new Author();
        author2.setName("name2");
        author2.setLastName("LastName2");
        Author author3 = new Author();
        author3.setName("name3");
        author3.setLastName("LastName3");

//        ah.addAuthor(author1);
//        ah.addAuthor(author2);
//        ah.addAuthor(author3);

        ah.updateName();
    }
}
