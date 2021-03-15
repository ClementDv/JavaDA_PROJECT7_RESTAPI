package com.nnk.springboot.service;

import com.nnk.springboot.domain.dto.CurvePointDto;
import com.nnk.springboot.domain.entity.CurvePoint;
import com.nnk.springboot.domain.mapper.CurvePointMapper;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.services.CurvePointService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class CurvePointServiceTest extends CoreServiceTest<CurvePointMapper, CurvePointRepository, CurvePointService, CurvePointDto, CurvePoint> {

    @MockBean
    @Getter
    private CurvePointRepository repository;

    @Autowired
    @Getter
    private CurvePointService service;

    @Autowired
    @Getter
    private CurvePointMapper mapper;

    @Override
    protected CurvePoint getTestEntity() {
        return new CurvePoint().builder().id(1).curveId(1).term(200.00).value(1000.10).build();
    }

    @Override
    protected List<CurvePoint> getListTestEntity() {
        return new ArrayList<>(Arrays.asList(
                new CurvePoint().builder().id(1).curveId(1).term(200.00).value(1000.10).build(),
                new CurvePoint().builder().id(2).curveId(2).term(314.00).value(00.10).build(),
                new CurvePoint().builder().id(3).curveId(3).term(9900.02).value(100.10).build()
        ));
    }

    @Override
    protected CurvePointDto getTestModel() {
        return new CurvePointDto().builder().id(2).curveId(2).term(10.00).value(100.10).build();
    }

    @Override
    protected CurvePoint getTestEntityToUpdate() {
        return new CurvePoint().builder().id(10).curveId(10).term(9900.02).value(100.10).build();
    }
}
