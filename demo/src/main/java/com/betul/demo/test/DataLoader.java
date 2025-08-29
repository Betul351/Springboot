package com.betul.demo.test;

import com.betul.demo.entity.Book;
import com.betul.demo.entity.Student;
import com.betul.demo.repository.BookRepository;
import com.betul.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    /*
    private final BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        bookRepository.save(new Book("İnsan Neyle Yaşar?", "Tolstoy"));

    }

 */
    private final StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        Student student= new Student();
        student.setName("Poyraz");

        Book book1 = new Book();
        book1.setTitle("Sefiller-I");
        book1.setStudent(student);

        Book book2 = new Book();
        book2.setTitle("Sefiller-II");
        book2.setStudent(student);

        student.setBooks(List.of(book1,book2));
        studentRepository.save(student);
    }
}
