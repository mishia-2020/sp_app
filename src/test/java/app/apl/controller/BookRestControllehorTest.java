package app.apl.controller;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class BookRestControllehorTest {



    @Test
    @DisplayName("2 * 3 = 6 であること😆")
    public void getBook_Ok() throws Exception{

        String expect = "aiue";
        assertEquals(expect,is("aiue"));

    }

}
