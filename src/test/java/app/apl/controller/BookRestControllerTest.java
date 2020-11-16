package app.apl.controller;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.any;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import app.JacksonConfig;
import app.apl.resorce.BookResponse;
import app.domain.service.BookService;
import core.infrastructure.mapper.mrs.BookMapper;
import core.infrastructure.model.mrs.Book;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration()
//@AutoConfigureMockMvc
@ContextConfiguration(classes = {JacksonConfig.class})
class BookRestControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

//    @Autowired
//    private BookRestController controller;


    @Mock
    BookMapper mapper;

    @Mock
    BookService service;

    @InjectMocks
    BookRestController bookRestController;

//    @Autowired
//    JsonConverter jsonConverter;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        // this.mockMvc = MockMvcBuilders.standaloneSetup(new AuthenticationCreateAccountController()).build();

        this.mockMvc = MockMvcBuilders.standaloneSetup(bookRestController).build();
//        .webAppContextSetup(this.wac)
    }


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
//        given(this.mapper.selectByExample(null))
//                .willReturn(books);
        MvcResult result = this.mockMvc.perform(get("/books"))
//                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                //.andExpect((ResultMatcher) jsonPath("$.orders[0:].orderId",is(resBooks.get(0).getBookId())))
                .andDo(print())
                .andReturn();
        System.out.println("log★★★★★" + result.getResponse().getContentAsString());

//        mockMvc.perform(get("/books"))
//                .andExpect(status().isOk());
//        jsonConverter.convertToStr(resBooks);
//        jsonConverter.convertToDto(result.getResponse().getContentAsString(),List.class);

    }

    @Test
    @DisplayName("本リストが0件の場合.Exceptionがthrowされること.")
    public void getBooks_list0() throws Exception {
        List<Book> books = null;
        Mockito.when(this.mapper.selectByExample(null)).thenReturn(books);
        MvcResult result = this.mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                //.andExpect((ResultMatcher) jsonPath("$.orders[0:].orderId",is(resBooks.get(0).getBookId())))
                .andDo(print())
                .andReturn();
    }


    @Test
    @DisplayName("2 * 3 = 6 であること😆")
    public void getBook_Ok1() throws Exception {

        String expect = "aiue";
        assertEquals(expect, is("aiue"));

    }

}
