package bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

import java.util.List;

public class BuddyApp {

    public static void main(String[] args) throws Exception {
        /*
        Class<?> dynamicBookClass = new ByteBuddy()
                .subclass(Book.class)
                .method(ElementMatchers.named("toString"))
                .intercept(FixedValue.value("Hello my Buddy!"))
                .make()
                .load(Book.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
                .getLoaded();

        Class[] parametersType = {String.class, String.class, int.class};

        System.out.println(dynamicBookClass.getConstructor(parametersType)
                .newInstance("title", "author", 2010));

         */
        List<Book> books = BooksGenerator.generate(100);
        BooksFilter booksFilter = new BooksFilter(books);
        List<Book> filteredBooks = booksFilter.onlyBooksOlderThan(20);
        System.out.println(filteredBooks.size());
    }
}
