package com.nnk.springboot.service;

import com.nnk.springboot.domain.dto.RuleNameDto;
import com.nnk.springboot.domain.entity.RuleName;
import com.nnk.springboot.domain.mapper.RuleNameMapper;
import com.nnk.springboot.repositories.RuleNameRepository;
import com.nnk.springboot.services.RuleNameService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class RuleNameServiceTest extends CoreServiceTest<RuleNameMapper, RuleNameRepository, RuleNameService, RuleNameDto, RuleName> {

    @MockBean
    @Getter
    private RuleNameRepository repository;

    @Autowired
    @Getter
    private RuleNameService service;

    @Autowired
    @Getter
    private RuleNameMapper mapper;

    @Override
    protected RuleName getTestEntity() {
        return new RuleName().builder().id(1).name("test").json("jsontest").description("abcd").template("testtempl")
                .sqlStr("sqlstr").sqlPart("sqlpart").build();
    }

    @Override
    protected List<RuleName> getListTestEntity() {
        return new ArrayList<>(Arrays.asList(
                new RuleName().builder().id(1).name("test1").json("jsontest1").description("abcd1").template("testtempl1")
                        .sqlStr("sqlstr1").sqlPart("sqlpart1").build(),
                new RuleName().builder().id(2).name("test2").json("jsontest2").description("abcd2").template("testtempl2")
                        .sqlStr("sqlstr2").sqlPart("sqlpart2").build(),
                new RuleName().builder().id(3).name("tes3").json("jsontest3").description("abcd3").template("testtempl3")
                        .sqlStr("sqlstr3").sqlPart("sqlpart3").build()
        ));
    }

    @Override
    protected RuleNameDto getTestModel() {
        return new RuleNameDto().builder().id(10).name("testdto").json("jsontestdto").description("abcddto").template("testtempldto")
                .sqlStr("sqlstrdto").sqlPart("sqlpartdto").build();
    }

    @Override
    protected RuleName getTestEntityToUpdate() {
        return new RuleName().builder().id(100).name("testupdt").json("jsontestupdt").description("abcdupdt").template("testtemplupdt")
                .sqlStr("sqlstrupdt").sqlPart("sqlpartupdt").build();
    }
}
