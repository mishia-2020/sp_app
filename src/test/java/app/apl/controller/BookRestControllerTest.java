package app.apl.controller;

import app.apl.resorce.BookResponse;
import app.domain.service.BookService;
import core.infrastructure.mapper.mrs.BookMapper;
import core.infrastructure.model.mrs.Book;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
class BookRestControllerTest {

    private MockMvc mockMvc;

    @Mock
    BookMapper mapper;

    @InjectMocks
    BookService service;

    @InjectMocks
    @Autowired
    BookRestController controller;

    @Rule // (3)
    public MockitoRule mockito = MockitoJUnit.rule();

    @Rule public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).alwaysDo(log()).build();
    }

    @Test
    public void getBook_Ok() throws Exception{

        List<Book> books = new ArrayList<>();
        Book book = new Book();
        book.setBookId("123");
        book.setBookName("本の名前123");
        books.add(book);
        book = new Book();
        book.setBookId("456");
        book.setBookName("本の名前456");
        books.add(book);


        when(mapper.selectByExample(null)).thenReturn(books);

//        mockMvc.perform(get("/books"))
//                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("2 * 3 = 6 であること😆")
    public void getBook_Ok1() throws Exception{

        String expect = "aiue";
        assertEquals(expect,is("aiue"));

    }

}
