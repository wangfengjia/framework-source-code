package com.springboot.www;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
//@SpringBootTest
public class ApplicationTest {

//    @Autowired
    JdbcTemplate jdbcTemplate;

//    @Test
    public void contextLoads(){
        log.info(jdbcTemplate.toString());
    }
}
