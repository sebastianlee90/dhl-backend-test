package com.backend.coordinateManagement.repository.jooq;

import static org.jooq.impl.DSL.*;

import com.backend.coordinateManagement.dto.PaginationRequestDTO;
import com.backend.coordinateManagement.dto.postcode.PostcodeDTO;
import com.backend.coordinateManagement.dto.postcode.PostcodeRequestDTO;
import com.backend.coordinateManagement.util.CommonUtil;
import com.backend.coordinateManagement.util.JooqUtil;
import com.backend.coordinateManagement.util.LogUtil;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.SelectJoinStep;
import org.jooq.SelectLimitPercentAfterOffsetStep;
import org.jooq.SelectLimitPercentStep;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@AllArgsConstructor
public class PostcodeRepositoryJooq {
  DSLContext dsl;

  public List<PostcodeDTO> getPostcodeList(PostcodeRequestDTO requestDTO, PaginationRequestDTO pg) {
    log.info(LogUtil.ENTRY_REPOSITORY, "getPostcodeListJooq");
    Condition condition = noCondition();
    if (CommonUtil.isNotEmpty(requestDTO.postcode())) {
      condition = condition.and(field("POS.postcode").eq(requestDTO.postcode()));
    }

    Field<Long> id = field("POS.id", Long.class).as("id");
    Field<String> postcode = field("POS.postcode", String.class).as("postcode");
    Field<Double> latitude = field("POS.latitude", Double.class).as("latitude");
    Field<Double> longitude = field("POS.longitude", Double.class).as("longitude");

    SelectLimitPercentAfterOffsetStep<Record4<Long, String, Double, Double>> query =
        dsl.select(id, postcode, latitude, longitude)
            .from(table("Postcode POS"))
            .where(condition)
            .orderBy(JooqUtil.getOrderByField(pg.sort(), pg.sortDirection()))
            .offset((pg.page() - 1) * pg.size())
            .limit(pg.size());

    log.info(LogUtil.QUERY, query);
    Long startTime = System.currentTimeMillis();
    List<PostcodeDTO> result = query.fetchInto(PostcodeDTO.class);
    Long endTime = System.currentTimeMillis();
    log.info("Jooq Query executed in {} ms", (endTime - startTime));

    return result;
  }

  public Long getPostcodeListPages(PostcodeRequestDTO requestDTO) {
    log.info(LogUtil.ENTRY_REPOSITORY, "getPostcodeListPagesJooq");
    Condition condition = noCondition();

    if (CommonUtil.isNotEmpty(requestDTO.postcode())) {
      condition = condition.and(field("POS.postcode").eq(requestDTO.postcode()));
    }

    Field<Long> postcode = field("POS.postcode", Long.class).as("postcode");

    SelectJoinStep<Record1<Integer>> query =
        dsl.selectCount()
            .from(
                select(postcode)
                    .from(table("Postcode POS"))
                    .where(condition)
                    .groupBy(field("POS.postcode")));

    log.info(LogUtil.QUERY, query);
    Long startTime = System.currentTimeMillis();
    Long result = query.fetchOneInto(Long.class);
    Long endTime = System.currentTimeMillis();
    log.info("Jooq Query executed in {} ms", (endTime - startTime));

    return result;
  }

  public PostcodeDTO getPostcode(String requestPostcode) {
    log.info(LogUtil.ENTRY_REPOSITORY, "getPostcodeJooq");
    Condition condition = noCondition();
    if (CommonUtil.isNotEmpty(requestPostcode)) {
      condition = condition.and(field("POS.postcode").eq(requestPostcode));
    }

    Field<Long> id = field("POS.id", Long.class).as("id");
    Field<String> postcode = field("POS.postcode", String.class).as("postcode");
    Field<Double> latitude = field("POS.latitude", Double.class).as("latitude");
    Field<Double> longitude = field("POS.longitude", Double.class).as("longitude");

    SelectLimitPercentStep<Record4<Long, String, Double, Double>> query =
        dsl.select(id, postcode, latitude, longitude)
            .from(table("Postcode POS"))
            .where(condition)
            .limit(1);

    log.info(LogUtil.QUERY, query);
    Long startTime = System.currentTimeMillis();
    PostcodeDTO result = query.fetchOneInto(PostcodeDTO.class);
    Long endTime = System.currentTimeMillis();
    log.info("Jooq Query executed in {} ms", (endTime - startTime));

    return result;
  }
}
