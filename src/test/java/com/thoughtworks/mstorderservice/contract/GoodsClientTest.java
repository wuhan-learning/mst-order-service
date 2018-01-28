package com.thoughtworks.mstorderservice.contract;

import com.thoughtworks.mstorderservice.dto.GoodsDTO;
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

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureStubRunner
public class GoodsClientTest {

    @Autowired
    private StubFinder stubFinder;

    @Test
    public void find_goods() {
        int port = stubFinder.findStubUrl("com.thoughtworks", "mst-goods-service").getPort();
        // given:
        RestTemplate restTemplate = new RestTemplate();

        // when:
        ResponseEntity<GoodsDTO> personResponseEntity = restTemplate.getForEntity("http://localhost:" + port + "/api/goods", GoodsDTO.class);

        // then:
        BDDAssertions.then(personResponseEntity.getStatusCodeValue()).isEqualTo(200);
        BDDAssertions.then(personResponseEntity.getBody().getId()).isEqualTo(1L);
        BDDAssertions.then(personResponseEntity.getBody().getName()).isEqualTo("iPhone SE2");
        BDDAssertions.then(personResponseEntity.getBody().getPrice()).isEqualTo(2095);
    }
}