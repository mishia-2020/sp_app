package app.apl.controller;

import app.apl.resorce.BookResponse;
import app.domain.service.BookService;
import ch.qos.logback.core.net.AutoFlushingObjectWriter;
import core.infrastructure.mapper.mrs.BookMapper;
import core.infrastructure.model.mrs.Book;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@SpringBootTest
@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
class BookRestControllerTest {
    @Autowired
    private BookRestController controller;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BookMapper mapper;

    @InjectMocks
    BookService service;

    private AutoFlushingObjectWriter json;


//    @Before
//    public void setup() {
//
//        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//    }

    @Test
    @DisplayName("本のリストを取得すること")
    public void getBook_Ok() throws Exception {

        List<Book> books = new ArrayList<>();
        Book book = new Book();
        book.setBookId("123");
        book.setBookName("本の名前123");
        assertTrue(books.add(book));
        book = new Book();
        book.setBookId("456");
        book.setBookName("本の名前456");
        books.add(book);

        List<BookResponse> resBooks = new ArrayList<>();
        books.forEach(rbook -> {

            BookResponse resBook = new BookResponse();
            resBook.setBookId(rbook.getBookId());
            resBook.setName(rbook.getBookName());
            resBooks.add(resBook);
        });

//        given(this.service.getBookList());
        given(this.mapper.selectByExample(null))
                .willReturn(books);
        MvcResult result = this.mockMvc.perform(get("/books")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.orders[0:].orderId",is(resBooks.get(0).getBookId())))
                .andDo(print())
                .andReturn();
        System.out.println("log★★★★★" + result);
//        mockMvc.perform(get("/books"))
//                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("2 * 3 = 6 であること😆")
    public void getBook_Ok1() throws Exception {

        String expect = "aiue";
        assertEquals(expect, is("aiue"));

    }

}
