package app;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonConfig {
    @Bean
    public Jackson2ObjectMapperBuilder objectMapperBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {

            @Override
            public void configure(ObjectMapper objectMapper) {
                super.configure(objectMapper);
                objectMapper.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
                // ここでObjectMapperに対する設定が書ける
            }
        };


        // 値がnullのプロパティーを出力しない
        builder.serializationInclusion(JsonInclude.Include.NON_NULL);

        // JSON出力時に改行・インデントを入れる
        builder.indentOutput(true);
        // builder.featuresToEnable(SerializationFeature.INDENT_OUTPUT);
        // builder.featuresToDisable(SerializationFeature.INDENT_OUTPUT); // 改行・インデントを入れない

        return builder;
    }
}
