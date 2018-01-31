package com.thoughtworks.mstorderservice.contract;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.StubFinder;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureStubRunner
public class GoodsClientTest {

    @Autowired
    private StubFinder stubFinder;

    @Test
    public void find_goods() throws IOException {
        int port = stubFinder.findStubUrl("com.thoughtworks", "mst-goods-service").getPort();
        // given:
        RestTemplate restTemplate = new RestTemplate();

        // when:
        ResponseEntity<List> personResponseEntity = restTemplate.getForEntity("http://localhost:" + port + "/api/goods", List.class);
        List<HashMap<String, Object>> responseBody = personResponseEntity.getBody();

        // then:
        BDDAssertions.then(personResponseEntity.getStatusCodeValue()).isEqualTo(200);
        BDDAssertions.then(responseBody.get(0).get("id")).isEqualTo(1);
        BDDAssertions.then(responseBody.get(0).get("name")).isEqualTo("iPhone SE2");
        BDDAssertions.then(responseBody.get(0).get("price")).isEqualTo(2095);

        BDDAssertions.then(responseBody.get(1).get("id")).isEqualTo(2);
        BDDAssertions.then(responseBody.get(1).get("name")).isEqualTo("iPhone X");
        BDDAssertions.then(responseBody.get(1).get("price")).isEqualTo(5095);
    }
}