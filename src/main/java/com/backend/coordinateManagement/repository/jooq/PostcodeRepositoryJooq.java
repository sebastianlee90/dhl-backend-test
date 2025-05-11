package com.backend.coordinateManagement.repository.jooq;

import static org.jooq.impl.DSL.*;

import java.util.List;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record4;
import org.jooq.SelectConditionStep;
import org.springframework.stereotype.Repository;

import com.backend.coordinateManagement.dto.PostcodeDTO;
import com.backend.coordinateManagement.util.LogUtil;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@AllArgsConstructor
public class PostcodeRepositoryJooq {
    DSLContext dsl;

    public List<PostcodeDTO> getPostcodeList() {
        log.info(LogUtil.ENTRY_REPOSITORY, "getCategoryList");
        Condition condition = noCondition();

        Field<Long> id = field("POS.id", Long.class).as("id");
        Field<String> postcode = field("POS.postcode", String.class).as("postcode");
        Field<String> latitude = field("POS.latitude", String.class).as("latitude");
        Field<String> longitude = field("POS.longitude", String.class).as("longitude");
            

        SelectConditionStep<Record4<Long, String, String, String>> query =
            dsl.select(id, postcode, latitude, longitude )
                .from(table("Postcode POS"))
                .where(condition);

        log.info(LogUtil.QUERY, query);

        return query.fetchInto(PostcodeDTO.class);
    }

    
}
